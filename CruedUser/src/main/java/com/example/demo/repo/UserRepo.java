package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;
import com.example.demo.projection.UserProjection;

public interface UserRepo extends CrudRepository<User, Integer> {
public Iterable<UserProjection> findAllUsersBy();
public Iterable<UserProjection> findUserById(int id);
public Iterable<UserProjection> findByEmail(String email);
public Iterable<UserProjection> findByEmailContaining(String email);
public Iterable<UserProjection> findByName(String name);
public Iterable<UserProjection> findByNameOrEmail(String name,String email);
public Iterable<UserProjection> findAByNameContainingOrEmailContaining(String name,String email);

}
