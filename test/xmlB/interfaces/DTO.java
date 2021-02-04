package test.xml.interfaces;

/**
 * A simple data transfer object with your basic getter and setter
 */
public interface DTO {

	/**
	 * Get some data
	 *
	 * @param key The key to look up the value for
	 * @return The value as a generic string
	 */
	public String get(String key);


	/**
	 * Set some data
	 *
	 * @param key The key to use for storage
	 * @param val The value to store
	 */
	public void set(String key, String val);

}

