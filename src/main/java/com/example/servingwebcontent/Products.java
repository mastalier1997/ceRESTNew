package com.example.servingwebcontent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;


public class Products {


    public MultiValuedMap<String, MultiValuedMap<String, String>> fahrradlenker= new ArrayListValuedHashMap<>();
    public MultiValuedMap<String, String> flatbarlenker= new ArrayListValuedHashMap<>();
    public MultiValuedMap<String, String> rennradlenker= new ArrayListValuedHashMap<>();
    public MultiValuedMap<String, String> bullhornlenker= new ArrayListValuedHashMap<>();


    @SuppressWarnings("Duplicates")
    public void lenkertyp() throws  IOException {
        ObjectMapper mapper = new ObjectMapper();


        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/lenkertyp");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i=0; i<list.size();i++){
                String s = list.get(i);
                if (s.contains("Flatbarlenker")){
                    fahrradlenker.put("Flatbarlenker", flatbarlenker);
                }else if (s.contains("Bullhornlenker")){
                    fahrradlenker.put("Bullhornlenker", bullhornlenker);
                }else{
                    fahrradlenker.put("Rennradlenker", rennradlenker);
                }
            }

        } else {
            System.out.println("GET NOT WORKED");
        }
    }


    @SuppressWarnings("Duplicates")
    public void  schaltung(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/schaltung?lenkertyp="+s);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i =0; i<list.size();i++){
                String s2 ="Schaltung";
                String s1 =list.get(i);
                if (s.contains("Flatbarlenker")){
                    flatbarlenker.put(s2,s1);
                }else if(s.contains("Bullhornlenker")){
                    bullhornlenker.put(s2,s1);
                }else{
                    rennradlenker.put(s2,s1);
                }


            }

        }

    }

    @SuppressWarnings("Duplicates")
    public void  material(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/material?lenkertyp="+ s);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i =0; i<list.size();i++){
                String s2 ="Material";
                String s1 =list.get(i);
                if (s.contains("Flatbarlenker")){
                    flatbarlenker.put(s2,s1);
                }else if(s.contains("Bullhornlenker")){
                    bullhornlenker.put(s2,s1);
                }else{
                    rennradlenker.put(s2,s1);
                }

            }

        }

    }

    @SuppressWarnings("Duplicates")
    public void  griff(String s, String c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/griff?material="+s);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i =0; i<list.size();i++){
                String s2 ="Griff";
                String s1 =list.get(i);
                if (s.contains("Carbon")){
                    s2= "Griff - Carbon";
                    Collection<String> fl= flatbarlenker.get("Material");
                    if (fl.contains("Carbon")&& c=="Flatbarlenker"){
                        flatbarlenker.put(s2,s1);
                    }
                    Collection<String> bl= bullhornlenker.get("Material");
                    if (bl.contains("Carbon") && c=="Bullhornlenker"){
                        bullhornlenker.put(s2,s1);
                    }

                    Collection<String> rl= rennradlenker.get("Material");
                    if (rl.contains("Carbon") && c=="Rennradlenker"){
                        rennradlenker.put(s2,s1);
                    }

                } else if (s.contains("Stahl")){
                    s2= "Griff - Stahl";

                    Collection<String> bl= bullhornlenker.get("Material");
                    if (bl.contains("Stahl")){
                        bullhornlenker.put(s2,s1);
                    }


                }else {
                    s2= "Griff - Aluminium";
                    Collection<String> fl= flatbarlenker.get("Material");
                    if (fl.contains("Aluminium") && c=="Flatbarlenker"){
                        flatbarlenker.put(s2,s1);
                    }
                    Collection<String> bl= bullhornlenker.get("Material");
                    if (bl.contains("Aluminium") && c=="Bullhornlenker"){
                        bullhornlenker.put(s2,s1);
                    }

                    Collection<String> rl= rennradlenker.get("Material");
                    if (rl.contains("Aluminium") && c=="Rennradlenker"){
                        rennradlenker.put(s2,s1);
                    }
                }

            }
        }

    }

}


