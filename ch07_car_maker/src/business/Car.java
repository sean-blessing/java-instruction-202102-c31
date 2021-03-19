package business;

public class Car {
	private int id;
	private String make;
	private String model;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		if (make==null || make.isEmpty())
			System.out.println("Make cannot be empty!");
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
