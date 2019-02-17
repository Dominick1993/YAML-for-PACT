package com.labuda.yfp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple utility functions
 */
public class Utils {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Default path matcher for yaml files
     */
    private final static PathMatcher yamlPathMatcher = FileSystems.getDefault().getPathMatcher("glob:**.{yaml,yml}");

    /**
     * Retrieves a list of paths that contain YAML files
     *
     * @param source    source path
     * @param recursive true if you want to traverse child folders, false otherwise
     * @return List of paths, if none was found, or the path could not be open, it returns an empty list
     */
    public static List<Path> getYamlFilesInPath(Path source, boolean recursive) {
        List<Path> yamlFiles = new ArrayList<>();
        try {
            logger.trace("Searching for YAML contract files in " + source.toRealPath().toString());

            if (recursive) {
                yamlFiles = Files.walk(source).filter(yamlPathMatcher::matches).collect(Collectors.toList());
            } else {
                yamlFiles = Files.list(source).filter(yamlPathMatcher::matches).collect(Collectors.toList());
            }
        } catch (IOException e) {
            logger.error("Got an exception while trying to access the provided path = [" + source.toString() + "]");
        }
        logger.trace("Found files: " + yamlFiles);
        return yamlFiles;
    }

}
