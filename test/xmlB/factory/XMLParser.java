package test.xml.factory;

import test.xml.interfaces.*;

import java.io.StringReader;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;

/**
 * Container class for XML Parsing factories and related functionality
 * <p>
 * Look for the parse(...) methods for usage
 */
public final class XMLParser {

	/** The parsing strategy that will be used */
	private ParsingStrategy strat;

	/** Private consturctor, use the parse(...) factories */
	private XMLParser(){}


	/**
	 * Executes the SAX parsers with the internal implementation of
	 * DefaultHandler
	 *
	 * @param p A copy of this class to pass to ReadHandle
	 * @param input The XML string to parse
	 * @throws Exception Any SAX exceptions bubble out
	 */
	private void parse(XMLParser p, String input)
	throws Exception {
		SAXParserFactory.newInstance().newSAXParser().parse(
			new InputSource(new StringReader(input)),
			new ReadHandle(p)
		);
	}


	/**
	 * Parse the given XML string with the default parsing strategy
	 * included in this package, which will treat your xml as a flat
	 * HashMap which is convient for basic, simple parsing, but anything
	 * more complicated will need to use a custom ParsingStrategy
	 * <p>
	 * For example:
	 *   <d><a>asdf</a><b>1</b></d>
	 * will translate to:
	 *   { a: asdf, b: 1 }
	 *
	 * @param input The XML string to parse
	 * @return A basic DTO object that basically functions like a hashmap
	 * @throws Exception Any SAX exceptions bubble out
	 */
	public static DTO parse(String input)
	throws Exception {
		XMLParser p = new XMLParser();
		p.strat = new DefaultParsingStrategy();
		p.parse(p, input);
		return p.strat.getDTO();
	}


	/**
	 * Parse the given xml string with a custom ParsingStrategy and
	 * return the DTO object as specified by that strategy
	 *
	 * @param input The XML string to parse
	 * @param ps The parsing strategy to use when parsing
	 * @return A basic DTO object that basically functions like a hashmap
	 * @throws Exception Any SAX exceptions bubble out
	 */
	public static DTO parse(String input, ParsingStrategy ps)
	throws Exception {
		XMLParser p = new XMLParser();
		p.strat = ps;
		p.parse(p, input);
		return p.strat.getDTO();
	}


	/**
	 * Implementation of the SAX library's DefaultHandler to work nicely
	 * with this library's ParsingStrategy
	 */
	private final class ReadHandle
	extends DefaultHandler {

		/** Store of an instanciated XMLParser */
		private XMLParser p;


		/** Stores the XMLParser for use, nothing fancy */
		public ReadHandle(XMLParser parent){
			p = parent;
		}


		/**
		 * Implementation of the method for opening xml tags
		 * <p>
		 * Only cares about the qualified name to pass as the key and the attributes
		 * to pass as is to the ParsingStrategy
		 *
		 * @see DefaultHandler.startElement
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts)
		throws SAXException {
			p.strat.setNextKey(qName);
			p.strat.setNextAttribute(atts);
		}


		/**
		 * Tells the parsing strategy that a closing tag was found
		 *
		 * @see DefaultHandler.endElement
		 */
		@Override
		public void endElement(String uri, String localName, String qName)
		throws SAXException {
			p.strat.setKeyEnd();
		}


		/**
		 * Passes the inner value of the tag to the parsing strategy
		 *
		 * @see DefaultHandler.characters
		 */
		@Override
		public void characters(char[] ch, int start, int length){
			p.strat.setNextValue(new String(ch, start, length).trim());
		}

	}

}

