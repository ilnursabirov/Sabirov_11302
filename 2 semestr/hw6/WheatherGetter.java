package hw6;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WheatherGetter {
    String apiForecast7days = "api.openweathermap.org/data/2.5/forecast/daily?lat={lat}&lon={lon}&cnt=7&appid=96072a258a7118d358aa337bbd2f1d41&units=metric&mode=json";
    String apiGeoBeforeCity = "http://api.openweathermap.org/geo/1.0/direct?q=";
    String apiGeoAfterCity = ",&limit=1&appid=96072a258a7118d358aa337bbd2f1d41";
    String api1dayBefore = "https://api.openweathermap.org/data/2.5/weather?q=";
    String api1dayAfter = "&appid=96072a258a7118d358aa337bbd2f1d41&units=metric";
    String key = "96072a258a7118d358aa337bbd2f1d41";
    public void inFile(String urlString, String fileCSV) {

        try(PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fileCSV, true)))){

            String jsonString = getApi(urlString);
            String valueCity = "name";
            String valueTemp = "temp";
            String valueWind = "speed";
            java.time.LocalDate date = java.time.LocalDate.now();
            writer.print(
                    extractValue(jsonString, valueCity)
                    + ";" + date
                    + ";" + extractValue(jsonString, valueTemp)
                    + ";" + extractValue(jsonString, valueWind) + "\n");
            System.out.println("Current temperature:" + extractValue(jsonString, valueTemp));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void app(String fileCSV) {
        Scanner scanner = new Scanner(System.in);

        try(PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileCSV, true)))){
            writer.print("city:;date:;temperature:;speed of wind:;\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        int i = 0;
        while(i < 7) {
            System.out.println("Enter your city or exit");
            String city = scanner.next();
            if (city.equals("exit")){
                break;
            }
            try {
                String lat = extractValue(getApi(apiGeoBeforeCity + city + apiGeoAfterCity), "lat");
                String lon = extractValue(getApi(apiGeoBeforeCity + city + apiGeoAfterCity), "lon");
                System.out.println("Coordinates:" + lat + ", " + lon);
                inFile("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&units=metric&appid=96072a258a7118d358aa337bbd2f1d41", "src/hw6/fileCSV.csv");
                i++;
                System.out.println("Current weather was successfully written in CSV file");
            } catch (Exception e) {
                System.out.println("Check your connection or try later");
            }
        }

    }


    private static String extractValue(String jsonString, String key) {
        int startIndex = jsonString.indexOf("\"" + key + "\":") + key.length() + 3; // +3 ��� ":"
        int endIndex = jsonString.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = jsonString.indexOf("}", startIndex);
        }
        return jsonString.substring(startIndex, endIndex);
    }
    private static String getApi(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        WheatherGetter wg = new WheatherGetter();
        wg.app("src/hw6/fileCSV.csv");
    }
}
