import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task31{
	
	public static User getUserById(int id, User [] users){
		for (User user: users){
			if (user.getId() == id){
				return user;
			}
		} return null;
	}
	
	public static int getIndexGroup(Group group, Group [] groups){
		for (int i = 0; i < groups.length; i++){
			if (group.getId() == groups[i].getId()){
				return i;
			}
		}
		return -1;
	}
	
	public static Group getGroupById(int id, Group [] groups){
		for (Group group: groups){
			if (group.getId() == id){
				return group;
			}
		} return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scUser = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task 30 - 31/Users.txt"));
	
		int countUsers = scUser.nextInt();
		String notImportant = scUser.nextLine();
		User [] users = new User[countUsers];
	
		for (int i = 0; i < countUsers; i++){
			String [] temp = scUser.nextLine().split(" ");
			int id = Integer.parseInt(temp[0]);
			String name = temp[1];
			String city = temp[2];
			users[i] = new User(name, id, city);
		}
		
		Scanner scSubs = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task 30 - 31/Subscriptions.txt"));
		int countSubs = scSubs.nextInt();
		notImportant = scSubs.nextLine();
		Subscription [] subs = new Subscription[countSubs];
		
		for (int i = 0; i < countSubs; i++){
			String [] temp = scSubs.nextLine().split(" ");
			int user1_id = Integer.parseInt(temp[0]);
			int user2_id = Integer.parseInt(temp[1]);
			subs[i] = new Subscription(user1_id, user2_id);
		}
		
		Scanner scGroup = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task 30 - 31/Groups.txt"));
		int countGroups = scGroup.nextInt();
		notImportant = scGroup.nextLine();
		Group [] groups = new Group[countGroups];
		
		for (int i = 0; i < countGroups; i++){
			String temp [] = scGroup.nextLine().split(" ");
			int id = Integer.parseInt(temp[0]);
			String name = temp[1];
			String city = temp[2];
			groups[i] = new Group(name, id, city);
		}
		
		Scanner scMem = new Scanner(new File("C:/infa/Rep/Sabirzyanov_11302/homework/Task 30 - 31/Members.txt"));
		int countMembers = scMem.nextInt();
		notImportant = scMem.nextLine();
		Member [] members = new Member[countMembers];
		
		for (int i = 0; i < countMembers; i++){
			String temp [] = scMem.nextLine().split(" ");
			int userId = Integer.parseInt(temp[0]);
			int groupId = Integer.parseInt(temp[1]);
			members[i] = new Member(userId, groupId);
		}
		
		int [] subGr = new int[countGroups];
		
		for (Member member: members){
			String us = getUserById(member.getUserId(),users).getCity();
			String gs = getGroupById(member.getGroupId(),groups).getCity();
			if (us.equals(gs)){
				subGr[getIndexGroup(getGroupById(member.getGroupId(),groups),groups)]++;
			}
		}
		
		boolean flag = false;
		for (int i = 0; i < countGroups; i++){
			if (subGr[i] == 0){
				System.out.println(groups[i].getName());
				flag = true;
			}
		}
		if (!flag){
			System.out.println("такой нет");
		}
	}
}