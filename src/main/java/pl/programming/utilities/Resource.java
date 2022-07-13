package pl.programming.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Resource {
    public static FileInputStream getResource(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }
}