package com.webservice.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webservice.API.Model.User;
import com.webservice.API.Service.UserService;

@Controller
public class UserController {

	 @Autowired
	    private UserService userService;
	    
	    @GetMapping("/alluser")
	    public ResponseEntity<List<User>> getAllUsers() {
	    	List<User> list = userService.getAllUsers();
	        return ResponseEntity.status(HttpStatus.CREATED).body(list);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	    	User user = userService.getUserById(id);
	        return ResponseEntity.of(Optional.of(user));
	    }
	    
	    @PostMapping("/create")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        
	    	User user1 = userService.createUser(user);
	    	
	    	return ResponseEntity.of(Optional.of(user1));
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
	    	User user = userService.updateUser(id, userDetails);
	        return ResponseEntity.of(Optional.of(user));
	    }
	    
	    @DeleteMapping("/{id}")
	    @ResponseBody
	    public String deleteUser(@PathVariable Long id) {
	        User user = userService.getUserById(id);
	        if(user != null) {userService.deleteUser(user);return "Deleted Succesfully";}
	        else return "User doesn't exist";
	    }
	
}
