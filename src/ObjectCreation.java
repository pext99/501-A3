import java.io.*;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ObjectCreation {
	public static void main(String[] args){
		Element company = new Element("serialized");
		Document doc = new Document();
		doc.setRootElement(company);
		
		//System.out.println(doc.getRootElement());
		
		Element staff = new Element("staff");
		staff.setAttribute(new Attribute("id", "1"));
		staff.addContent(new Element("firstname").setText("ryan"));
		
		staff.addContent(new Element("lastname").setText("eggold"));
		
		staff.addContent(new Element("salary").setText("199999"));
		
		doc.getRootElement().addContent(staff);
		
		Element staff2 = new Element("staff");
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, System.out);
			//xmlOutput.output(doc, new FileWriter("newxmlfile.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
