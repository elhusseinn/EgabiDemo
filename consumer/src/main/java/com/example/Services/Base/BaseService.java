package com.example.Services.Base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseService {

    @Autowired
    RestTemplate restTemplate;

    public abstract String getUrl();
    public abstract HttpMethod getHttpMethod();

    public Map<String, String> getCustomHeader(){
        return new HashMap<>();
    }

    public Object callService(Class<?> responseType, Object requestObject){

        return callService(getUrl(), getHttpMethod(), responseType, getCustomHeader(), requestObject);
    }


     private Object callService(String url, HttpMethod method, Class<?> responseType, Map<String , String> headers,Object requestObject){
        HttpHeaders httpHeaders = new HttpHeaders();
        // set the headers
        if(headers!=null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpHeaders.add(header.getKey(), header.getValue());
            }
        }
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity  entity = requestObject != null ? new HttpEntity<>(requestObject,httpHeaders) : new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<?> exchange = restTemplate.exchange(url, method, entity, responseType);
            return exchange.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}
