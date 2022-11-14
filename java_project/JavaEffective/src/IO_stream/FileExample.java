package IO_stream;

import java.io.*;

public class FileExample {
    public static void main(String args[]) throws IOException {
        File file = new File("./", "newCodestates.txt");
        file.createNewFile();

        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getCanonicalPath()); // 절대경로
        System.out.println(file.canWrite());
    }
}
