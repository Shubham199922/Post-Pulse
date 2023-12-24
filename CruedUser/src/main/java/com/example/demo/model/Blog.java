package com.example.demo.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity

public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	@Size(min = 4,max = 10)
	@Column(name = "username",updatable = true)
private String name;
	@NotNull
	@NotBlank
	@Column(nullable = false,unique = true)
private String title;
private String description;


@CreatedDate
private Instant createDate;
@LastModifiedDate
private Instant updateDate;



public Instant getCreateDate() {
	return createDate;
}



public void setCreateDate(Instant createDate) {
	this.createDate = createDate;
}



public Instant getUpdateDate() {
	return updateDate;
}



public void setUpdateDate(Instant updateDate) {
	this.updateDate = updateDate;
}



Blog(){
	
}



public Blog(int id, String name, String title, String description) {
	super();
	this.id = id;
	this.name = name;
	this.title = title;
	this.description = description;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}

}
