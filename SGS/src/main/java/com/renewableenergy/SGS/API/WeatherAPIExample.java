package com.renewableenergy.SGS.API;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renewableenergy.SGS.SgsApplication;

// https://openweathermap.org/
public class WeatherAPIExample {

     public static void main(String[] args) {
         WeatherAPIExample.getWindSpeed("Essen");

     }

     public static double getWindSpeed(String city) {

         double windSpeed = 0;
            try {
                String apiKey = "ed853239b37b3638c1872cfde9b74cd8";

                String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet(apiUrl);

                CloseableHttpResponse response = httpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();

                String jsonResponse = EntityUtils.toString(entity);

                // Konvertiere den JSON-String in ein JSON-Objekt

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(jsonResponse);

                // Extrahiere die Windgeschwindigkeit aus dem JSON-Objekt
                windSpeed = jsonNode.get("wind").get("speed").asDouble();

                System.out.println("Windgeschwindigkeit: " + windSpeed + city);


                response.close();
                httpClient.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
         return windSpeed;
     }
}
