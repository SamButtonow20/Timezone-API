package com.csc340f23.restapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class RestApiApplication {

    public static void main(String[] args) {
        timezoneAPI();
    }

    public static void timezoneAPI() {

        String url = "https://timezone.abstractapi.com/v1/current_time/?api_key=86ede000374d40849388d54307aff5b9&location=Oxford, United Kingdom";
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String jsonRaw = restTemplate.getForObject(url, String.class);


        try {
            JsonNode root = mapper.readTree(jsonRaw);
            double latitude = root.findValue("latitude").asDouble();
            double longitude = root.findValue("longitude").asDouble();
            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);

        } catch (Exception e) {
            System.out.println("Error with Timezone API");

        }

    }
}