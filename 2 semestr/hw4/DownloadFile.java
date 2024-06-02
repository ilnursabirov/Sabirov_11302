package hw4;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFile {
    public static void main(String[] args) {
        String fileUrl = "https://i.pinimg.com/564x/ac/f5/b0/acf5b029c1667cba92d040316d6329ba.jpg";
        String savePath = "/Users/sabirovmlnurmarsovic/IdeaProjects/informatika/src/hw4/image.jpg";

        try {
            URL url = new URL(fileUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
            int len = connection.getContentLength();
            byte[] buffer = new byte[len];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();
            connection.disconnect();

            System.out.println("File downloaded super-puper.");
        } catch (Exception e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }
}
