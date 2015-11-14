import java.io.*;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ObjectCreation {
	public static void main(String[] args){
		Element serialized = new Element("serialized");//create root element
		Document doc = new Document();
		doc.setRootElement(serialized);
		
		Element object = new Element("object");//create simple object
		object.setAttribute(new Attribute("class", "Zoo"));//2 attributes for simple object
		object.setAttribute(new Attribute("id", "0"));
		
		Element field = new Element("field");//create field
		field.setAttribute(new Attribute("name", "city"));//2 attributes for element object
		field.setAttribute(new Attribute("declaringclass", "Zoo"));
		field.addContent(new Element("value").setText("23.7"));//primitive field
		field.addContent(new Element("reference").setText("5"));//reference field
		
		Element arrayPrim = new Element("object");//create array element for primitives
		arrayPrim.setAttribute(new Attribute("class", "[C"));//the 3 attributes
		arrayPrim.setAttribute(new Attribute("id", "8"));
		arrayPrim.setAttribute(new Attribute("length", "5"));
		arrayPrim.addContent(new Element("value").setText("s"));//values of array (primitives)
		arrayPrim.addContent(new Element("value").setText("m"));
		arrayPrim.addContent(new Element("value").setText("i"));
		arrayPrim.addContent(new Element("value").setText("t"));
		arrayPrim.addContent(new Element("value").setText("h"));
		
		Element arrayRef = new Element("object");//create array element for references
		arrayRef.setAttribute(new Attribute("class", "[C"));//the 3 attributes
		arrayRef.setAttribute(new Attribute("id", "9"));
		arrayRef.setAttribute(new Attribute("length", "5"));
		arrayRef.addContent(new Element("reference").setText("1"));//values of array (reference)
		arrayRef.addContent(new Element("reference").setText("2"));
		arrayRef.addContent(new Element("reference").setText("3"));
		arrayRef.addContent(new Element("reference").setText("4"));
		arrayRef.addContent(new Element("reference").setText("5"));
		
		doc.getRootElement().addContent(object);
		doc.getRootElement().addContent(field);
		doc.getRootElement().addContent(arrayPrim);
		doc.getRootElement().addContent(arrayRef);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		
		try {
			xmlOutput.output(doc, System.out);
			xmlOutput.output(doc, new FileWriter("f:\\file.xml"));//stores output in a file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
