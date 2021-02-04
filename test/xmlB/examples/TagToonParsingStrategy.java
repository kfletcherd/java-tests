package test.xml.examples;

import test.xml.interfaces.DTO;
import test.xml.interfaces.ParsingStrategy;

import java.util.HashMap;

import org.xml.sax.Attributes;

// Example implemenation of a parsing strategy that is looking for
// toon information stored inbetween xml tags and is only concerned
// about a single toon
// This is hardly robust and full of potentials for error, it's just
// an example bro...
public class TagToonParsingStrategy implements ParsingStrategy {

	// Store of the current tag
	private String nextKey;


	// Store of a single toon DTO object
	private ToonDTO toon = new ToonDTO();


	// Sets the active key so we know the relevance of what value will
	// be fed next
	public void setNextKey(String k){ nextKey = k; }


	// Stores the value of the current tag
	public void setNextValue(String v){ toon.set(nextKey, v); }


	// mark we've reached the end
	public void setKeyEnd(){ nextKey = null; }


	// this doesnt care about attributes
	public void setNextAttribute(Attributes a){}


	// return whatever toon data we gotz
	public DTO getDTO(){ return (DTO) toon; }

}

