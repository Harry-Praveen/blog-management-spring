package com.example.blog.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;

// import java.util.Collections;

@Service
public class OpenAIService {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    private final String apiUrl = "https://api.openai.com/v1/completions";

    public String summarizeText(String content) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "text-davinci-003");
        requestBody.put("prompt", "Summarize this:\n" + content);
        requestBody.put("max_tokens", 50);

        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonResponse = new JSONObject(response.getBody());
            return jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text").trim();
        } else {
            return "Failed to generate summary";
        }
    }
}
