package com.verizon.consumer.springdatacassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.consumer.springdatacassandra.Entity.User;
import com.verizon.consumer.springdatacassandra.Repository.UserRepository;

@Service
public class UserService {
@Autowired
UserRepository repo;
public User saveUser(User obj) {
	return this.repo.save(obj);
}
public List<User> getAllUsers(){
	return this.repo.findAll();
}
public void deleteById(Long id,String name) {
	this.repo.deleteByIdAndName(id, name);
}
public void deleteUsingQuery(Long id,String name) {
	this.repo.deleteByIdAndNameUsingQuery(id, name);
}
}
