package test.random;

interface Tester {
	int a = 1;
	public void print();
	public void print(int b);
}

interface Tester2 {
	String a = null;
	int b = null;
	char c = null;
}

class EnterfaceTest implements Tester {

	public static void main(String[] a){
		EnterfaceTest et = new EnterfaceTest();
		et.print();
		et.print(5);

		Tester2 t2 = new Tester2("asdf", 2, 'c'){
			public Tester2(String aa, int bb, char cc){
				a = aa;
				b = bb;
				c = cc;
			}
		};

		System.out.println(t2.a + t2.b + t2.c);
	}

	public void print(){
		System.out.println(a);
	}
	public void print(int b){
		System.out.println(a+b);
	}

}

