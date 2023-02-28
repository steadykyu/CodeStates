package IO_stream;

import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInput = new FileInputStream(
                    "C:\\Users\\kimkyuha\\Desktop\\CodeStatesGithub\\java_project\\JavaEffective\\src\\IO_stream\\codestates.txt"
            );
            int i=0;
            while((i = fileInput.read()) != -1){
                System.out.println((char) i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
