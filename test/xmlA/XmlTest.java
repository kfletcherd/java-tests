package test.xml;

import test.xml.ReadHandle;
//import test.xml.ReadHandleFactory;
//import test.xml.factories.Factory;
//import test.xml.factories.FactoryA;

import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

class XmlTest {

	public static void main(String[] a){
		doReadHandle();
		//doReadHandleFactory();
	}

	private static void doReadHandle(){
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			ReadHandle handle = new ReadHandle();

			// Parses the xml file utilizing the DefaultHandler class
			parser.parse("test/xml/testdata.xml", handle);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


/*
	// I think it's time to rethink this... having one generic factory doesnt play cleanly
	// Perhaps an abstract read handle to handle parsing tags/attributes and each individual
	// 'factory' implements and overrides the characters() method, and each factory type
	// just needs to be in seperate xml files instead of trying to all-in-one everything
	private static void doReadHandleFactory(){
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			ArrayList<Factory> store = new ArrayList<Factory>();
			ReadHandleFactory handle = new ReadHandleFactory(store);
			handle.addFactory("tagA", FactoryA); // How to pass a class reference?

			// Parses the xml file utilizing the DefaultHandler class
			parser.parse("test/xml/testAFactory.xml", handle);

			((FactoryA) store.get(0)).echo();
			((FactoryA) store.get(1)).echo();

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
*/

}

