package com.labuda.yfp;

import com.labuda.yfp.pact3.Pact3;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Converts YAML Pacts
 */
public class YamlPactConverter {

    private final static Logger logger = LoggerFactory.getLogger(YamlPactConverter.class);

    /**
     * Source path for YAML files
     */
    private final Path sourcePath;

    /**
     * Destination path for output files
     */
    private final Path destinationPath;

    /**
     * Flag for recursive YAML search
     */
    private final boolean recursive;

    /**
     * Constructor
     *
     * @param sourcePath source path for YAML files
     * @param destinationPath destination path for output files
     * @param recursive true if you want to search for YAML files recursively, false otherwise
     */
    public YamlPactConverter(String sourcePath, String destinationPath, boolean recursive) {
        this.sourcePath = Paths.get(sourcePath);
        this.destinationPath = Paths.get(destinationPath);
        this.recursive = recursive;
    }

    /**
     * Converts all YAML Pacts to JSON files
     */
    public void convertToJsonFiles() {
        Utils.getYamlFilesInPath(sourcePath, recursive).forEach(yamlPath -> {
            Pact3 pact3 = YamlPactReader.parsePact(yamlPath);
            try {
                Path newFilePath = Paths.get(destinationPath.toString(), sourcePath.relativize(yamlPath).getParent().toString());

                // Test whether the output folder exists
                if (Files.notExists(newFilePath)) {
                    Files.createDirectories(newFilePath);
                }

                Files.writeString(newFilePath.resolve(FilenameUtils.getBaseName(yamlPath.getFileName().toString()) + ".json"), PactToJson.convert(pact3), StandardOpenOption.CREATE);
            } catch (IOException e) {
                logger.error("Unable to write pact to output file...", e);
            }
        });
    }

}
