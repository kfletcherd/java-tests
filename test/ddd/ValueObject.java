package test.ddd;

import java.util.HashMap;

final class ValueObject {

/*
	private HashMap<String, Field> data = new HashMap<>(){{
		put("A", new Field<Integer>(){
			private Integer d;
			public Integer getVal(){ return d; }
			public void setVal(Integer val){ d = val; }
		});

		put("B", new Field<String>(){
			private String d;
			public String getVal(){ return d; }
			public void setVal(String val){ d = val; }
		});

		put("C", new Field<Character>(){
			private Character d;
			public Character getVal(){ return d; }
			public void setVal(Character val){ d = val; }
		});
	}};
*/

	private int a;
	private String b;
	private char c;

	public ValueObject(int a, String b, char c){
		this.a = a;
		this.b = b;
		this.c = c;

		//Integer intA = Integer.valueOf(a);
		//data.get("A").setVal(intA);
	}

	public int getA(){
		return a;
		//return data.get("A").getVal().intValue();
	}

	public String getB(){
		return b;
		//return data.get("B").getVal();
	}

	public char getC(){
		return c;
		//return data.get("C").getVal().charValue();
	}

}

