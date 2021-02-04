package test.generic;

class Attribute<V> {
	private String name;
	private V value;

	public Attribute(String n, V v){
		name = n;
		value = v;
	}

	public String getName(){
		return type;
	}

	public V getValue(){
		return value;
	}

}

