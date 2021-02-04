package test.xml.factories;

import org.xml.sax.Attributes;

public interface Factory {

	// Return an instanciated instance of one's self
	//public static Factory getNewInstance(){}

	// Add an attribute list
	public void add(Attributes a);

	// Add some data to one's self by xml tag name and inner value
	public void add(String tag, String value);

}

