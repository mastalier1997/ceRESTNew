package com.example.servingwebcontent;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Overview {
     String handlebar;
     String gear;
     String material;
     String handle;
     String POST_URL = "https://www.maripavi.at/bestellung";
    private  final String USER_AGENT = "Mozilla/5.0";

    public void setHandle(String grip) {
        this.handle = grip;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
    }

    public String getMaterial() {
        return material;
    }

    public String getHandle() {
        return handle;
    }

    public String getGear() {
        return gear;
    }

    public String getHandlebar() {
        return handlebar;
    }

    public void order() throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        String POST_PARAMS="griff="+ handle +"&lenkertyp="+handlebar+"&material="+material+"&schaltung="+gear;

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == 201) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }


}
