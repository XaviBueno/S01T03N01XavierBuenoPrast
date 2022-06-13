package Ex01;

public class Month {
	

	//Attribut
	private String name;
	
	//Constructor
	
	public Month(String name) {
		this.name=name;
	}
	public Month() {
		name="";
	}

	
	//Setter
	
	public void setMonth(String name) {
		this.name=name;
	}
	
	public String getMonth() {
		return name;
	}
}
