package test.generic;

class GenericClass<K, V> {
	private K key;
	private V val;

	public GenericClass(K k, V v){
		set(k, v);
	}

	public void set(K key, V val){
		this.key = key;
		this.val = val;
	}

	public V getVal(){
		return val;
	}

	public K getKey(){
		return key;
	}

}

