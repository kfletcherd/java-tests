package test.random;

class GB<T> {

	private T v;

	private GB(T val){
		v = val;
	}

	public static <T> GB begin(T val){
		return new GB<T>(val);
	}

	public GB length(){
		System.out.println(String.valueOf(v).length());
		return this;
	}

}


class GenericBuilder {

	public static void main(String[] args){

		for(String a : args)
			GB.begin(a).length().length();

		int a = 1234567890;
		GB.begin(a).length();
	}

}

