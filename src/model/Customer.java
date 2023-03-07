package model;

public class Customer {
	private String name;
	private String adress;
	private int age;
	private int id;
	
	public Customer() {
		super();
	}
	public Customer(String name, String adress, int age,int id) {
		super();
		this.name = name;
		this.adress = adress;
		this.age = age;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", adress=" + adress + ", age=" + age + ",id ="+ id +"]";
	}
	
	

}
