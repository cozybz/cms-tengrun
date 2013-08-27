package com.tengrun.DAO;

import java.util.List;

import com.tengrun.pojo.User;

public interface UserDAO {
	public boolean loginyz(User user);
	public int insert(User user);
	public int delete(int id);
	public int update(User user);
	public User queryById(int id);   
	public List<User> queryAll();   
}
