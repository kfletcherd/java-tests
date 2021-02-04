package test.xml.factory;

import test.xml.interfaces.*;
import org.xml.sax.Attributes;
import java.util.HashMap;

/**
 * Basic implemenation of a ParsingStrategy for easy of use for anything
 * that isn't more complex than a HashMap
 */
final class DefaultParsingStrategy implements ParsingStrategy {

	/** The active key/tag from the parser */
	private String key;

	/** Store of the data (suprize, it's a hashmap!) */
	private HashMap<String, String> data = new HashMap<>();


	/** @see ParsingStrategy.setNextKey */
	public void setNextKey(String k){
		key = k;
	}


	/** @see ParsingStrategy.setNextValue */
	public void setNextValue(String v){
		data.put(key, v);
	}


	/** @see ParsingStrategy.setKeyEnd */
	public void setKeyEnd(){
		key = null;
	}


	/**
	 * Feed the stored HashMap to this class's default implementation
	 * of a DTO then return it
	 *
	 * @see ParsingStrategy.getDTO
	 */
	public DTO getDTO(){
		return new DefaultDTO(data);
	}

	/** This doesn't care about attributes */
	public void setNextAttribute(Attributes a){ }

	/**
	 * Very basic implementation of a DTO, basically a HashMap wrapper
	 */
	private final class DefaultDTO implements DTO {

		/** Internal store of data */
		private HashMap<String, String> data;


		/**
		 * Private constructor, only available to the parent class
		 *
		 * @param hm The hashmap data to store
		 */
		private DefaultDTO(HashMap<String, String> hm){
			data = hm;
		}


		/** @see DTO.get */
		public String get(String key){
			return data.get(key);
		}

		/** verboten */
		public void set(String key, String val){}
	}

}

