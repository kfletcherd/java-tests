package test.xml.examples;

import test.xml.interfaces.DTO;

// Example implemenation of a simple toon data transfer object
// which stores a very simple set of properties
public class ToonDTO implements DTO {

	// Toon specific properties
	private int id;
	private String name;
	private String toonClass;


	// mmmm, switch statements
	public void set(String key, String val){
		switch(key){
			case "id":
				id = Integer.valueOf(val);
				break;

			case "name":
				name = val;
				break;

			case "class":
				toonClass = val;
				break;
		}
	}


	// mmmm, more switch statements
	public String get(String key){
		switch(key){
			case "id": return String.valueOf(id);
			case "name": return name;
			case "class": return toonClass;
			default: return "";
		}
	}

}

