package test.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class ReadHandle extends DefaultHandler{

	// Store of keys to track nesting
	private ArrayList<String> nesting;

	private Attributes activeAtts;

	// Instantiate the ArrayList
	public ReadHandle(){
		super();
		nesting = new ArrayList<String>();
	}

	// Triggers when a new opening tag is found
	// qName = Qalified Name (tag name)
	public void startElement(String uri, String localName, String qName, Attributes atts)
	throws SAXException {
		nesting.add(qName);
		activeAtts = atts;
	}

	// Triggers when a closing tag is found
	public void endElement(String uri, String localName, String qName)
	throws SAXException {
		nesting.remove(nesting.size() - 1);
		activeAtts = null;
	}

	// Prints the inner values of properties (after startElement and before endElement)
	// Also seems to print all whitespace characters which really trashes the output
	public void characters(char[] ch, int start, int length){
		String s = new String(ch, start, length);
		s = s.trim();

		if(!s.isEmpty()){
			System.out.println(nesting.toString() + ": " + s);

			if(activeAtts != null){
				int attLength = activeAtts.getLength();

				while(attLength-- > 0)
					System.out.println(
						"\t["
						+ activeAtts.getQName(attLength)
						+ ": "
						+ activeAtts.getValue(attLength)
						+ "]"
					);
			}
		}
	}

}

