package JR9KY7;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReadJR9KY7 {

    public static void main(String[] args) {

        JSONObject Jobj = new JSONObject();
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("vizsgakF58KQ8.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            Jobj.put("root", jsonObject.get("root"));

            String jsonText = Jobj.toString();
            System.out.println(jsonText);


        } catch (IOException |  ParseException e) {
            e.printStackTrace();
        }
    } //end main



} //end class
