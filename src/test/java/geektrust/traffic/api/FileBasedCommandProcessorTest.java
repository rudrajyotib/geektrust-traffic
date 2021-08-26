package geektrust.traffic.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileBasedCommandProcessorTest {

    @Test
    public void shouldProcessFile() throws IOException {
        Path commandFile = Paths.get("src", "test", "resources", "command-success");
        FileBasedCommandProcessor fileBasedCommandProcessor
                = new FileBasedCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertEquals("TUKTUK ORBIT1", fileBasedCommandProcessor.processFile());
    }

    @Test
    public void shouldThrowExceptionWhenFileNotFound() {
        FileBasedCommandProcessor fileBasedCommandProcessor
                = new FileBasedCommandProcessor("Gibberish Path");
        assertThrows(IllegalArgumentException.class, fileBasedCommandProcessor::processFile);
    }

    @Test
    public void shouldThrowExceptionWhenPathIsNotFile() {
        Path commandFile = Paths.get("src", "test", "resources");
        FileBasedCommandProcessor fileBasedCommandProcessor
                = new FileBasedCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertThrows(IllegalArgumentException.class, fileBasedCommandProcessor::processFile);
    }


}