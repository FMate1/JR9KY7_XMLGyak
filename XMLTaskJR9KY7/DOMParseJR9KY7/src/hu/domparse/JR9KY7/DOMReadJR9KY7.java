package hu.domparse.JR9KY7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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

public class DOMReadJR9KY7 {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		// Meglévõ xml fájl megnyitása és új létrehozása
		File xmlFile = new File("XMLJR9KY7.xml");
		File myFile = new File("XMLJR9KY71.xml");

		// Dokumentum builderek létehozása
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();

		// Dokumentumok beállítása
		Document doc = dBuilder.parse(xmlFile);
		Document doc2 = dBuilder.newDocument();

		// Gyökérelem meghatározása
		Element root = doc2.createElementNS("XMLJR9KY7", "etterem");
		doc2.appendChild(root);

		// Elemek létrehozása a meglévõ XML dokumentum és séma alapján
		root.appendChild(createPincer(doc2, "1", "Kis Zoltan", "240000", "25"));
		root.appendChild(createPincer(doc2, "2", "Nagy Albert", "245000", "24"));
		root.appendChild(createPincer(doc2, "3", "Toth Balazs", "228000", "22"));
		root.appendChild(createRendeles(doc2, "1", "1", "5600", "2500"));
		root.appendChild(createRendeles(doc2, "2", "2", "4100", "1500"));
		root.appendChild(createRendeles(doc2, "3", "3", "5900", "3500"));
		root.appendChild(createHozzavalo(doc2, "1", "Csirkehus", "2"));
		root.appendChild(createHozzavalo(doc2, "2", "Marhahus", "3"));
		root.appendChild(createHozzavalo(doc2, "3", "Borjuhus", "2"));
		root.appendChild(createAsztal(doc2, "1", "1", "igen", "2"));
		root.appendChild(createAsztal(doc2, "2", "0", "igen", "2"));
		root.appendChild(createAsztal(doc2, "3", "0", "igen", "4"));
		root.appendChild(createKAlk(doc2, "1", "Kiss Anita", "290000", "28", "06703579415"));
		root.appendChild(createKAlk(doc2, "2", "Nagy Anita", "320000", "32", "06200252585"));
		root.appendChild(createKAlk(doc2, "3", "Toth Anita", "210000", "21", "06305548644"));
		root.appendChild(createElkeszit(doc2, "1", "1", "40", "igen", "nem"));
		root.appendChild(createElkeszit(doc2, "2", "2", "70", "igen", "igen"));
		root.appendChild(createElkeszit(doc2, "3", "3", "45", "igen", "nem"));
		root.appendChild(createTartalmaz(doc2, "1", "1"));
		root.appendChild(createTartalmaz(doc2, "2", "2"));
		root.appendChild(createTartalmaz(doc2, "3", "3"));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();

		// Output kialakítása
		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		DOMSource source = new DOMSource(doc2);

