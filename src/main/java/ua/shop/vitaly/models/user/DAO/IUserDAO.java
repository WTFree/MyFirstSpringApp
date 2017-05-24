package ua.shop.vitaly.models.user.DAO;

import java.util.ArrayList;

import ua.shop.vitaly.models.user.User;

/*
 *@author WitalyGaiduchok 
 * Created 25-February-2017
 * */
public interface IUserDAO {
	public User getUser(int id) throws Exception;
	public User getUser(String login, String password) throws Exception;
	public ArrayList<User> getAllUsers() throws Exception;
	public int updateContact(User user) throws Exception;
	public boolean deleteContact(User user) throws Exception;
	public boolean createUser(String login, String password);
}
