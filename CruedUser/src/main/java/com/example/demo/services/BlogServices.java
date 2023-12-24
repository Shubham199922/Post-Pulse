package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Blog;
import com.example.demo.repo.BlogRepo;

@Service
public class BlogServices {
@Autowired
BlogRepo blogRepo;

public Iterable<Blog> getAllBlogs(){
	return this.blogRepo.findAll();
}
public Blog getBlogById(int id) {
	return this.blogRepo.findById(id).orElseThrow(()-> { throw new ResponseStatusException(HttpStatus.NOT_FOUND,"blog not found");});
	
}
public Blog create(Blog blog) {
	return this.blogRepo.save(blog);
}
public void deleteBlog(int id) {
	this.blogRepo.findById(id).orElseThrow(()->{ throw new ResponseStatusException(HttpStatus.NOT_FOUND,"blog not found");});
	this.blogRepo.deleteById(id);
}
public Blog updateBlog(int id,Blog blog) {
	this.blogRepo.findById(id).orElseThrow(()->{ throw new ResponseStatusException(HttpStatus.NOT_FOUND,"blog not found");});
	blog.setId(id);
	return this.blogRepo.save(blog);
}

}
