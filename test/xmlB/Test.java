package test.xml;

import test.xml.examples.TagToonParsingStrategy;
import test.xml.examples.AttToonParsingStrategy;
import test.xml.interfaces.DTO;
import test.xml.interfaces.ParsingStrategy;

import test.xml.factory.XMLParser;

// Runtime for testing out some examples from the examples package
class Test {
	// Some toon data for a single toon stored as inner tag format
	private static String tagToon = "<d><toon><id>1</id><name>proff</name><class>warrior</class></toon></d>";


	// Some toon data for a list of toons in attribute format
	private static String attToon = new StringBuilder()
			.append("<d>")
			.append("<toon id=\"2\" name=\"kon\" class=\"warlock\" />")
			.append("<toon id=\"3\" name=\"katkat\" class=\"priest\" />")
			.append("<junk id=\"777\" name=\"trash\" class=\"noise\" />")
			.append("<toon id=\"4\" name=\"kursy\" class=\"shaman\" />")
			.append("<toon id=\"5\" name=\"derp\" class=\"paladin\" />")
			.append("</d>")
			.toString();


	// Runtime
	public static void main(String[] a)
	throws Exception {

		// See how the default parsing strat works out
		printToon(XMLParser.parse(tagToon));

		System.out.println("------");

		// See how a specific toon parsing strat works out
		printToon(XMLParser.parse(tagToon, (ParsingStrategy)(new TagToonParsingStrategy())));

		System.out.println("------");

		// See how the parsing strat for a list of toons works out
		// (Prints toon list as part of it's getDTO method)
		DTO t = XMLParser.parse(attToon, (ParsingStrategy)(new AttToonParsingStrategy()));

		System.out.println("------");

		// Print whatever random toon was returned from the toon list 4fun
		printToon(t);
	}


	// DRY
	private static void printToon(DTO toon){
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(toon.get("id"));
		sb.append(" | name: ").append(toon.get("name"));
		sb.append(" | class: ").append(toon.get("class"));
		System.out.println(sb.toString());
	}



}

