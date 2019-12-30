package com.example.servingwebcontent;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsWeb {

    @SuppressWarnings("Duplicates")
    public List<String> lenkertyp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/lenkertyp");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        List<String> typs= new ArrayList();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            String s= lenker.replaceAll("[\\[\\](){}\"]","");
            typs = Arrays.asList(s.split(","));
            typs.forEach(x->System.out.println(x));


        } else {
            System.out.println("GET NOT WORKED");
        }
        return typs;
    }


}
