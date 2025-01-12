package com.clovasentiment.test.sentiment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Service
public class SentmintService {

    //감정분석
    public void semtmints(String textValue){

        System.out.println("service 텍스트 값: " + textValue);
        String url = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze";
        //앱 등록 시 발급받은 ID
        String clientID = "c5akbhlc2l";
        //앱 등록 시 발급 받은
        String clientSecret ="XRsPEyKtBSi13hCE8yxhCKCTxvL8JR3D6lXb0cpd";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-NCP-APIGW-API-KEY-ID", clientID);
        headers.set("X-NCP-APIGW-API-KEY", clientSecret);

        // 데이터 구성
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            // 객체를 JSON 문자열로 변환
            requestBody = objectMapper.writeValueAsString(Map.of("content", textValue));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseBody = responseEntity.getBody();
              //  ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);

                Map<String, Object> document = (Map<String, Object>) responseMap.get("document");
                String sentiment = (String) document.get("sentiment");

                Map<String, Object> confidence = (Map<String, Object>) document.get("confidence");
                Double positiveConfidence = (Double) confidence.get("positive");

                System.out.println("Document Sentiment: " + sentiment);
                System.out.println("Positive Confidence: " + positiveConfidence);
                System.out.println(responseBody);
            } else {
                System.err.println("Error: " + responseEntity.getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}