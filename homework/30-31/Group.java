public class Group{
	private String name;
	private int id;
	private String city;
	
	public Group(String name, int id, String city){
		this.name = name;
		this.id = id;
		this.city = city;
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
	
	/*public User getUser(){
		return user;
	}*/
}