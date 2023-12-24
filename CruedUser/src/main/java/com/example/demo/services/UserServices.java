package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.projection.UserProjection;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.UserRepo;

@Service
public class UserServices {
@Autowired
UserRepo userRepo;

@Autowired
AddressRepo addressRepo;
	
	public User getUserWithPassword(int id) {
		return this.userRepo.findById(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");});
		
	}
	public Iterable<UserProjection> getAllUsers(){
		return this.userRepo.findAllUsersBy();
	}
	public UserProjection getUserById(int id) {
		return this.userRepo.findUserById(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");});
		
	}
	public UserProjection getUserByEmail(String email) {
		return this.userRepo.findByEmail(email).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");});
		
	}
	public Iterable<UserProjection> getUserByAnyEmail(String email){
		return this.userRepo.findByEmailContaining(email);
	}
	public Iterable<UserProjection> getUserByName(String name){
		return this.userRepo.findByName(name);
	}
	public Iterable<UserProjection> getUserByEmailAndName(String name,String email){
		return this.userRepo.findByNameOrEmail(name, email);
	}
	public Iterable<UserProjection> getUserByAnyNameOrEmail(String email,String name){
		return this.userRepo.findAByNameContainingOrEmailContaining(name, email);
	}
	public User createUser(User user) {
		return this.userRepo.save(user);
	}
	public void deleteUser(int id) {
		this.userRepo.findById(id).orElseThrow(()->{ throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");});
		this.userRepo.deleteById(id);
	}
	public User updateUser(int id,User user) {
		User userdate=getUserWithPassword(id);
		user.setId(id);
		user.setCreateDate(userdate.getCreateDate());
		return this.userRepo.save(user);
	}
	public Address createAddress(int id, Address address) {
	User userdata=getUserWithPassword(id);
	Address addressdata=this.addressRepo.save(address);
	userdata.setAddress(addressdata);
	this.userRepo.save(userdata);
	return addressdata;
}
}
