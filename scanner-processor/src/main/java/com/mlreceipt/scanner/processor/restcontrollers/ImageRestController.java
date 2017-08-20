package com.mlreceipt.scanner.processor.restcontrollers;

import com.mlreceipt.scanner.processor.services.image.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

@RestController
@RequestMapping("/images")
public class ImageRestController {

    private final ImageService imageService;

    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @ResponseBody
    @RequestMapping(value = "/{uuid}/{imageName}/", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("uuid") String uuid, @PathVariable("imageName") String imageName) throws IOException {

        InputStream in = this.imageService.getImage(uuid, imageName);
        return IOUtils.toByteArray(in);
    }
}
