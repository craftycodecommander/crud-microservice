package com.companyname.crudmicroservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.crudmicroservice.common.User;
import com.companyname.crudmicroservice.dao.UserDAO;

import io.swagger.annotations.ApiOperation;

@RestController
public class CRUDExampleController {
	
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * This method returns a List of All User objects
	 * @return
	 */
	@ApiOperation(value = "/user", 
			      produces = MediaType.APPLICATION_JSON_VALUE, 
			      httpMethod = "GET", 
			      responseContainer = "List", 
			      response = User.class, 
			      notes = "Returns a list of User objects")
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	/**
	 * Returns the User object for the passed user id
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "/user/{id}", 
			      produces = MediaType.APPLICATION_JSON_VALUE, 
			      httpMethod = "GET", 
			      response = User.class,
			      notes = "Returns the User that has the passed id")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable(value = "id") Long id) {
		return userDAO.getUser(id);
	}
	
	/**
	 * Adds a new User.
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "/user", 
		          produces = MediaType.APPLICATION_JSON_VALUE,
		          consumes = MediaType.APPLICATION_JSON_VALUE,
		          httpMethod = "POST", 
		          response = User.class,
		          notes = "Adds a new User")
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return userDAO.addUser(user);
	}
	
	/**
	 * Deletes User with passed id.
	 * @param id
	 * @return Response
	 */
	@ApiOperation(value = "/user", 
	          	  httpMethod = "DELETE",
	          	  notes = "Deletes User by id")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
		userDAO.deleteUser(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	/**
	 * Updates user.
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "/user", 
	              produces = MediaType.APPLICATION_JSON_VALUE,
	              consumes = MediaType.APPLICATION_JSON_VALUE,
	              httpMethod = "PUT", 
	              response = User.class,
	              notes = "Updates a User")
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		return userDAO.updateUser(user);
	}
	
}
