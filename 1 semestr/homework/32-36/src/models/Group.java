package models;

public class Group{
	private String name;
	private int id;
	private String city;
	private User admin;
	
	public Group(String name, int id, String city, User admin){
		this.name = name;
		this.id = id;
		this.city = city;
		this.admin = admin;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getCity(){
		return city;
	}
	
	public User getAdmin(){
		return admin;
	}
}