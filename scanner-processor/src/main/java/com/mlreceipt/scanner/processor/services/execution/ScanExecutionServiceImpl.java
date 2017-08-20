package com.mlreceipt.scanner.processor.services.execution;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;
import com.mlreceipt.scanner.processor.common.ScanExecutorProperties;
import com.mlreceipt.scanner.processor.feignclients.DataFeignClient;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ScanExecutionServiceImpl implements ScanExecutionService {


    private final Path scannerOutputPath;
    private final String scannerPath;
    private final String uploadPath;

    private final TaskExecutor taskExecutor;
    private final Path scannerInputPath;
    private ScanTaskEntity scanTaskEntity;
    private final DataFeignClient dataFeignClient;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public ScanExecutionServiceImpl(TaskExecutor taskExecutor, ScanExecutorProperties properties, DataFeignClient dataFeignClient) {
        this.taskExecutor = taskExecutor;
        this.scannerPath = properties.getScannerPath();
        this.scannerOutputPath = Paths.get(properties.getScannerOutputPath());
        this.uploadPath = properties.getUploadPath();
        this.scannerInputPath = Paths.get(properties.getScannerInputPath());
        this.dataFeignClient=dataFeignClient;

    }

    @Override
    public void execute(String imagePath, ScanTaskEntity scanTaskEntity) {
        taskExecutor.execute(new ScanTask(imagePath));
        this.scanTaskEntity = scanTaskEntity;
    }


    private class ScanTask implements Runnable {

        private Path fullImagePath;

        public ScanTask(String imagePath) {
            this.fullImagePath = Paths.get(uploadPath, imagePath);
        }

        public void run() {

            //delete files in input/output folder
            if (!cleanScannerInputAndOutputFolders()) return;

            //execute scanner
            executeScanner();

            //update scanTaskEntity
            scanTaskEntity.getScanPairList().stream().forEach(r -> {
                String textFile=FilenameUtils.removeExtension(r.getImageName())+".txt";
                Path path=scannerOutputPath.resolve(textFile);
                r.setText(readFileText(path.toString()));
            });
            scanTaskEntity.setStatus(ScanTaskStatusEnum.SCANNED);
            dataFeignClient.insertScanTask(scanTaskEntity);
        }

        private String readFileText(String path) {
            StringBuilder contents = new StringBuilder();
            try {
                BufferedReader input = new BufferedReader(new FileReader(path));
                try {
                    String line = null;
                    while ((line = input.readLine()) != null) {
                        contents.append(line);
                        contents.append(System.getProperty("line.separator"));
                    }
                } finally {
                    input.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("contents.toString():" + contents.toString());
            return contents.toString();
        }

        private void executeScanner() {
            if (!StringUtils.isEmpty(scannerPath)) {
                CommandLine cmdLine = new CommandLine(scannerPath);
                String[] arguments = {scannerInputPath.toString()};

                cmdLine.addArguments(arguments);

                DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

                Executor executor = new DefaultExecutor();
                Path workingPath = Paths.get(scannerPath);

                logger.info("workingPath:" + workingPath.getParent().toString());

                executor.setWorkingDirectory(workingPath.getParent().toFile());
                executor.setExitValue(1);
                //executor.setWatchdog(watchdog);
                try {
                    executor.execute(cmdLine, resultHandler);
                    resultHandler.waitFor();
                    logger.info("Execution finished.");

                    /*
                    Path p = Paths.get(this.imagePath);
                    String fileName = p.getFileName().toString();

                    Path scannedTxtfile = scannerOutputPath.resolve(fileName);
                    logger.info("scannedTxtfile:" + scannedTxtfile.toString());
                    */

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                logger.info("Scanner location is not specified.");
            }
        }

        private boolean cleanScannerInputAndOutputFolders() {
            try {

                FileUtils.cleanDirectory(scannerInputPath.toFile());
                FileUtils.cleanDirectory(scannerOutputPath.toFile());


                String[] children = this.fullImagePath.toFile().list();
                for (int i = 0; i < children.length; i++) {
                    FileUtils.copyFileToDirectory(new File(this.fullImagePath.toFile(), children[i]), scannerInputPath.toFile());
                }

            } catch (IOException e) {
                logger.error(e.getMessage());
                logger.error(e.getStackTrace().toString());
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}
