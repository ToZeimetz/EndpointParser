import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpHandler {
    private final static String USER_AGENT = "Mozilla/5.0";

    private static String handleRedirect(HttpURLConnection con, boolean debug) throws Exception {
        String url = con.getHeaderField("Location");
        String cookies = con.getHeaderField("Set-Cookie");

        URL obj = new URL(url);
        HttpURLConnection newCon = (HttpURLConnection) obj.openConnection();

        return sendGetRequest(url,debug);
    }

    public static String sendGetRequest(String url, boolean debug) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        if(debug){
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response Message: " +  con.getHeaderField("Location"));
        }

        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader response = new BufferedReader(new InputStreamReader(con.getInputStream()));
            return IOUtils.toString(response);
        } else if (responseCode == HttpURLConnection.HTTP_MOVED_PERM
                || responseCode == HttpURLConnection.HTTP_MOVED_TEMP){

            return handleRedirect(con,debug);
        } else {
            return "ERROR";
        }
    }
}
