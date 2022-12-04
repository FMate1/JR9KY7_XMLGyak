package JR9KY7;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriteJR9KY7 {

    public static void main(String[] args) {
        JSONObject root = new JSONObject();

        root.put("_id", "JR9KY7");
        root.put("name", "vizsgak_JR9KY7");

        JSONObject vizsgak = new JSONObject();
        JSONArray vizsga = new JSONArray();

        // elsõ vizsga alkalom
        JSONObject vizsga1 = new JSONObject();
        vizsga1.put("kurzus", "Adatbazisrendszerek");
        vizsga1.put("helyszin", "A2");

        JSONObject idopont1 = new JSONObject();
        idopont1.put("nap", "2022.06.07");
        idopont1.put("tol", "12");
        idopont1.put("ig", "14");

        vizsga1.put("idopont", idopont1);
        vizsga1.put("oktato", "Dr. Kovács László");
        vizsga1.put("jegy", "4");

        vizsga.add(vizsga1);

        // második vizsga alkalom
        JSONObject vizsga2 = new JSONObject();
        vizsga2.put("kurzus", "Biztonsag és vedelem az informatikaban");
        vizsga2.put("helyszin", "L103");

        JSONObject idopont2 = new JSONObject();
        idopont2.put("nap", "2022.06.16");
        idopont2.put("tol", "11");
        idopont2.put("ig", "13");

        vizsga2.put("idopont", idopont2);
        vizsga2.put("oktato", "Wagner Gyorgy");
        vizsga2.put("jegy", "4");

        vizsga.add(vizsga2);

        // harmadik vizsga alkalom
        JSONObject vizsga3 = new JSONObject();
        vizsga3.put("kurzus", "Numerikus Analizis");
        vizsga3.put("helyszin", "T042");

        JSONObject idopont3 = new JSONObject();
        idopont3.put("nap", "2022.05.25");
        idopont3.put("tol", "11");
        idopont3.put("ig", "13");

        vizsga3.put("idopont", idopont3);
        vizsga3.put("oktato", "Dr. Foldvári Attila");
        vizsga3.put("jegy", "3");

        vizsga.add(vizsga3);

        // negyedik vizsga alkalom
        JSONObject vizsga4 = new JSONObject();
        vizsga4.put("kurzus", "SAP ABAP programozas");
        vizsga4.put("helyszin", "Info");

        JSONObject idopont4 = new JSONObject();
        idopont4.put("nap", "2022.05.31");
        idopont4.put("tol", "10");
        idopont4.put("ig", "12");

        vizsga4.put("idopont", idopont4);
        vizsga4.put("oktato", "Mihaly Krisztian");
        vizsga4.put("jegy", "4");

        vizsga.add(vizsga4);

        // ötödik vizsga alkalom
        JSONObject vizsga5 = new JSONObject();
        vizsga5.put("kurzus", "Java programozás");
        vizsga5.put("helyszin", "L102");

        JSONObject idopont5 = new JSONObject();
        idopont5.put("nap", "2022.05.20");
        idopont5.put("tol", "9");
        idopont5.put("ig", "11");

        vizsga5.put("idopont", idopont5);
        vizsga5.put("oktato", "Szucs Miklos");
        vizsga5.put("jegy", "3");

        vizsga.add(vizsga5);

        vizsgak.put("vizsga", vizsga);
        root.put("vizsgak", vizsgak);


        String jsonText = root.toString();
        System.out.println(jsonText);

        try {

            FileWriter file = new FileWriter("vizsgakJR9KY7_out.json");
            file.write(jsonText);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

} //end class
