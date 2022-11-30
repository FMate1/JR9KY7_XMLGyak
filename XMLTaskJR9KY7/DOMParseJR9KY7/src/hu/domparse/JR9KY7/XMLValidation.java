package hu.domparse.JR9KY7;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidation {

	public static void main(String[] args) {
		
		if (validateXMLSchema("XMLSchemaJR9KY7.xsd", "XMLJR9KY7.xml")) {
			System.out.println("The XML document is validated!");
		} else {
			System.out.println("The XML document is NOT validated!");
		}

	} //end main
	
	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
		
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("XMLSchemaJR9KY7.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("XMLJR9KY7.xml")));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    } //end validateXMLSchema

} //end class
