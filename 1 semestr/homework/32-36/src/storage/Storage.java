package storage;

import models.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Storage implements IStorage{
	
	private User [] users;
	private Group [] groups;
	private Member [] members;
	private Subscription [] subs;
	private int countUsers;
	private int countSubs;
	private int countMembers;
	private int countGroups;
	private String notImportant;
	private String [] temp;
	
	public Storage() throws FileNotFoundException{
		init();
	}
	
	public void userInit() throws FileNotFoundException{
	
		Scanner scUser = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task32-36/resourses/Users.txt"));
		this.countUsers = scUser.nextInt();
		notImportant = scUser.nextLine();
		this.users = new User[countUsers];
	
		for (int i = 0; i < countUsers; i++){
			temp = scUser.nextLine().split(" ");
			int id = Integer.parseInt(temp[0]);
			String name = temp[1];
			String city = temp[2];
			users[i] = new User(name, id, city);
		}
	}
	
	public void subsInit() throws FileNotFoundException{
		
		Scanner scSubs = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task32-36/resourses/Subscriptions.txt"));
		this.countSubs = scSubs.nextInt();
		notImportant = scSubs.nextLine();
		this.subs = new Subscription[countSubs];
		
		for (int i = 0; i < countSubs; i++){
			temp = scSubs.nextLine().split(" ");
			int user1_id = Integer.parseInt(temp[0]);
			int user2_id = Integer.parseInt(temp[1]);
			subs[i] = new Subscription(user1_id, user2_id);
		}
	}
	
	public void groupsInit() throws FileNotFoundException{
		
		Scanner scGroup = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task32-36/resourses/Groups.txt"));
		this.countGroups = scGroup.nextInt();
		notImportant = scGroup.nextLine();
		this.groups = new Group[countGroups];
		
		for (int i = 0; i < countGroups; i++){
			temp = scGroup.nextLine().split(" ");
			int id = Integer.parseInt(temp[0]);
			String name = temp[1];
			String city = temp[2];
			User admin = getUserById(Integer.parseInt(temp[3]));
			groups[i] = new Group(name, id, city, admin);
		}
	}
	
	public void membersInit() throws FileNotFoundException{
		
		Scanner scMem = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task32-36/resourses/Members.txt"));
		this.countMembers = scMem.nextInt();
		notImportant = scMem.nextLine();
		members = new Member[countMembers];
		
		for (int i = 0; i < countMembers; i++){
			temp = scMem.nextLine().split(" ");
			int userId = Integer.parseInt(temp[0]);
			int groupId = Integer.parseInt(temp[1]);
			members[i] = new Member(userId, groupId);
		}
	}
	
	public void init() throws FileNotFoundException{
		userInit();
		groupsInit();
		subsInit();
		membersInit();
	}
	
	public User getUserById(int id){
		for (User user: users){
			if (user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public Group getGroupById(int id){
		for (Group group: groups){
			if (group.getId() == id){
				return group;
			}
		}
		return null;
	}
	
	public int getIndexBySub(Subscription sub){
		for (int i = 0; i < subs.length; i++){
			if (subs[i].getUser1Id() == sub.getUser1Id() && subs[i].getUser2Id() == sub.getUser2Id()){
				return i;
			}
		}
		return -1;
	}
	
	public int getIndexByUser(User u){
		for (int i = 0; i < users.length; i++){
			if (users[i].getId() == u.getId()){
				return i;
			}
		}
		return -1;
	}
	
	public int getIndexByGroup(Group g){
		for (int i = 0; i < groups.length; i++){
			if (groups[i].getId() == g.getId()){
				return i;
			}
		}
		return -1;
	}
	
	public int getIndexByMember(Member mem){
		for (int i = 0; i < members.length; i++){
			if (members[i].getUserId() == mem.getUserId() && members[i].getGroupId() == mem.getGroupId()){
				return i;
			}
		}
		return -1;
	}
	
	public User [] getUsers(){
		return users;
	}
	
	public Group [] getGroups(){
		return groups;
	}
	
	public Subscription [] getSubs(){
		return subs;
	}
	
	public Member [] getMembers(){
		return members;
	}
}