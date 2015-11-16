import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Deserializer {
   public static void main(String[] args){

      try {	
         File inputFile = new File("f:\\file.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("object");
         NodeList fList = doc.getElementsByTagName("field");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Node fNode = fList.item(temp);
            System.out.println("\nElement :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Class: "  + eElement.getAttribute("class"));
               System.out.println("ID: "  + eElement.getAttribute("id"));
            }
               if(fNode.getNodeType() == Node.ELEMENT_NODE){
            	   Element eElement = (Element) fNode;
            	   System.out.println("field name: " + eElement.getAttribute("name"));
            	   System.out.println("field declaring class: " + eElement.getAttribute("declaringclass"));
            	   System.out.println("Value: " + eElement.getElementsByTagName("value").item(0).getTextContent());
               }
               
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}