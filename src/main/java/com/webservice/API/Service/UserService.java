package com.webservice.API.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.webservice.API.DAO.UserDAO;
import com.webservice.API.Model.User;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
    
    public User getUserById(Long id) {
    	User user;
    	
    	try {
    		user = userDAO.findById(id).get();
    	}catch (Exception e) {
    		user = null;
		}
        return user;
    }
    
    public User createUser(User user) {
        return userDAO.save(user);
    }
    
    public User updateUser(Long id, User userDetails) {
        User user = userDAO.findById(id).get();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        return userDAO.save(user);
    }
    
    public void deleteUser(User user) {
        userDAO.delete(user);
    }
}
