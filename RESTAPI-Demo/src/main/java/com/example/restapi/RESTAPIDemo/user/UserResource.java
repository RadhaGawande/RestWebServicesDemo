package com.example.restapi.RESTAPIDemo.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
//GET   /users
	//retrievalAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user= service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
	//	return service.findOne(id);
		//"all-users", SERVER_PATH + "/users"
				//retrieveAllUsers
				EntityModel<User> resource = EntityModel.of(user);
				
				WebMvcLinkBuilder linkTo = 
						linkTo(methodOn(this.getClass()).retrieveAllUsers());
				
				resource.add(linkTo.withRel("all-users"));
				return resource;
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);		
	}
	
	//HATEOAS -hyper media as the engine of appln state
	
	//CREATED
	// input - details of user
	// output - CREATED & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = service.save(user);
		//CREATED
		///users/4
		// /user/{id}     savedUser.getId()
		
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
				
				return ResponseEntity.created(location).build();
	}
	
}








