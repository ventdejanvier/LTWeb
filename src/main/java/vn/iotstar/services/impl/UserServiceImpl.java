package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService {
	// Lấy toàn bộ hàm trong tầng Dao của User
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		
		return userDao.findByUsername(username);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (this.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel(username, email, password, fullname, null, phone, 1, date));
			return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistUsername(phone);
		
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	public boolean changePassword(String username, String newPassword) {
		return userDao.changePassword(username, newPassword);
	}

}