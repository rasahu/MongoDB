package com.example.cogni.aws.initializer;


import com.example.cogni.aws.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppInitializer implements CommandLineRunner {

    private final FileUploadService fileUploadService;

    @Override
    public void run(String... args) {
        fileUploadService.uploadFileToS3Bucket();
    }
}
