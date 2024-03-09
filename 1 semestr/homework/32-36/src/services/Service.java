package service;
import storage.*;
import models.*;

public class Service{
	
	private IStorage db;
	
	public Service(IStorage db){
		this.db = db;
	}
	
	public User [] getUsers(){
		return db.getUsers();
	}
	
	public Group [] getGroups(){
		return db.getGroups();
	}
	
	public Subscription [] getSubs(){
		return db.getSubs();
	}
	
	public Member [] getMembers(){
		return db.getMembers();
	}
	
	public User [] getUsersSubs(User u){
		int count = 0;
		for (Subscription sub: getSubs()){
			if (sub.getUser2Id() == u.getId()){
				count++;
			}
		}
		
		int k = 0;
		User [] usersSubs = new User[count];
		for (Subscription sub: getSubs()){
			if (sub.getUser2Id() == u.getId()){
				usersSubs[k] = db.getUserById(sub.getUser1Id());
				k++;
			}
		}
		return usersSubs;
	}
	//Task 30
	public String whoHaveMostOfSubs(){
		User [] us = getUsers();
		int index = 0;
		int maxLen = 0;
		for (int i = 0; i < us.length; i++){
			if (getUsersSubs(us[i]).length > maxLen){
				maxLen = getUsersSubs(us[i]).length;
				index = i;
			}
		}
		return us[index].getName();
	}
	
	public User [] getGroupsSubs(Group group){
		int count = 0;
		for (Member member: getMembers()){
			if (member.getGroupId() == group.getId()){
				count++;
			}
		}
		
		User [] groupSubs = new User[count];
		
		int index = 0;
		for (Member member: getMembers()){
			if (member.getGroupId() == group.getId()){
				groupSubs[index] = db.getUserById(member.getUserId());
				index++;
			}
		}
		return groupSubs;
	}
	
	//Task 31
	public String noOneFromGroupCity(){
		Group [] gps = getGroups();
		boolean flag = false;
		
		for (int i = 0; i < gps.length && !flag; i++){
			for (User user: getGroupsSubs(gps[i])){
				if (user.getCity().equals(gps[i].getCity())){
					flag = true;
					return gps[i].getName();
				}
			}
		}
		return "такой группы нет";
	}
	
	
	
	//Task 33 	
	public void allGroupThereHalfPeopleNotFromAdminsCity(){
		int c = 0;
		boolean flag = false;
		for (Group group: getGroups()){
			c = 0;
			User [] grSubs = getGroupsSubs(group); 
			for (int j = 0; j < grSubs.length && !flag; j++){
				if (!(grSubs[j].getCity().equals(group.getAdmin().getCity()))){
					c++;
				}
				if (c > grSubs.length / 2){
					System.out.println(group.getName());
					flag = true;
				} 
			}
			flag = false;
		}
	}
	
	public boolean isFriend(User u1, User u2){
		for (Subscription sub: getSubs()){
			if ((sub.getUser1Id() == u1.getId() && sub.getUser2Id() == u2.getId())||(sub.getUser1Id() == u2.getId() && sub.getUser2Id() == u1.getId())){
				return true;
			}
		}
		return false;
	}
	
	//Task 34
	public boolean groupAreFriendly1(Group group){
		User [] gr = getGroupsSubs(group);
		boolean flag = true;
		for (int i = 0; i < gr.length - 1 && flag; i++){
			for (int j = i + 1; j < gr.length && flag; j++){
				if (!(isFriend(gr[i], gr[j]))){
					flag = false;
				}
			}
		}
		return flag;
	}

	public int groupAreFriendly1Present(Group group){
		User [] gr = getGroupsSubs(group);
		double present = 0;
		int maxPresent = 0;
		for (int i = 0; i < gr.length - 1; i++){
			for (int j = i + 1; j < gr.length; j++){
				maxPresent++;
				if (isFriend(gr[i], gr[j])){
					present++;
				}
			}
		}
		return (int)((present/maxPresent) * 100);
	}
	
	public void statisticGroupAreFriendly1(){
		for (Group group: getGroups()){
			System.out.println(groupAreFriendly1Present(group));
		}
	}
	
	//Task 35
	public boolean groupAreFriendly2(Group group){
		User [] gr = getGroupsSubs(group);
		boolean flag = true;
		boolean check = false;
		for (int i = 0; i < gr.length - 1 && flag; i++){
			for (int j = i + 1; i < gr.length && !check; j++){
				if (isFriend(gr[i], gr[j])){
					check = true;
				}
			}
			if (!check){
				flag = false;
			}
			check = false;
		}
		return flag;
	}
	
	public int groupAreFriendly2Present(Group group){
		User [] gr = getGroupsSubs(group);
		boolean check = false;
		double present = 0;
		int maxPresent = 0;
		for (int i = 0; i < gr.length - 1; i++){
			for (int j = i + 1; j < gr.length && !check; j++){
				if (isFriend(gr[i], gr[j])){
					check = true;
					present++;
				}
			}
			maxPresent++;
			check = false;
		}
		return (int)((present/maxPresent) * 100);
	}
	
	public void statisticGroupAreFriendly2(){
		for (Group group: getGroups()){
			System.out.println(groupAreFriendly2Present(group));
		}
	}
	
	public boolean notIn(int [] colored, int id){
		for (int color: colored){
			if (color == id){
				return false;
			}
		}
		return true;
	}
	
	public boolean notIn(User [] queue, int id){
		for (User user: queue){
			if (user != null){
				if (user.getId() == id){
					return false;
				}
			}
		}
		return true;
	}
	//Task 36
	public boolean groupIsFriendly3(Group group){
		User [] grSubs = getGroupsSubs(group);
		int lenGrs = grSubs.length;
		int next = 0;
		int neigh = 0;
		int [] colored = new int[lenGrs];
		User [] queue = new User[lenGrs];
		queue[neigh] = grSubs[0];
		neigh++;
		while (next != neigh) {
			colored[next] = queue[next].getId();
			for (User user : grSubs) {
				if (isFriend(queue[next], user)) {
					if ((notIn(colored, user.getId())) && (notIn(queue, user.getId()))) {
						queue[neigh] = user;
						neigh++;
					}
				}
			}
			next++;
		}
		return neigh == lenGrs;
	}
	
	public int groupIsFriendly3Present(Group group){
		User [] grSubs = getGroupsSubs(group);
		int lenGrs = grSubs.length;
		int next = 0;
		int neigh = 0;
		int [] colored = new int[lenGrs];
		User [] queue = new User[lenGrs];
		queue[neigh] = grSubs[0];
		neigh++;
		while (next != neigh) {
			colored[next] = queue[next].getId();
			for (User user : grSubs) {
				if (isFriend(queue[next], user)) {
					if ((notIn(colored, user.getId())) && (notIn(queue, user.getId()))) {
						queue[neigh] = user;
						neigh++;
					}
				}
			}
			next++;
		}
		return (int)((neigh / lenGrs) * 100);
	}
	
	public void statisticGroupAreFriendly3(){
		for (Group group: getGroups()){
			System.out.println(groupIsFriendly3Present(group));
		}
	}
	
}