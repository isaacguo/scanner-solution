package com.mlreceipt.scanner.processor.services.image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public interface ImageService {

    FileInputStream getImage(String uuid, String imageName) throws FileNotFoundException;
}
