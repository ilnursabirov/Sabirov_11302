package main;
import storage.*;
import service.*;
import models.*;
import java.io.FileNotFoundException;

public class Main{
	
	public static void main(String[] args) throws FileNotFoundException{
		Storage storage = new Storage();
		Service service = new Service(storage);

		System.out.println(service.whoHaveMostOfSubs());

		System.out.println(service.noOneFromGroupCity());

		service.allGroupThereHalfPeopleNotFromAdminsCity();

		service.statisticGroupAreFriendly1();

		service.statisticGroupAreFriendly2();

		service.statisticGroupAreFriendly3();
	}
}