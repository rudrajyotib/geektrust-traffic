package geektrust.traffic;

import geektrust.traffic.api.FileBasedCommandProcessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileBasedCommandProcessor fileBasedCommandProcessor
                = new FileBasedCommandProcessor(args[0]);
        System.out.println(fileBasedCommandProcessor.processFile());
    }
}
