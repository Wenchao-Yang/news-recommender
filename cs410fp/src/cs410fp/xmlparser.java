
package cs410fp;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;



public class xmlparser {

	public static void main(String[] args) {
	    try {
	    	 
	    	File fXmlFile = new File("C:/Users/sjiang23/workspace/cs410fp/data/text.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);
	     
	    	doc.getDocumentElement().normalize();
	     
	    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	     
	    	NodeList nList = doc.getElementsByTagName("item");
	     
	    	System.out.println("----------------------------");
	     
	    	for (int temp = 0; temp < nList.getLength(); temp++) {
	     
	    		Node nNode = nList.item(temp);
	     
	    		System.out.println("\nCurrent Element :" + nNode.getNodeName());
	     
	    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	     
	    			Element eElement = (Element) nNode;
	    			String title=eElement.getElementsByTagName("title").item(0).getTextContent();
	    			System.out.println("title : " + title);
	    			String link=eElement.getElementsByTagName("link").item(0).getTextContent();
	    			System.out.println("link : " + link);
	    			String date=eElement.getElementsByTagName("pubDate").item(0).getTextContent();
	    			System.out.println("date : " + date);
	    			String description=eElement.getElementsByTagName("description").item(0).getTextContent();
	    			System.out.println("description : " + description);
	    			String command="wget "+link;
	                Runtime rt = Runtime.getRuntime();
	                Process proc = rt.exec(command);
	                int exitVal = proc.waitFor();
	                System.out.println("Process exitValue: " + exitVal);

	    		}
	    	}
	        } catch (Exception e) {
	    	e.printStackTrace();
	        }
		
	}

}
