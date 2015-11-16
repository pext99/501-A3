import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Serialization {
	
	public Serialization(SimpleObject simple) {
		Element serialized = new Element("serialized");//create root element
		Document doc = new Document();
		doc.setRootElement(serialized);
		
		String declaringClass = simple.getClass().getName();//get the class name
		/*int hash = declaringClass.hashCode();//get a unique id
		int positiveHash = Math.abs(hash);//so that there won't be a negative id
		String id = String.valueOf(positiveHash);//convert int to string*/
		String id = Integer.toHexString(System.identityHashCode(declaringClass));
		
		Element object = new Element("object");//create simple object
		object.setAttribute(new Attribute("class", declaringClass));
		object.setAttribute(new Attribute("id", id));
		//object.addContent(new Element("field").setAttribute("name", "asdf").setAttribute("city", "qwer"));
		doc.getRootElement().addContent(object);
		////////////////////////////////////////////////////////////////////////////////////////////////////simple = obj
		Field fieldArray[] = simple.getClass().getDeclaredFields();
		for(int i = 0; i < fieldArray.length; i++){
			String fieldName = fieldArray[i].getName();
			
			Element field = new Element("field");
			field.setAttribute(new Attribute("name", fieldName));
			field.setAttribute(new Attribute("declaringclass", declaringClass));
			if(fieldArray[i].getType().isPrimitive()){
				fieldArray[i].setAccessible(true);
				try {
					String value = String.valueOf(fieldArray[i].get(simple));
					//object.addContent(new Element("field").setAttribute("name", fieldName).setAttribute("declaringclass", declaringClass).addContent(new Element("value").setText(value)));
					field.addContent(new Element("value").setText(value));//primitive field
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}else{
				fieldArray[i].setAccessible(true);
				try {
					/*int refHash = simple.hashCode();
					int positiveRefHash = Math.abs(refHash);
					String hashInString = String.valueOf(positiveRefHash);*/
					String hashInString = Integer.toHexString(System.identityHashCode(simple));
					field.addContent(new Element("reference").setText(hashInString));//reference field
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			doc.getRootElement().addContent(field);
			
		}
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		
		try {
			xmlOutput.output(doc, System.out);
			xmlOutput.output(doc, new FileWriter("f:\\file.xml"));//stores the output in a file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Serialization(ReferenceObject reference) {
		Element serialized = new Element("serialized");//create root element
		Document doc = new Document();
		doc.setRootElement(serialized);
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, System.out);
			xmlOutput.output(doc, new FileWriter("f:\\file.xml"));//stores the output in a file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
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
			xmlOutput.output(doc, new FileWriter("f:\\file.xml"));//stores the output in a file
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	
		
	
}
