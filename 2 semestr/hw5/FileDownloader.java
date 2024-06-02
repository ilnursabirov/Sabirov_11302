package hw5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

public class FileDownloader {
    private static final int MAX_THREADS = 8;
    private static final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
    private static final Map<String, DownloadTask> tasks = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (download <url> <file> or status <file>):");
            String command = scanner.next();
            if ("download".equalsIgnoreCase(command)) {
                String url = scanner.next();
                String filePath = scanner.next();
                startDownload(url, filePath);
            } else if ("status".equalsIgnoreCase(command)) {
                String filePath = scanner.next();
                showStatus(filePath);
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private static void startDownload(String url, String filePath) {
        if (tasks.containsKey(filePath)) {
            System.out.println("File is already being downloaded.");
            return;
        }

        DownloadTask task = new DownloadTask(url, filePath);
        tasks.put(filePath, task);
        executor.submit(task);
    }

    private static void showStatus(String filePath) {
        DownloadTask task = tasks.get(filePath);
        if (task != null) {
            System.out.println("Download status: " + task.getProgress() + "%");
        } else {
            System.out.println("File not found or not being downloaded.");
        }
    }

    private static class DownloadTask implements Runnable {
        private final String url;
        private final String filePath;
        private volatile int progress;

        public DownloadTask(String url, String filePath) {
            this.url = url;
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try {
                URL downloadUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) downloadUrl.openConnection();
                long contentLength = connection.getContentLengthLong();
                try (InputStream inputStream = connection.getInputStream();
                     FileOutputStream outputStream = new FileOutputStream(filePath)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long totalBytesRead = 0;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        totalBytesRead += bytesRead;
                        progress = (int) ((totalBytesRead * 100) / contentLength);
                    }
                }
                System.out.println("Download complete: " + filePath);
            } catch (IOException e) {
                System.out.println("Download failed: " + e.getMessage());
            } finally {
                tasks.remove(filePath);
            }
        }

        public int getProgress() {
            return progress;
        }
    }
}