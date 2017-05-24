package ua.shop.vitaly.services.User;

import java.util.ArrayList;

import ua.shop.vitaly.models.user.User;

public interface IUserService {
	
	public User getUser(int id) throws Exception;
	public User getUser(String login, String password) throws Exception;
	public ArrayList<User> getAllUsers() throws Exception;
	public int updateContact(User user) throws Exception;
	public boolean deleteContact(User user) throws Exception;
	public boolean createUser(String login, String password) throws Exception;
	
}
