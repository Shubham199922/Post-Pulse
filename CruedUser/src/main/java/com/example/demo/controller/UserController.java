package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.services.UserServices;
import com.example.demo.wrapper.ResponseWrapper;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
UserServices userServices;

@GetMapping("")
@Cacheable("data")
public ResponseEntity getAllUsers() {
	System.out.println("inside all user");
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("All Users");
	reWrapper.setData(this.userServices.getAllUsers());
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
void responseDelay() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
@GetMapping("{id}")
public ResponseEntity getUserById(@PathVariable int id) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("User");
	reWrapper.setData(this.userServices.getUserById(id));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@GetMapping("find-by")
public ResponseEntity getUserByEmail(@RequestParam String email) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("User");
	reWrapper.setData(this.userServices.getUserByEmail(email));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@GetMapping("find-by-any")
public ResponseEntity getUserByAnyEmail(@RequestParam String email) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("User");
	reWrapper.setData(this.userServices.getUserByAnyEmail(email));
	return new ResponseEntity (reWrapper,HttpStatus.OK);
}
@GetMapping("/find-by-name")
public ResponseEntity getUserByName(@RequestParam String name) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("User");
	reWrapper.setData(this.userServices.getUserByName(name));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@GetMapping("/find-by-nameOrEmail")
public ResponseEntity getUserByNameAndEmail(@RequestParam(required = false) String name,@RequestParam(required = false)String email) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("User");
	reWrapper.setData(this.userServices.getUserByEmailAndName(name,email));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@GetMapping("/search")
public ResponseEntity getUserByNameOrEmail(@RequestParam(required = false) String name,@RequestParam(required = false)String email) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("User");
	reWrapper.setData(this.userServices.getUserByEmailAndName(name,email));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@PostMapping("")
public ResponseEntity cerateUser(@RequestBody @Valid User user) {
	this.userServices.createUser(user);
	return new ResponseEntity("user create successfully",HttpStatus.CREATED);
}
@DeleteMapping("{id}")
public ResponseEntity deleteUser(@PathVariable int id) {
	this.userServices.deleteUser(id);
	return new ResponseEntity(HttpStatus.NO_CONTENT);
}
@PutMapping("{id}")
public ResponseEntity updateUser(@PathVariable int id,@RequestBody User updateData) {
ResponseWrapper reWrapper=new ResponseWrapper();
reWrapper.setMsg("User update sucessfully");
reWrapper.setData(this.userServices.updateUser(id,updateData));
return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@PostMapping("/{id}/address")
public ResponseEntity addAddress(@PathVariable int id,@RequestBody Address address) {
ResponseWrapper reWrapper=new ResponseWrapper();
reWrapper.setMsg("Address added sucessfully");
reWrapper.setData(this.userServices.createAddress(id,address));
return new ResponseEntity(reWrapper,HttpStatus.OK);
}
}

