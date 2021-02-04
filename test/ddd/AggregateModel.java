package test.ddd;

final class AggregateModel implements ExposedModel {

	private ValueObject vo;
	private ValueObjectMeta vom;
	private boolean dirty = false;

	public AggregateModel(ValueObject vo){
		this.vo = vo;
		this.vom = new ValueObjectMeta();
	}

	public void updateA(int a){
		vo = new ValueObject(a, vo.getB(), vo.getC());
		dirty = true;
		vom.update();
	}

	public void updateB(String b){
		vo = new ValueObject(vo.getA(), b, vo.getC());
		dirty = true;
		vom.update();
	}

	public void updateC(char c){
		vo = new ValueObject(vo.getA(), vo.getB(), c);
		dirty = true;
		vom.update();
	}


	public int getA(){ return vo.getA(); }
	public String getB(){ return vo.getB(); }
	public char getC(){ return vo.getC(); }
	public String getCreated(){ return vom.getCreated(); }
	public String getUpdated(){ return vom.getUpdated(); }


	public boolean isDirty(){
		return dirty;
	}

//	public boolean equals(ExposedModel em){
//		return (
//			   vo.getA().equals(em.getA())
//			&& vo.getB().equals(em.getB())
//			&& vo.getC().equals(em.getC())
//		);
//	}

	public String toString(){
		return new StringBuilder()
			.append(String.valueOf(vo.getA()))
			.append(", ")
			.append(String.valueOf(vo.getB()))
			.append(", ")
			.append(String.valueOf(vo.getC()))
			.toString();
	}

}

