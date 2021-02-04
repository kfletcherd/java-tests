package test;

import test.ddd.Factory;
import test.ddd.ExposedModel;

final class TestDDD {

	public static void main(String[] a)
	throws Exception {

		System.out.println("Testing factory/getters");
		ExposedModel m = Factory.build(1, "asdf", 'd');
		System.out.println("-- " + m.toString());

		System.out.println("Testing changing Bs value");
		String str = m.getB();
		str = "qwerty";
		System.out.println("-- " + m.getB() + " : " + str);

		System.out.println("Testing dirtyness");
		System.out.println("-- " + m.isDirty() + " : " + m.getA());
		System.out.println("-- " + m.getCreated());
		System.out.println("-- " + m.getUpdated());
		Thread.sleep(1000);
		m.updateA(5);
		System.out.println("-- " + m.isDirty() + " : " + m.getA());
		System.out.println("-- " + m.getCreated());
		System.out.println("-- " + m.getUpdated());

//		System.out.println("Testing equality");
//		ExposedModel m2 = Factory.get(5, "asdf", 'd');
//		System.out.println(m2.equals(m));
//		m2.updateC('z');
//		System.out.println(m2.equals(m));
	}

}

