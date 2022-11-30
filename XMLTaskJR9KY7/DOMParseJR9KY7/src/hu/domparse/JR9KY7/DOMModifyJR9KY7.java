package hu.domparse.JR9KY7;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyJR9KY7 {

	public static void main(String[] args)
			throws IOException, ParserConfigurationException, TransformerException, SAXException {

		try {
			// File megnyit�sa
			File inputFile = new File("XMLJR9KY7.xml");

			// Dokumentum builderek l�tehoz�sa
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docfactory.newDocumentBuilder();

			// Dokumentum be�ll�t�sa
			Document doc = docBuilder.parse(inputFile);

			// Elemek megkeres�se tag n�v alapj�n
			Node pincer = doc.getElementsByTagName("pincer").item(0);
			Node rendeles = doc.getElementsByTagName("rendeles").item(0);
			Node hozzavalo = doc.getElementsByTagName("hozzavalo").item(0);
			Node asztal = doc.getElementsByTagName("asztal").item(0);
			Node kAlk = doc.getElementsByTagName("kAlk").item(0);

			NodeList pincerList = pincer.getChildNodes();
			NodeList rendelesList = rendeles.getChildNodes();
			NodeList hozzavaloList = hozzavalo.getChildNodes();
			NodeList asztalList = asztal.getChildNodes();
			NodeList kAlkList = kAlk.getChildNodes();

			// Pinc�r elemenen t�rt�n� m�dos�tas
			for (int i = 0; i < pincerList.getLength(); i++) {
				Node node = pincerList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					if ("nev".equals(element.getNodeName())) {
						if ("Kiss L�szl�".equals(element.getTextContent())) {
							element.setTextContent("Kovacs Gabor");
						}
					}
				}
			}

			// Rendel�s elemen t�rt�n� m�dos�tas
			for (int i = 0; i < rendelesList.getLength(); i++) {
				Node node = rendelesList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					if ("etelAr".equals(element.getNodeName())) {
						if ("6000".equals(element.getTextContent())) {
							element.setTextContent("10000");
						}
					}
				}
			}

			// Hozz�val� elemen t�rt�n� m�dos�tas
			for (int i = 0; i < hozzavaloList.getLength(); i++) {
				Node node = hozzavaloList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					if ("nev".equals(element.getNodeName())) {
						if ("Burgonya".equals(element.getTextContent())) {
							element.setTextContent("Krumpli");
						}
					}
				}
			}

			// Asztal elemen t�rt�n� m�dos�tas
			for (int i = 0; i < asztalList.getLength(); i++) {
				Node node = asztalList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					if ("emelet".equals(element.getNodeName())) {
						if ("1".equals(element.getTextContent())) {
							element.setTextContent("0");
						}
					}
				}
			}

			// Konyhai alkalmazott elemen t�rt�n� m�dos�tas
			for (int i = 0; i < kAlkList.getLength(); i++) {
				Node node = kAlkList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					if ("nev".equals(element.getNodeName())) {
						if ("Nagy S�ndor".equals(element.getTextContent())) {
							element.setTextContent("Arany Norbert");
						}
					}
				}
			}

			// Valtoztatasok kiirasa
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transf = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);
			System.out.println("Modositott fajl: ");
			StreamResult consoleResult = new StreamResult(System.out);
			transf.transform(source, consoleResult);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	} // end main

} // end class
