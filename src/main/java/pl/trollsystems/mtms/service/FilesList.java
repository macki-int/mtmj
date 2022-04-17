package pl.trollsystems.mtms.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FilesList {
    public List<String> getFilesList(String path) {
        File file = new File(path);
//        List<String> files = Arrays.stream(file.list()).toList();
        List<String> files = Arrays.asList(file.list());

        return files;
    }
}
