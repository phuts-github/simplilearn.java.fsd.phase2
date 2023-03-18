package com.simplilearn.http.post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaPOSTExample {
    public static void main(String[] args) throws IOException {
        JavaPOSTExample postOBJ = new JavaPOSTExample();
        postOBJ.postRequest();

    }
    public void postRequest() throws IOException {
        final String messageContents = "{" +
                "\n" + "\"userId\":007, \r\n" + "\"id\":001,\r\n" +
                "\"title\": \"JAVA POST REQUEST\",\r\n" +
                "\"body\":\"POST REQUEST IS USED TO CREATE A RESOURCE AT SERVER SIDE.\""
                + "\n}";
        System.out.println(messageContents);

        //fake server for testing purpose
        //      - https://jsonplaceholder.typicode.com/
        
        //define url
        String url = "https://jsonplaceholder.typicode.com/posts";

        //covert to Java url
        URL urlOBJ = new URL(url);

        //connection
        HttpURLConnection postCon = (HttpURLConnection) urlOBJ.openConnection();
        postCon.setRequestMethod("POST");
        postCon.setRequestProperty("userId", "abcde");
        postCon.setRequestProperty("Content-Type", "application/json");
        postCon.setDoOutput(true);

        OutputStream outputObj = postCon.getOutputStream();
        outputObj.write(messageContents.getBytes());

        //flush before closing output stream
        outputObj.flush();
        outputObj.close();

        int responseCode = postCon.getResponseCode();
        System.out.println("Response from Server :\n");
        System.out.println("Response from POST :\n\t" + responseCode);
        System.out.println("Response from POST message:\n\t" + postCon.getResponseMessage());

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            InputStreamReader inpStrRdr = new InputStreamReader(postCon.getInputStream());
            BufferedReader brd = new BufferedReader(inpStrRdr);
            String input = null;
            StringBuffer sbfr = new StringBuffer();
            while ((input = brd.readLine()) !=null) {
                sbfr.append(input);
                postCon.disconnect();
            }
            System.out.println(sbfr.toString());
        }
        else{
            System.out.println("POST did not work");
        }
    }
}
