package storage;

import models.*;
import java.io.FileNotFoundException;

public interface IStorage{
	
	void init() throws FileNotFoundException;
	User getUserById(int id);
	Group getGroupById(int id);
	User [] getUsers();
	Group [] getGroups();
	Subscription [] getSubs();
	Member [] getMembers();
	
}