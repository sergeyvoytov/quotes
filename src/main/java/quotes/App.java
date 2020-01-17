/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;

public class App {

    public static void main(String[] args) throws IOException {

        goOnInterNetOrLocal();

    }

    public static String readingFile(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            return "File is not found";
        }
        String firstLine = scanner.nextLine();

        while (scanner.hasNext()) {
            firstLine += scanner.nextLine();
        }
//  System.out.println(firstLine);

        return firstLine;

    }

    public static String showRandomQuote(String firstLine) {
        Gson gson = new Gson();

        Quote[] quote1 = gson.fromJson(firstLine, Quote[].class);
        int randomNumber = ((int) (Math.random() * quote1.length) + 1);

        String result = String.valueOf(quote1[randomNumber]);
        System.out.println(result);

        return result;
    }


    public static String goOnInternet() throws IOException {

        Gson gson = new Gson();

        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection numConnection = (HttpURLConnection) url.openConnection();
        numConnection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(numConnection.getInputStream()));

        StringBuilder buildy = new StringBuilder();

        String firstLine = input.readLine();
        while (firstLine != null) {
            buildy.append(firstLine);
            firstLine = input.readLine();
        }

        String buildString = String.valueOf(buildy);
        QuoteWeb quoteFromWeb = gson.fromJson(buildString, QuoteWeb.class);
        addQuoteToJason(quoteFromWeb.toString());
        System.out.println(quoteFromWeb);
        return quoteFromWeb.toString();
    }


    public static void goOnInterNetOrLocal() {
        try {
            goOnInternet();
        } catch (IOException e) {

            String path = "src/main/resources/quotes.json";

            String firstLine = readingFile(path);
            showRandomQuote(firstLine);
        }
    }

    public static void addQuoteToJason (String quote){
        Gson gson = new Gson();

        String makeJson = gson.toJson(quote);


        FileWriter myWriter;


        try {
            myWriter = new FileWriter("src/main/resources/Newquotes.json");
            gson.toJson(quote, myWriter);
//            System.out.println((gson.toJson(quote, myWriter)));
            // analagous to save
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }




}