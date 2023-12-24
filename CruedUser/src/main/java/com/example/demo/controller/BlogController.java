package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Blog;
import com.example.demo.services.BlogServices;
import com.example.demo.wrapper.ResponseWrapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blogs")
public class BlogController {
@Autowired
BlogServices blogServices;

@GetMapping("")
public ResponseEntity getAllBlogs() {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("All Blogs");
	reWrapper.setData(this.blogServices.getAllBlogs());
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@GetMapping("{id}")
public ResponseEntity getUserById(@PathVariable int id) {
	Blog blog=this.blogServices.getBlogById(id);
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("Blog");
	reWrapper.setData(this.blogServices.getBlogById(id));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
@PostMapping("")
public ResponseEntity createBlog(@RequestBody @Valid Blog blog) {
	this.blogServices.create(blog);
	return new ResponseEntity("user create sucessfiully",HttpStatus.CREATED);
}
@DeleteMapping("{id}")
public ResponseEntity deleteUser(@PathVariable int id) {
	this.blogServices.deleteBlog(id);;
	return new ResponseEntity(HttpStatus.NO_CONTENT);
}
@PutMapping("{id}")
public ResponseEntity updateUser(@PathVariable int id, @RequestBody Blog updataData) {
	ResponseWrapper reWrapper=new ResponseWrapper();
	reWrapper.setMsg("Blog update sucessfully");
	reWrapper.setData(this.blogServices.updateBlog(id, updataData));
	return new ResponseEntity(reWrapper,HttpStatus.OK);
}
}
