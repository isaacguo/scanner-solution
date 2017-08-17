package com.mlreceipt.scanner.processor.services.execution;

import com.mlreceipt.scanner.processor.common.ScanExecutorProperties;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ScanExecutionServiceImpl implements ScanExecutionService {


    private final Path scannerOutputPath;
    private final String scannerPath;
    private final TaskExecutor taskExecutor;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public ScanExecutionServiceImpl(TaskExecutor taskExecutor, ScanExecutorProperties properties) {
        this.taskExecutor = taskExecutor;
        this.scannerPath = properties.getScannerPath();
        this.scannerOutputPath = Paths.get(properties.getScannerOutputPath());
    }

    @Override
    public void execute(String imagePath) {
        taskExecutor.execute(new ScanTask(imagePath));
    }


    private class ScanTask implements Runnable {

        private String imagePath;

        public ScanTask(String imagePath) {
            this.imagePath = imagePath;
        }

        public void run() {
            if (!StringUtils.isEmpty(scannerPath)) {
                CommandLine cmdLine = new CommandLine(scannerPath);
                String[] arguments = {this.imagePath};

                cmdLine.addArguments(arguments);

                DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

                //ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);
                Executor executor = new DefaultExecutor();
                Path workingPath=Paths.get(scannerPath);

                logger.info("workingPath:"+workingPath.getParent().toString());

                executor.setWorkingDirectory(workingPath.getParent().toFile());
                executor.setExitValue(1);
                //executor.setWorkingDirectory(path2);
                //executor.setWatchdog(watchdog);
                try {
                    executor.execute(cmdLine, resultHandler);
                    resultHandler.waitFor();
                    logger.info("Execution finished.");


                    Path p = Paths.get(this.imagePath);
                    String fileName = p.getFileName().toString();

                    Path scannedTxtfile = scannerOutputPath.resolve(fileName);
                    logger.info("scannedTxtfile:" + scannedTxtfile.toString());

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
