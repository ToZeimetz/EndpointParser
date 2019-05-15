import Parser.EndpointParser;

import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start to get available endpoints");
        Map<String,String> map = EndpointParser.getAvailableEndpoints();

        System.out.println("Start printing results");
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String uri = it.next();
            System.out.println(map.get(uri) + ": " + uri);
        }
    }
}
