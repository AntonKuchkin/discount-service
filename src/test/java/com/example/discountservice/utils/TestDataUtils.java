package com.example.discountservice.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Утильные работы с данными для тестов из подготовленных файлов
 */
public class TestDataUtils {
    /**
     * @param postfixPath path after resource/data/objects, without '/' character
     * @return json object as string
     * @throws IOException
     */
    public static String getJsonTestObjectAsString(String postfixPath) throws IOException {
        File file = new ClassPathResource("data/objects/" + postfixPath).getFile();
        return Files.readString(file.toPath());
    }
}
