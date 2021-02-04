package test.ddd;

import java.util.Date;

final class ValueObjectMeta {

	private Date created;
	private Date updated;

	public ValueObjectMeta(){
		created = new Date();
		updated = new Date();
	}

	public void update(){
		updated = new Date();
	}

	public String getCreated(){
		return created.toString();
	}

	public String getUpdated(){
		return updated.toString();
	}

}

