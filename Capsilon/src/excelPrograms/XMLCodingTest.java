package excelPrograms;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLCodingTest extends BaseClass {

	@Test(description="Assignmnent2(Question3)")
	public void countStudents1() throws ParserConfigurationException, SAXException, IOException {
		BaseClass.readXml();
		NodeList nodeList = document.getElementsByTagName(Constants.STUDENT);
		int count = 0;
		System.out.print("PINS for Pune Students are ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName("city").item(0).getTextContent().equals(Constants.PUNE_CITY)) {
					count++;
					System.out.print(eElement.getElementsByTagName(Constants.PIN).item(0).getTextContent() + " ");
				}
			}
		}
		System.out.println();
		System.out.print("Total students from pune are :" + count);

	}

	@Test(description="Assignmnent2(Question3)")
	public void printCities2() throws ParserConfigurationException, SAXException, IOException {
		BaseClass.readXml();
		NodeList nodeList = document.getElementsByTagName(Constants.SALESMAN);
		System.out.println("Cities of all salesman are :");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				System.out.print("Salesman id : " + eElement.getAttribute(Constants.ID));
				System.out.println("  " + "City : " + eElement.getElementsByTagName(Constants.CITY).item(0).getTextContent());
			}
		}
	}

	@Test(description="Assignmnent2(Question3)")
	public void noOfSalesman4() throws ParserConfigurationException, SAXException, IOException {
		BaseClass.readXml();
		int count = 0;
		NodeList nodeList = document.getElementsByTagName(Constants.SALESMAN);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName(Constants.CITY).item(0).getTextContent().equals(Constants.THANE_CITY)) {
					count++;
				}
			}

		}
		System.out.print("Number of salesman having thane as their city is:" + count);

	}

	@Test(description="Assignmnent2(Question3)")
	public void professionalNames3() throws ParserConfigurationException, SAXException, IOException {
		BaseClass.readXml();
		NodeList nodeList = document.getElementsByTagName(Constants.PROFESSIONAL);
		System.out.print("Professionals names having solapur as their city are : ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName(Constants.CITY).item(0).getTextContent().equals(Constants.SOLAPUR_CITY)) {
					System.out.print(eElement.getElementsByTagName(Constants.NAME).item(0).getTextContent() + " , ");
				}
			}

		}

	}
}
