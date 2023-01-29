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
import java.util.*;

public class SampleXMLParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();

			// Load the input XML document, parse it and return an instance of the
			// Document class.
			Document document = builder.parse(new File(
					"D:\\LearningDSA\\Java_Learning\\ujjwal_Learning\\src\\com\\ujjwal_Learning\\xmlParseModule\\Sample.xml"));

			List<String> tagList = getXmlTagList(document);
			System.out.println("Obtained Tag List :: \n" + tagList.toString());
			Map<String, String> tagValuesList = getXmlTagValue(document, tagList);

			System.out.println(document.getElementsByTagName(tagList.get(0)));
			
			
			
			for(Map.Entry<String,String> iData : tagValuesList.entrySet()) {
				System.out.println(iData.getKey()+" = "+iData.getValue());
			}
			
			
//			NodeList nodeList = document.getDocumentElement().getChildNodes();
//			
//			Element ele = document.getDocumentElement();
//			//System.out.println(ele.getNodeName()+" , "+ele.getTextContent());
//			
//			for(int i=0; i < nodeList.getLength(); i++) {
//				
//				Node node = nodeList.item(i);
//				
//				Element elem = (Element) node;
//				NodeList list = elem.getElementsByTagName("*");
//				for(int j = 0; j < list.getLength(); j++) {
//					Node n = list.item(j);
//					Element e = (Element) n;
//					
////					System.out.println("N :: "+n.getNodeName()+", "+(n.getNodeType()==Node.ELEMENT_NODE)); 
//					System.out.println("E :: "+e.getNodeName()+", "+(e.getNodeType()==Node.ELEMENT_NODE)); 
//
//				}
//				
//				
//				//if (node.getNodeType() == Node.ELEMENT_NODE)
//				
//			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Map<String, String> getXmlTagValue(Document document, List<String> tagList) {
		Map<String,String> map = new LinkedHashMap<>();
		
		List<String> ignoreTag = new ArrayList<>();
		
		ignoreTag.add("root");
		ignoreTag.add("page");
		ignoreTag.add("legende");
		ignoreTag.add("description");
		
		NodeList childList = document.getChildNodes();
		
		NodeList legendeList = document.getElementsByTagName("Legende");
		System.out.println("Legende len = "+legendeList.getLength());
		
		for(int i = 0; i < legendeList.getLength(); i++) {
			Node n = legendeList.item(i);
			
			NodeList nCh = n.getChildNodes();
			for(int j = 0; j < nCh.getLength(); j++) {
				Node nn = nCh.item(j);
				if(nn.getNodeType() == Node.ELEMENT_NODE) {
					Element ele = (Element) nn;
					System.out.println(ele.getNodeName().toString());
					
					//System.out.println(ele.getNodeName()+"="+ele.getElementsByTagName(ele.getNodeName()).item(0).getTextContent());
					System.out.println(ele.getNodeName()+"="+ele.getTextContent());

				}
			}
			
		}
		

		
		for(int i = 0; i < childList.getLength(); i++) {
			
			Node node = childList.item(i); // Root
			
			NodeList nChList = node.getChildNodes(); // Child of Root -> Page / Page

			for(int j = 0; j < nChList.getLength(); j++) {
				Node n = nChList.item(j);
				
				NodeList pgChList = n.getChildNodes();
				System.out.println("108 pgCh List = "+pgChList.getLength());
				for(int k = 0; k < pgChList.getLength(); k++) {
					Node pgN = pgChList.item(k);
					
					System.out.println(k+"="+pgN.getNodeName());
				}
			}
			
			
//				String value = elem.getElementsByTagName("Firstname").item(0).getChildNodes().item(0)
//				.getNodeValue();
			}
		
		return null;
	}

	private static List<String> getXmlTagList(Document document) {
		List<String> tagList = new LinkedList<>();
		List<String> ignoreTag = new ArrayList<>();

		ignoreTag.add("root");
		ignoreTag.add("page");
		ignoreTag.add("legende");
		ignoreTag.add("description");

		NodeList list = document.getElementsByTagName("*");
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element ele = (Element) list.item(i);
				String nodeName = ele.getNodeName();

				if (!ignoreTag.contains(nodeName.toLowerCase()))
					tagList.add(nodeName);

			}

		}
		return tagList;
	}

}
