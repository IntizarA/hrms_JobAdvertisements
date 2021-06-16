package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
