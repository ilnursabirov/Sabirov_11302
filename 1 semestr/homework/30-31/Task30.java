import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task30{
	
	public static int getIndexUser(User user, User [] users){
		for (int i = 0; i < users.length; i++){
			if (users[i].getId() == user.getId()){
				return i;
			}
		} return -1;
	}
	
	public static User getUserById(int id, User [] users){
		for (User user: users){
			if (user.getId() == id){
				return user;
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
		
		int index = 0;
		int [] userSubs = new int [countUsers];
		int maxIndex = 0;
		int maxCountSub = 0;
		for (Subscription sub: subs){
			User u2 = getUserById(sub.getUser2Id(),users);
			index = getIndexUser(u2,users);
			userSubs[index]++;
			if (userSubs[index] > maxCountSub){
				maxCountSub = userSubs[index];
				maxIndex = index;
			}
		}
		System.out.println(users[maxIndex].getName());
	}
}