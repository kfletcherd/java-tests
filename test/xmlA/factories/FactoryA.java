package test.xml.factories;

import java.util.HashMap;

import org.xml.sax.Attributes;

public class FactoryA implements Factory {

	private HashMap<String, String> vals;

	// Return an instanciated instance of one's self
	public static Factory newInstance(){
		return new FactoryA();
	}

	// Add an attribute list
	public void add(Attributes a){
		int l = a.getLength();

		while(--l >= 0){
			vals.put(a.getQName(l), a.getValue(l));
		}
	}

	// Add some data to one's self by xml tag name and inner value
	public void add(String tag, String value){
		vals.put(tag, value);
	}

	public void echo(){
		for(String key : vals.keySet())
			System.out.println(key + " : " + vals.get(key));
	}

}


