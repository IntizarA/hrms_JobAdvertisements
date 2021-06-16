package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.UserDao;
import com.example.demo.entity.concretes.User;
@Service
public class UserManager implements UserService {
private UserDao userDao;
@Autowired
	public UserManager(UserDao userDao) {
	super();
	this.userDao = userDao;
}

	@Override
	public DataResult<List<User>> getall() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"User's data listed successfully");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User's data added successfully");
	}




}
