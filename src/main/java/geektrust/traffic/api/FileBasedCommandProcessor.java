package geektrust.traffic.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileBasedCommandProcessor {

    private final String path;

    public FileBasedCommandProcessor(String path) {
        this.path = path;
    }

    public String processFile() throws IOException {
        File commandFile = new File(this.path);
        if (!commandFile.exists()) {
            throw new IllegalArgumentException("Command file does not exist");
        }
        if (!commandFile.isFile()) {
            throw new IllegalArgumentException("Command file is not a file");
        }
        try (Stream<String> commandStream = Files.lines(Paths.get(this.path))) {
            return commandStream
                    .map(Command::calculateShortestPath)
                    .collect(Collectors.joining(" "));
        }

    }
}
