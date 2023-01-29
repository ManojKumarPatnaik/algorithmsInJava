package My_Learning.xmlParseModule;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParseDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load the input XML document, parse it and return an instance of the
		// Document class.
		Document document = builder.parse(new File("D:\\LearningDSA\\Java_Learning\\ujjwal_Learning\\src\\com\\ujjwal_Learning\\xmlParseModule\\Employees.xml"));
		
		List<Employee> employees = new ArrayList<Employee>();
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		System.out.println("NodeLength = "+nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;

				// Get the value of the ID attribute.
				String ID = node.getAttributes().getNamedItem("ID").getNodeValue();

				// Get the value of all sub-elements.
				String firstname = elem.getElementsByTagName("Firstname").item(0).getChildNodes().item(0)
						.getNodeValue();

				String lastname = elem.getElementsByTagName("Lastname").item(0).getChildNodes().item(0).getNodeValue();

				Integer age = Integer
						.parseInt(elem.getElementsByTagName("Age").item(0).getChildNodes().item(0).getNodeValue());

				Double salary = Double.parseDouble(
						elem.getElementsByTagName("Salary").item(0).getChildNodes().item(0).getNodeValue());

				employees.add(new Employee(ID, firstname, lastname, age, salary));
			}
		}

		// Print all employees.
		for (Employee empl : employees)
			System.out.println(empl.toString());
	}
}
