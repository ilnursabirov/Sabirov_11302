package hw4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Rewriter {

    public static void main(String[] args) {
        rewrite("src/hw4/file.txt",
                "src/hw4/newFile.txt");

    }
    public static void rewrite(String path, String newPath) {
        try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            Files.newInputStream(Paths.get(path)), StandardCharsets.UTF_8))) {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(Files.newOutputStream(Paths.get(newPath)), "windows-1251"));

            String line;
            while((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException | UnsupportedCharsetException e) {
            throw new RuntimeException(e);
        }
    }
    public static void rewrite2(String path, String newPath) throws UnsupportedEncodingException {
        String s = "aa";
        s.getBytes("windows-1251");
    }
}
