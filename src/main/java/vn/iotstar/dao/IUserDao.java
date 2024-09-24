package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findByid(int id);
	
	void insert(UserModel user);
	
	UserModel findByUsername(String username);
	

	UserModel login(String username, String password);
	
	boolean register(String username, String email, String password, String fullname, String image);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistEmail(String email);

	boolean changePassword(String username, String newPassword);
	
}