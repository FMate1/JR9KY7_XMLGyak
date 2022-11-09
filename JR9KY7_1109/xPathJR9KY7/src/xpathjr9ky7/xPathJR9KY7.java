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
			
			//DocumentBuilder l�trehoz�sa
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.parse("studentJR9KY7.xml");
			
			document.getDocumentElement().normalize();
			
			//az XPath k�sz�t�se
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Meg kell adni az el�r�si �t kifejez�st �s a csom�pont list�t
			
			//K�sz�ts�nk egy list�t, majd az xPath kifejez�st le kell ford�tani �s ki kell �rt�kelni.
			String expression1 = "/class/student";
			String expression2 = "/class/student[2]";
			String expression3 = "//student";
			String expression4 = "";
			NodeList nodeList = (NodeList) xPath.compile(expression3).evaluate(document, XPathConstants.NODESET);
			
			//A for ciklus seg�ts�g�vel a NodeList csom�pontjain v�gig kell iter�lni
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktu�lis elem: " + node.getNodeName());
				
				//Meg kell vizsg�lni a csom�pontot, tesztelni kell a subelement
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					//az id attrib�tumot ad vissza
					System.out.println("Hallgat� ID: " + element.getAttribute("id"));
					
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
