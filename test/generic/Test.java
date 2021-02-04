package test.generic;

class Test {

	public static void main(String[] a){
		if(a.length < 2){
			System.out.println("Give me two arguments man");
			return;
		}

		GenericClass<Integer, String> gc1 = new GenericClass<Integer, String>(0, a[0]);
		printGC(gc1);

		GenericClass<Integer, String> gc2 = new GenericClass<Integer, String>(1, a[1]);
		printGC(gc2);

		GenericClass<String, String> gc3 = new GenericClass<String, String>("asdf", "qwerty");
		printGC(gc3);
	}

	private static void printGC(GenericClass gc){
		System.out.println(
			"Created new class with key ["
			+ gc.getKey()
			+ "] and value ["
			+ gc.getVal()
			+ "]"
		);
	}

}

