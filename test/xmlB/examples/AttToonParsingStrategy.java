package test.xml.examples;

import test.xml.interfaces.DTO;
import test.xml.interfaces.ParsingStrategy;

import java.util.HashMap;
import java.util.ArrayList;

import org.xml.sax.Attributes; //gross

// Example implementation of a parsing strategy that cares about attributes
// more than inner content
// Also is concerned about a list of toons, rather than a single one
public class AttToonParsingStrategy implements ParsingStrategy {

	// Flag for the attribute parser to ignore undesirable tags
	private boolean skip;


	// Store of the toons that have been parsed
	private ArrayList<ToonDTO> toons = new ArrayList<>();


	// Check if a toon tag is found and set the skip property as desired
	public void setNextKey(String k){
		if(k.equals("toon")) skip = false;
		else skip = true;
	}


	// These are the goodies we're after, check if the tag should be
	// skipped and get that sweet toon info out of the attributes if
	// not
	public void setNextAttribute(Attributes a){
		if(skip) return;

		ToonDTO toon = new ToonDTO();
		toon.set("id", a.getValue("id"));
		toon.set("name", a.getValue("name"));
		toon.set("class", a.getValue("class"));
		toons.add(toon);
	}


	// Prints the stored toons to STDOUT and return one DTO at random
	public DTO getDTO(){
		for(ToonDTO t : toons)
			printToon(t);

		int idx = (int) Math.round(Math.random() * (toons.size() - 1));
		return (DTO) toons.get(idx);
	}


	// Prints the toon data, put in a seperate method for prettyness
	private static void printToon(ToonDTO toon){
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(toon.get("id"));
		sb.append(" | name: ").append(toon.get("name"));
		sb.append(" | class: ").append(toon.get("class"));
		System.out.println(sb.toString());
	}


	// These are of no consequence to this strategy
	public void setNextValue(String v){ }
	public void setKeyEnd(){ }

}

