package com.mlreceipt.scanner.processor.services.image;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.processor.common.ScanExecutorProperties;
import com.mlreceipt.scanner.processor.feignclients.DataFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private final String uploadPath;

    private ScanTaskEntity scanTaskEntity;
    private final DataFeignClient dataFeignClient;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public ImageServiceImpl(ScanExecutorProperties properties, DataFeignClient dataFeignClient) {
        this.uploadPath = properties.getUploadPath();
        this.dataFeignClient = dataFeignClient;
    }

    @Override
    public FileInputStream getImage(String uuid, String imageName) throws FileNotFoundException {
        Path path = Paths.get(this.uploadPath, uuid, imageName);
        return new FileInputStream(path.toFile());
    }
}
