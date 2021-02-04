package test.xml;

import test.xml.ReadHandle;
import test.xml.factories.Factory;

import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class ReadHandleFactory extends DefaultHandler {

	private HashMap<String, Factory> factories;
	private Factory activeFactory;
	private Attributes activeAtts;
	private ArrayList<String> nesting;
	private ArrayList<Factory> externalStore;

	public ReadHandleFactory(ArrayList<Factory> store){
		super();
		nesting = new ArrayList<String>();
		externalStore = store;
	}

	public void addFactory(String tagName, Factory f){
		factories.put(tagName, f);
	}

	public void startElement(String uri, String localName, String qName, Attributes atts)
	throws SAXException {
		nesting.add(qName);
		activeAtts = atts;

		if(nesting.size() == 1)
			activeFactory = factories.get(qName).getNewInstance();
	}

	public void endElement(String uri, String localName, String qName)
	throws SAXException {
		nesting.remove(nesting.size() - 1);
		activeAtts = null;

		if(nesting.size() == 0)
			externalStore.add(activeFactory);
	}

	public void characters(char[] ch, int start, int length){
		String s = new String(ch, start, length);
		s = s.trim();

		if(activeAtts != null) 
			activeFactory.add(activeAtts);

		if(!s.isEmpty())
			activeFactory.add(nesting.get(nesting.size() - 1), s);
	}
}

