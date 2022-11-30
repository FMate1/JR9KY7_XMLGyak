package JR9KY7;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ObjectJR9KY7 {

    public static void main(String[] args) throws Exception {

        JSONObject obj = new JSONObject();

        obj.put("Nev: ", "Fekete Mate");
        obj.put("Neptunkod: ", "JR9KY7");
        obj.put("Szak: ", "BI");

        System.out.println(obj);

        List<String> list = new ArrayList<String>();
        list.add("Fekete Mate");
        list.add("JR9KY7");
        list.add("BI");
        // Konvertalas JSON tombre
        String jsonStr = JSONArray.toJSONString(list);
        System.out.println(jsonStr);
    } //end main

} //end class
