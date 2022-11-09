package xpathjr9ky7;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;

public class xPathJR9KY7 {

	public static void main(String[] args) {
		
		try {
			File xmlFile = new File("studentJR9KY7.xml");
			
			//DocumentBuilder létrehozása
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.parse("studentJR9KY7.xml");
			
			document.getDocumentElement().normalize();
			
			//az XPath készítése
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Meg kell adni az elérési út kifejezést és a csomópont listát
			
			//Készítsünk egy listát, majd az xPath kifejezést le kell fordítani és ki kell értékelni.
			String expression1 = "/class/student";
			String expression2 = "/class/student[2]";
			String expression3 = "//student";
			String expression4 = "";
			NodeList nodeList = (NodeList) xPath.compile(expression3).evaluate(document, XPathConstants.NODESET);
			
			//A for ciklus segítségével a NodeList csomópontjain végig kell iterálni
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktuális elem: " + node.getNodeName());
				
				//Meg kell vizsgálni a csomópontot, tesztelni kell a subelement
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					//az id attribótumot ad vissza
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					
					//keresztnevet ad vissza
					System.out.println("Keresztnev: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					
					//vezeteknevet ad vissza
					System.out.println("Vezeteknev: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					
					//becenevet ad vissza
					System.out.println("Becenev: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					
					//kort ad vissza
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
					
				} //end if
				
			} //end for
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} 

	} //end main

} //end class
