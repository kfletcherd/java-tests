package test.ddd;

public final class Factory {

	public static ExposedModel build(int a, String b, char c){
		return (ExposedModel) (new AggregateModel(new ValueObject(a,b,c)));
	}

}

