package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;
import vn.iotstar.configs.DBConnectMySQL;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM Users  ";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				List<UserModel> list = new ArrayList<UserModel>();
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("fullname"), rs.getString("images"),
						rs.getString("phone"), rs.getInt("roleid"), rs.getDate("createDate")));
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByid(int id) {
		String sql = "SELECT * FROM Users WHERE id = ? ";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(username,email,password,images,fullname, phone, roleid,createDate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImage());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreateDate());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserModel findByUsername(String username) {

		String sql = "SELECT * FROM Users WHERE username = ? ";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean register(String username, String email, String password, String fullname, String images) {
		if (this.checkExistUsername(username) || this.checkExistEmail(email))
			return false;
		// this.insert(new UserModel( username, email, password, fullname, images));
		return true;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "select * from users where username = ?";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean checkExistEmail(String email) {
		String sql = "select * from users where email = ?";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		IUserDao userDao = new UserDaoImpl();
		try {

			// System.out.println(userDao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean changePassword(String username, String newPassword) {
		String sql = "UPDATE users SET password = ? WHERE username = ?";

		try {
			conn = getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, username);

			int result = ps.executeUpdate();
			if (result > 0) {
				return true; // Password updated successfully
			} else {
				return false; // No rows updated, username not found
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false; // An error occurred during the update
		}
	}
}