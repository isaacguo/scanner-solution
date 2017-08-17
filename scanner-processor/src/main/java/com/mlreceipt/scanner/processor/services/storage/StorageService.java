package com.mlreceipt.scanner.processor.services.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    String store(String uuid, MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    boolean createFolder(String uuid);
}
