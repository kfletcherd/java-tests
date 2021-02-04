package test.ddd;

public interface ExposedModel {

	public void updateA(int a);
	public void updateB(String b);
	public void updateC(char c);

	public int getA();
	public String getB();
	public char getC();
	public String getCreated();
	public String getUpdated();

	public boolean isDirty();
//	public boolean equals(ExposedModel em);
	public String toString();
}

