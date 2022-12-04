package JR9KY7;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListJR9KY7 {

    public static void main(String[] args) {

        JSONObject Jobj = new JSONObject();

        Jobj.put("neptunkod", "JR9KY7");
        Jobj.put("hallgato", "Fekete Mate");

        JSONArray list = new JSONArray();
        list.add("BI");
        list.add("Mernokinfo");
        list.add("Teszt");

        Jobj.put("szak", list);

        String jsonText = Jobj.toString();
        System.out.println(jsonText);

    }

} // end class
