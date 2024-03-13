/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sn96g
 */
public class CurrencyConvertor {
    
    public static void main(String[] args) {
        
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter the basede Currency code (e.g., SLR)");
            String baseCurrency = reader.readLine().toUpperCase();
            
            System.out.println("Enter target currency code. (e.g., USD)");
            String targetCurrency = reader.readLine().toUpperCase();
            
            System.out.println("Enter amount to be converted:");
            double amount = Double.parseDouble(reader.readLine());
            
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;
            
            System.out.println("%.2f %s is equals to %.2f %s\n", amount,baseCurrency,convertedAmount
            ,targetCurrency);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws MalformedURLException, IOException{
        String apiKey = "YOUR_API_KEY"; // Replace this with your ExchangeRatesAPI.io API key
        String apiUrl = "https://api.exchangeratesapi.io/latest?base=" + baseCurrency + "&symbols=" + targetCurrency;

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONObject rates = jsonResponse.getJSONObject("rates");
        return rates.getDouble(targetCurrency);
    }
    
}
