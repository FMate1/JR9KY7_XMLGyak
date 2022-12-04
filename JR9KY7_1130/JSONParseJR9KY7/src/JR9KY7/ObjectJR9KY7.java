package JR9KY7;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ObjectJR9KY7 {

    public static void main(String[] args) throws Exception {

        JSONObject Jobj = new JSONObject();
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("vizsgakJR9KY7.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            Jobj.put("root", jsonObject.get("root"));

            String jsonText = Jobj.toString();
            System.out.println(jsonText);


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Jobj.put("neptunkod", "JR9KY7");
        Jobj.put("hallgato", "Fekete Mate");
        Jobj.put("szak", "BI");
        System.out.println(Jobj);
    } //end main

} //end class
