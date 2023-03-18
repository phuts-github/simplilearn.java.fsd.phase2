package com.simplilearn.http.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaGETExample {
    public static void main(String[] args) throws IOException {
        JavaGETExample obj = new JavaGETExample();
        obj.getRequest();

    }

    public void getRequest() throws IOException {
        String url = "https://reqres.in/api/products/3?id=3";
//        String url = "https://google.comm";
        URL urlForGetRequest = new URL(url);
        String read = null;
        HttpURLConnection connection = (HttpURLConnection)urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("userId","bond007");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());
            BufferedReader bfr = new BufferedReader(isrObj);
            StringBuffer responseStr = new StringBuffer();
            while ((read = bfr.readLine()) !=null ) {
                responseStr.append(read);
            }
            bfr.close();
            connection.disconnect();
            System.out.println("JSON String Results is: \n" + responseStr);

        }
        else {
            System.out.println("GET Request id not work");
        }
    }

}
