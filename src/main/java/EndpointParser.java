import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EndpointParser {

    private static Map<String,String> getSparqlEndpoints(){
        String listUrl = "http://sparqles.ai.wu.ac.at/api/endpoint/list";
        Map<String,String> map = new HashMap<>();

        try {
            String response = HttpHandler.sendGetRequest(listUrl,false);
            JSONObject obj = new JSONObject("{response:" + response + "}");

            JSONArray array = obj.getJSONArray("response");
            for(int i=0;i<array.length();i++){
                JSONObject tmp = array.getJSONObject(i);
                String label = tmp.getJSONArray("datasets").getJSONObject(0).get("label").toString();
                String uri = tmp.get("uri").toString();

                map.put(uri,label);
            }

            return map;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }

    private static Map<String,Boolean> getEndpointStatus(){
        String availableUrl = "http://sparqles.ai.wu.ac.at/api/availability";
        Map<String,Boolean> map = new HashMap<>();

        try {
            String response = HttpHandler.sendGetRequest(availableUrl,false);
            JSONObject obj = new JSONObject("{response:" + response + "}");

            JSONArray array = obj.getJSONArray("response");
            for(int i=0;i<array.length();i++){
                String uri = array.getJSONObject(i).getJSONObject("endpoint").get("uri").toString();
                boolean upNow = array.getJSONObject(i).get("upNow").toString().equals("true") ? true : false;

                map.put(uri,upNow);
            }

            return map;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }

    public static Map<String,String> getAvailableEndpoints(){
        Map<String,String> listOfEndpoints = getSparqlEndpoints();
        Map<String,Boolean> statusOfEndpoints = getEndpointStatus();
        Map<String,String> availableEndpoints = new HashMap<>();

        Iterator<String> it = statusOfEndpoints.keySet().iterator();
        while(it.hasNext()){
            String currentUri = it.next();
            if(statusOfEndpoints.get(currentUri) == true){
                String label = listOfEndpoints.get(currentUri) == null ? "unknown label" : listOfEndpoints.get(currentUri);
                availableEndpoints.put(currentUri,label);
            }
        }

        return availableEndpoints;
    }
}
