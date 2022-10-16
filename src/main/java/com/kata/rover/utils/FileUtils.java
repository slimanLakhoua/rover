package com.kata.rover.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class FileUtils {

    public static List<String> readLinesFromFile(String fileName) throws URISyntaxException, IOException {

        var path = Paths.get(Objects.requireNonNull(FileUtils.class.getClassLoader()
                .getResource(fileName)).toURI());

        try (var stream = Files.lines(path)) {
            return stream.collect(toList());
        }
    }
}