		// Kiíratás
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, console);
		transf.transform(source, file);

		// Megnyitott xml file kezelése
		doc.getDocumentElement().normalize();

		// Gyökér elem kiíratás
		System.out.println("\nGyokerelem: " + doc.getDocumentElement().getNodeName());

		// Gyerek elemek listába rendezése
		NodeList pincerList = doc.getElementsByTagName("pincer");
		NodeList rendelesList = doc.getElementsByTagName("rendeles");
		NodeList hozzavaloList = doc.getElementsByTagName("hozzavalo");
		NodeList asztalList = doc.getElementsByTagName("asztal");
		NodeList kAlkList = doc.getElementsByTagName("kAlk");
		NodeList elkeszitList = doc.getElementsByTagName("elkeszit");
		NodeList tartalmazList = doc.getElementsByTagName("tartalmaz");

		// Fájlba írás
		StringWriter sw = new StringWriter();
		transf.transform(source, new StreamResult(sw));
		FileWriter fw = new FileWriter("file.txt");
		fw.write(sw.toString());
		fw.close();

		// Listák feltöltése
		for (int i = 0; i < pincerList.getLength(); i++) {

			Node pincerNode = pincerList.item(i);

			System.out.println("\nAktualis elem: " + pincerNode.getNodeName());

			if (pincerNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) pincerNode;
				String pID = elem.getAttribute("pID");

				Node node1 = elem.getElementsByTagName("nev").item(0);
				String nev = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("fizetes").item(0);
				String fizetes = node2.getTextContent();

				System.out.println("Pincer azonosito: " + pID);
				System.out.println("Nev: " + nev);
				System.out.println("Fizetes: " + fizetes);
			} // end if
		} // end for

		for (int i = 0; i < rendelesList.getLength(); i++) {

			Node rendelesNode = rendelesList.item(i);

			System.out.println("\nAktualis elem: " + rendelesNode.getNodeName());

			if (rendelesNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) rendelesNode;
				String rID = elem.getAttribute("rID");
				String pID = elem.getAttribute("pID");

				Node node1 = elem.getElementsByTagName("etelAr").item(0);
				String etelAr = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("italAr").item(0);
				String italAr = node2.getTextContent();

				System.out.println("Rendeles azonosito: " + rID);
				System.out.println("Pincer azonosito: " + pID);
				System.out.println("Etel(ek) ara: " + etelAr);
				System.out.println("Ital(ok) ara: " + italAr);
			} // end if
		} // end for

		for (int i = 0; i < hozzavaloList.getLength(); i++) {

			Node hozzavaloNode = hozzavaloList.item(i);

			System.out.println("\nAktualis elem: " + hozzavaloNode.getNodeName());

			if (hozzavaloNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) hozzavaloNode;
				String hID = elem.getAttribute("hID");

				Node node1 = elem.getElementsByTagName("nev").item(0);
				String nev = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("darabszam").item(0);
				String darabszam = node2.getTextContent();

				System.out.println("Hozzavalo azonosito: " + hID);
				System.out.println("Neve: " + nev);
				System.out.println("Darabszam: " + darabszam);
			} // end if
		} // end for

		for (int i = 0; i < asztalList.getLength(); i++) {
			
			Node asztalNode = asztalList.item(i);

			System.out.println("\nAktualis elem: " + asztalNode.getNodeName());

			if (asztalNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) asztalNode;
				String aID = elem.getAttribute("aID");

				Node node1 = elem.getElementsByTagName("emelet").item(0);
				String emelet = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("foglalt").item(0);
				String foglalt = node2.getTextContent();

				Node node3 = elem.getElementsByTagName("ferohely").item(0);
				String ferohely = node3.getTextContent();

				System.out.println("Asztal azonosito: " + aID);
				System.out.println("Emelet: " + emelet);
				System.out.println("Foglalt: " + foglalt);
				System.out.println("Ferohely: " + ferohely);
			} // end if
		} // end for

		for (int i = 0; i < kAlkList.getLength(); i++) {

			Node kAlkNode = kAlkList.item(i);

			System.out.println("\nAktualis elem: " + kAlkNode.getNodeName());

			if (kAlkNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) kAlkNode;
				String kID = elem.getAttribute("kID");

				Node node1 = elem.getElementsByTagName("nev").item(0);
				String nev = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("fizetes").item(0);
				String fizetes = node2.getTextContent();

				Node node3 = elem.getElementsByTagName("kor").item(0);
				String kor = node3.getTextContent();

				Node node4 = elem.getElementsByTagName("telefonszam").item(0);
				String telszam = node4.getTextContent();

				System.out.println("Konyhai alkalmazott azonosito: " + kID);
				System.out.println("Nev: " + nev);
				System.out.println("Fizetes: " + fizetes);
				System.out.println("Kor: " + kor);
				System.out.println("Telefonszam: " + telszam);
			} // end if
		} // end for

		for (int i = 0; i < elkeszitList.getLength(); i++) {

			Node elkeszitNode = elkeszitList.item(i);

			System.out.println("\nAktualis elem: " + elkeszitNode.getNodeName());

			if (elkeszitNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem1 = (Element) elkeszitNode;
				String rID = elem1.getAttribute("rID");

				Element elem2 = (Element) elkeszitNode;
				String kID = elem2.getAttribute("kID");

				Node node1 = elem1.getElementsByTagName("ido").item(0);
				String ido = node1.getTextContent();

				Node node2 = elem1.getElementsByTagName("sutes").item(0);
				String sutes = node2.getTextContent();

				Node node3 = elem1.getElementsByTagName("fozes").item(0);
				String fozes = node3.getTextContent();

				System.out.println("Rendeles azonosito: " + rID);
				System.out.println("Konyhai alkalmazott azonosito: " + kID);
				System.out.println("Elkeszitesi ido: " + ido);
				System.out.println("Sutes: " + sutes);
				System.out.println("Fozes: " + fozes);
			} // end if
		} // end for

		for (int i = 0; i < tartalmazList.getLength(); i++) {

			Node tartalmazNode = tartalmazList.item(i);

			System.out.println("\nAktualis elem: " + tartalmazNode.getNodeName());

			if (tartalmazNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem1 = (Element) tartalmazNode;
				String rID = elem1.getAttribute("rID");

				Element elem2 = (Element) tartalmazNode;
				String hID = elem2.getAttribute("hID");

				System.out.println("Rendeles azonosito: " + rID);
				System.out.println("Hozzavalo azonosito: " + hID);
			} // end if
		} // end for

	} // end main

	// A feltöltéshez szükséges függvények létrehozása
	private static Node createPincer(Document doc2, String pID, String nev, String fizetes, String kor) {
		Element pincer = doc2.createElement("pincer");

		pincer.setAttribute("pID", pID);
		pincer.appendChild(createPincerElement(doc2, "nev", nev));
		pincer.appendChild(createPincerElement(doc2, "fizetes", fizetes));
		pincer.appendChild(createPincerElement(doc2, "kor", kor));

		return pincer;
	} // end createPincer

	private static Node createPincerElement(Document doc2, String name, String value) {
		Element node = doc2.createElement(name);
		node.appendChild(doc2.createTextNode(value));

		return node;
	} // end createPincerElement

	private static Node createRendeles(Document doc2, String rID, String pID, String etelAr, String italAr) {
		Element rendeles = doc2.createElement("rendeles");

		rendeles.setAttribute("rID", rID);
		rendeles.setAttribute("pID", pID);
		rendeles.appendChild(createRendelesElement(doc2, "etelAr", etelAr));
		rendeles.appendChild(createRendelesElement(doc2, "italAr", italAr));

		return rendeles;
	} // end createRendeles

	private static Node createRendelesElement(Document doc2, String name, String value) {
		Element node = doc2.createElement(name);
		node.appendChild(doc2.createTextNode(value));

		return node;
	} // end createRendelesElement

	private static Node createHozzavalo(Document doc2, String hID, String nev, String darabszam) {
		Element hozzavalo = doc2.createElement("hozzavalo");

		hozzavalo.setAttribute("hID", hID);
		hozzavalo.appendChild(createHozzavaloElement(doc2, "nev", nev));
		hozzavalo.appendChild(createHozzavaloElement(doc2, "darabszam", darabszam));

		return hozzavalo;
	} // end createHozzavalo

	private static Node createHozzavaloElement(Document doc2, String name, String value) {
		Element node = doc2.createElement(name);
		node.appendChild(doc2.createTextNode(value));

		return node;
	} // end createHozzavaloElement

	private static Node createAsztal(Document doc2, String aID, String emelet, String foglalt, String ferohely) {
		Element asztal = doc2.createElement("asztal");

		asztal.setAttribute("aID", aID);
		asztal.appendChild(createAsztalElement(doc2, "emelet", emelet));
		asztal.appendChild(createAsztalElement(doc2, "foglalt", foglalt));
		asztal.appendChild(createAsztalElement(doc2, "ferohely", ferohely));

		return asztal;
	} // end createAsztal

	private static Node createAsztalElement(Document doc2, String name, String value) {
		Element node = doc2.createElement(name);
		node.appendChild(doc2.createTextNode(value));

		return node;
	} // end createAsztalElement

	private static Node createKAlk(Document doc2, String kID, String nev, String fizetes, String kor, String telszam) {
		Element kAlk = doc2.createElement("kAlk");

		kAlk.setAttribute("kID", kID);
		kAlk.appendChild(createKAlkElement(doc2, "nev", nev));
		kAlk.appendChild(createKAlkElement(doc2, "fizetes", fizetes));
		kAlk.appendChild(createKAlkElement(doc2, "kor", kor));
		kAlk.appendChild(createKAlkElement(doc2, "telefonszam", telszam));

		return kAlk;
	} // end createkAlk

	private static Node createKAlkElement(Document doc2, String name, String value) {
		Element node = doc2.createElement(name);
		node.appendChild(doc2.createTextNode(value));

		return node;
	} // end createKAlkElement

	private static Node createElkeszit(Document doc2, String rID, String kID, String ido, String sutes, String fozes) {
		Element elkeszit = doc2.createElement("elkeszit");

		elkeszit.setAttribute("rID", rID);
		elkeszit.setAttribute("kID", kID);
		elkeszit.appendChild(createElkeszitElement(doc2, "ido", ido));
		elkeszit.appendChild(createElkeszitElement(doc2, "sutes", sutes));
		elkeszit.appendChild(createElkeszitElement(doc2, "fozes", fozes));

		return elkeszit;
	} // end createElkeszit

	private static Node createElkeszitElement(Document doc2, String name, String value) {
		Element node = doc2.createElement(name);
		node.appendChild(doc2.createTextNode(value));

		return node;
	} // end createElkeszitElement

	private static Node createTartalmaz(Document doc2, String rID, String hID) {
		Element tartalmaz = doc2.createElement("tartalmaz");

		tartalmaz.setAttribute("rID", rID);
		tartalmaz.setAttribute("hID", hID);

		return tartalmaz;
	} // end createElkeszit

} // end class
