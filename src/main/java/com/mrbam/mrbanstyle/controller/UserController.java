package com.mrbam.mrbanstyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrbam.mrbanstyle.model.User;
import com.mrbam.mrbanstyle.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("users")
public class UserController {
	
	//instanciamos UserService na camada de controle
	
	@Autowired
	private UserService userService;
	
	//mapeamente Get
	@GetMapping
	public ResponseEntity<Iterable<User>> findAll(){
		return ResponseEntity.ok(userService.findAll());
	}
	
	// mapeamento id
	@GetMapping("/{id}")
	public ResponseEntity<User> findbyId(@PathVariable Long id){
		return ResponseEntity.ok(userService.findbyId(id));
	}
	
	// mapeamento post, passando o objeto user
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		userService.insert(user);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")				//variavel passada no map
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
		userService.updateUser(id, user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delet(@PathVariable Long id){
		userService.delet(id);
		return ResponseEntity.ok().build();
	}
}
