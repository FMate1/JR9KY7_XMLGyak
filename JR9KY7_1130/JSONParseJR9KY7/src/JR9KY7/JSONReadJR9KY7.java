package JR9KY7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReadJR9KY7 {

    public static void main(String[] args) {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(new FileReader("vizsgakJR9KY7.json"));

            JSONArray vizsgaList = (JSONArray) obj;
            System.out.println(vizsgaList);

            //Iterate over employee array
            vizsgaList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    } //end main

    private static void parseEmployeeObject(JSONObject employee) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("vizsgak_JR9KY7/vizsga");

        //Get employee first name
        String firstName = (String) employeeObject.get("kurzus");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("helyszin");
        System.out.println(lastName);

        //Get employee last name
        String nap = (String) employeeObject.get("idopont/nap");
        System.out.println(nap);

        //Get employee last name
        String tol = (String) employeeObject.get("idopont/tol");
        System.out.println(tol);

        //Get employee last name
        String ig = (String) employeeObject.get("idopont/ig");
        System.out.println(ig);

        //Get employee website name
        String website = (String) employeeObject.get("oktato");
        System.out.println(website);

        //Get employee website name
        String jegy = (String) employeeObject.get("jegy");
        System.out.println(jegy);
    }

} //end class
