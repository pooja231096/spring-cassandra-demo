package com.verizon.consumer.springdatacassandra.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.verizon.consumer.springdatacassandra.Entity.User;
import com.verizon.consumer.springdatacassandra.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
UserService service;
@PostMapping
@Nullable
public ResponseEntity<User> saveUser(@RequestBody @Nullable User obj) {
	obj.setLastLogin(UUID.randomUUID());
	System.out.println(UUID.randomUUID());
	System.out.println(UUIDs.timeBased());
	User entity=this.service.saveUser(obj);
	return new ResponseEntity<>(entity,HttpStatus.CREATED);
}
@GetMapping
public List<User> getAllUsers(){
	return this.service.getAllUsers();
}
@DeleteMapping
@RequestMapping("/{id}/{name}")
public ResponseEntity<User> deleteByIdAndName(@PathVariable("id")Long id,@PathVariable("name") String name) {
	this.service.deleteById(id,name);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
@DeleteMapping
@RequestMapping("/query/{id}/{name}")
public ResponseEntity<User> deleteByIdAndNameUsingQuery(@PathVariable("id")Long id,@PathVariable("name") String name) {
	this.service.deleteUsingQuery(id, name);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
