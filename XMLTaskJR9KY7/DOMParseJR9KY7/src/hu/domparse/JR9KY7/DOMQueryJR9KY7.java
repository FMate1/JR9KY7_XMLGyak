package hu.domparse.JR9KY7;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryJR9KY7 {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

		try {
			// XML file kiválasztása
			File inputFile = new File("XMLJR9KY7.xml");

			// Dokumentum builderek létehozása
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Dokumentumok beállítása
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// Gyökérelem meghatározása, konzolon feltüntetése
			System.out.println("---------------------");
			System.out.print("Gyokerelem: ");
			System.out.println(doc.getDocumentElement().getNodeName());

			// 1. Lekérdezés fõ részének meghatározása
			NodeList nList1 = doc.getElementsByTagName("pincer");
			System.out.println("---------------------");
			System.out.println("\n------------------------------------");
			System.out.println("1. Pincerek adatainak lekerdezese:");
			System.out.println("------------------------------------");

			// Iterálás az elemeken és adott elemek kiíratása a konzolra
			for (int temp = 0; temp < nList1.getLength(); temp++) {
				Node nNode = nList1.item(temp);
				System.out.println("\nAktualis elem :");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					System.out.print("Pincer ID: ");
					System.out.println(element.getAttribute("pID"));
					NodeList pincerNameList = element.getElementsByTagName("nev");
					NodeList pincerFizList = element.getElementsByTagName("fizetes");
					NodeList pincerKorList = element.getElementsByTagName("kor");

					for (int count = 0; count < pincerNameList.getLength(); count++) {
						Node node1 = pincerNameList.item(count);
						Node node2 = pincerFizList.item(count);
						Node node3 = pincerKorList.item(count);

						Element pincerNev = (Element) node1;
						System.out.print("Pincer neve: ");
						System.out.println(pincerNev.getTextContent());

						Element pincerFiz = (Element) node2;
						System.out.print("Pincer fizetese: ");
						System.out.println(pincerFiz.getTextContent());

						Element pincerKor = (Element) node3;
						System.out.print("Pincer kora: ");
						System.out.println(pincerKor.getTextContent());
					}
				}
			}

			// 2. Lekérdezés fõ részének meghatározása
			NodeList nList2 = doc.getElementsByTagName("kAlk");
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("2. Konyhai alkalmazottak neve es telefonszamanak lekerdezese:");
			System.out.println("---------------------------------------------------------------");

			// Iterálás az elemeken és adott elemek kiíratása a konzolra
			for (int temp = 0; temp < nList2.getLength(); temp++) {
				Node nNode = nList2.item(temp);
				System.out.println("\nAktualis elem :");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					System.out.print("Konyhai alkalmazott ID: ");
					System.out.println(element.getAttribute("kID"));
					NodeList kAlkNameList = element.getElementsByTagName("nev");
					NodeList kAlkTelszamList = element.getElementsByTagName("telefonszam");

					for (int count = 0; count < kAlkNameList.getLength(); count++) {
						Node node1 = kAlkNameList.item(count);
						Node node2 = kAlkTelszamList.item(count);

						Element kAlkNev = (Element) node1;
						System.out.print("Konyhai alkalmazott neve: ");
						System.out.println(kAlkNev.getTextContent());

						Element kAlkTelszam = (Element) node2;
						System.out.print("Konyhai alkalmazott telefonszama: ");
						System.out.println(kAlkTelszam.getTextContent());
					}
				}
			}

			// 3. Lekérdezés fõ részének meghatározása
			NodeList nList3 = doc.getElementsByTagName("rendeles");
			System.out.println("\n----------------------------");
			System.out.println("3. Rendelesek vegosszege:");
			System.out.println("----------------------------");

			// Iterálás az elemeken és adott elemek kiíratása a konzolra
			for (int temp = 0; temp < nList3.getLength(); temp++) {
				Node nNode = nList3.item(temp);
				System.out.println("\nAktualis elem :");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					System.out.print("Rendeles ID: ");
					System.out.println(element.getAttribute("rID"));
					NodeList etelArList = element.getElementsByTagName("etelAr");
					NodeList italArList = element.getElementsByTagName("italAr");

					for (int count = 0; count < etelArList.getLength(); count++) {
						Node node1 = etelArList.item(count);
						Node node2 = italArList.item(count);

						Element rEtelAr = (Element) node1;
						Element rItalAr = (Element) node2;
						System.out.print("Rendeles vegosszege: ");
						System.out.println(Integer.parseInt(rEtelAr.getTextContent())
								+ Integer.parseInt(rItalAr.getTextContent()));
					}
				}
			}

			// 4. Lekérdezés fõ részének meghatározása
			NodeList nList4 = doc.getElementsByTagName("elkeszit");
			System.out.println("\n---------------------------------------------------");
			System.out.println("4. Rendelesek azonositoja, ahol fozes szukseges:");
			System.out.println("---------------------------------------------------");

			// Iterálás az elemeken és adott elemek kiíratása a konzolra
			for (int temp = 0; temp < nList4.getLength(); temp++) {
				Node nNode = nList4.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					NodeList fozesList = element.getElementsByTagName("fozes");

					for (int count = 0; count < fozesList.getLength(); count++) {
						Node node = fozesList.item(count);

						Element fozes = (Element) node;

						if (fozes.getTextContent().equalsIgnoreCase("igen")) {
							System.out.println("\nID-k: " + element.getAttribute("rID"));
						}
					}
				}
			}

			// 5. Lekérdezés fõ részének meghatározása
			NodeList nList5 = doc.getElementsByTagName("pincer");
			System.out.println("\n---------------------------------------");
			System.out.println("5. Pincerek, akik 24 evnel idosebbek:");
			System.out.println("---------------------------------------");

			// Iterálás az elemeken és adott elemek kiíratása a konzolra
			for (int temp = 0; temp < nList5.getLength(); temp++) {
				Node nNode = nList5.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					NodeList pincerNameList = element.getElementsByTagName("nev");
					NodeList pincerKorList = element.getElementsByTagName("kor");

					for (int count = 0; count < pincerNameList.getLength(); count++) {
						Node node1 = pincerNameList.item(count);
						Node node2 = pincerKorList.item(count);

						Element pincerNev = (Element) node1;
						Element pincerKor = (Element) node2;

						if (Integer.parseInt(pincerKor.getTextContent()) > 24) {
							System.out.println("\nPincer neve: " + pincerNev.getTextContent());
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	} // end main

} // end class
