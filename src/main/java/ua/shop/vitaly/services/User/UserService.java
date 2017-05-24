package ua.shop.vitaly.services.User;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.shop.vitaly.models.user.NoSuchUserException;
import ua.shop.vitaly.models.user.User;
import ua.shop.vitaly.models.user.DAO.JDBCUserDAO;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private JDBCUserDAO userDAO;
	
	@Override
	@Transactional
	public User getUser(int id) throws Exception {
		try{return userDAO.getUser(id);}
		catch(Exception e){throw new NoSuchUserException("Ooops_invalid_user_id");}
	}

	@Override
	@Transactional
	public User getUser(String login, String password) throws Exception {
		if(login.length()<4||password.length()<4){ 
			throw new NoSuchUserException("Error: You did not correct fill in fileds");
		}
		try{
			return userDAO.getUser(login, password);
		}
		catch(Exception e){
			throw new NoSuchUserException("Error: User has not register yet");
		}
	}

	@Override
	@Transactional
	public ArrayList<User> getAllUsers() throws Exception {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public int updateContact(User user) throws Exception {
		return userDAO.updateContact(user);
	}

	@Override
	@Transactional
	public boolean deleteContact(User user) throws Exception {
		return userDAO.deleteContact(user);
	}

	@Override
	@Transactional
	public boolean createUser(String login, String password) throws Exception{
		if(login.length()<4 || password.length()<4){
			throw new NoSuchUserException("Error: You did not correct fill in fileds");
		}
		boolean signUP = false;
		try{
			for(User x : userDAO.getAllUsers()){
				if(x.getLogin().equals(login)) {
					signUP=true;
					break;
				}
			}
		}catch(Exception e){e.getStackTrace();}
		if(signUP==false){ 
			return userDAO.createUser(login,password);
		}
		else{
			throw new NoSuchUserException("Error: User has already registered");
		}
	}

}
