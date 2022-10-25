package Sax_JR9KY7_1019;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


public class Xsd_JR9KY7 {

	public static void main(String[] args) {
		
		System.out.println("Jo? "+validateXMLSchema("FM_kurzusfelvetel.xsd", "FM_kurzusfelvetel.xml"));

	} //end main
	
	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("C:\\Eclipse\\Proj_2\\Sax_JR9KY7\\FM_kurzusfelvetel.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("C:\\Eclipse\\Proj_2\\Sax_JR9KY7\\FM_kurzusfelvetel.xml")));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

} //end class
