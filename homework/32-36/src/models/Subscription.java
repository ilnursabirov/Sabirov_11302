package models;

public class Subscription{
	
	private int user1_id;
	private int user2_id;
	
	public Subscription(int user1_id, int user2_id){
		this.user1_id = user1_id;
		this.user2_id = user2_id;
	}
	
	public int getUser1Id(){
		return user1_id;
	}
	
	public int getUser2Id(){
		return user2_id;
	}
}