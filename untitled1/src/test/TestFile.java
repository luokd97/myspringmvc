package test;

import java.io.File;
import java.io.IOException;

public class TestFile {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\learn\\aa\\bb.txt");
//        file.getParentFile().mkdirs();
        file.createNewFile();
        System.out.println(file.exists());
    }
}
