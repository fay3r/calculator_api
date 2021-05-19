package com.mycompany.labab.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpService {

    public static String getResult(double digit, double digit2, Main.Operations operation) throws Exception {

        final HttpClient client = HttpClientBuilder.create().build();
        final HttpGet request;
        if(operation == Main.Operations.add){
            request = new HttpGet("http://localhost:8080/labab/resources/calc/add/" + digit +"/" + digit2);
        } else if(operation == Main.Operations.subtract){
            request = new HttpGet("http://localhost:8080/labab/resources/calc/sub/" + digit +"/" + digit2);
        } else if(operation == Main.Operations.multiply){
            request = new HttpGet("http://localhost:8080/labab/resources/calc/mul/" + digit +"/" + digit2);
        } else if(operation == Main.Operations.divide){
            request = new HttpGet("http://localhost:8080/labab/resources/calc/div/" + digit +"/" + digit2);
        } else if(operation == Main.Operations.power){
            request = new HttpGet("http://localhost:8080/labab/resources/calc/pow/" + digit +"/" + digit2);
        } else if(operation == Main.Operations.sqrt){
            request = new HttpGet("http://localhost:8080/labab/resources/calc/sqrt/" + digit);
        } else {
            return "";
        }

        try {
            final HttpResponse response = client.execute(request);
            final HttpEntity entity = response.getEntity();
            final String json = EntityUtils.toString(entity);

            return json;

        } catch (IOException e) {
            throw new Exception("Problem z zwróceniem JSONA");
        }
    }
}
