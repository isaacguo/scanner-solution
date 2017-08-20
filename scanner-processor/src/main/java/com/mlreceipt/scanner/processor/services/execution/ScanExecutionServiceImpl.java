package com.mlreceipt.scanner.processor.services.execution;

import com.mlreceipt.scanner.processor.common.ScanExecutorProperties;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.io.File;
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

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public ScanExecutionServiceImpl(TaskExecutor taskExecutor, ScanExecutorProperties properties) {
        this.taskExecutor = taskExecutor;
        this.scannerPath = properties.getScannerPath();
        this.scannerOutputPath = Paths.get(properties.getScannerOutputPath());
        this.uploadPath = properties.getUploadPath();
        this.scannerInputPath = Paths.get(properties.getScannerInputPath());
    }

    @Override
    public void execute(String imagePath) {
        taskExecutor.execute(new ScanTask(imagePath));
    }


    private class ScanTask implements Runnable {

        private Path fullImagePath;

        public ScanTask(String imagePath) {
            this.fullImagePath = Paths.get(uploadPath, imagePath);
        }

        public void run() {

            //delete files in input/output folder
            try {
                FileUtils.cleanDirectory(scannerInputPath.toFile());
                FileUtils.cleanDirectory(scannerOutputPath.toFile());

                FileUtils.copyFileToDirectory(fullImagePath.toFile(), scannerInputPath.toFile());

            } catch (IOException e) {
                e.printStackTrace();
            }


            if (!StringUtils.isEmpty(scannerPath)) {
                CommandLine cmdLine = new CommandLine(scannerPath);
                String[] arguments = {scannerInputPath.toString()};

                cmdLine.addArguments(arguments);

                DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

                //ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);
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
                logger.info("ScannerLocation is not specified.");
            }
        }
    }
}
