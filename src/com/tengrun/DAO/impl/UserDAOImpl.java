package com.tengrun.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tengrun.DAO.UserDAO;
import com.tengrun.pojo.User;
import com.tengrun.tools.DataBaseConnection;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean loginyz(User user) {
		boolean flag=false;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select id from t_user where username=? and password=?";
		dbc=new DataBaseConnection();
		
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				flag=true;			
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}

	@Override
	public int insert(User user) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="insert into t_user (username,password) values (?,?)";
		try {
			dbc=new DataBaseConnection();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			flag=pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		
		
		return flag;
	}

	@Override
	public int delete(int id) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="delete from t_user where id=?";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			flag=pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}

	@Override
	public int update(User user) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="update t_user set password=? where id=?";
		
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setInt(2, user.getId());
			flag=pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}

	@Override
	public User queryById(int id) {
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null; 
		String sql="select id,username from t_user where id=?";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
					user = new User();
					user.setId(rs.getInt(1));
					user.setUsername(rs.getString(2));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		
		return user;
	}

	@Override
	public List<User> queryAll() {
		List<User> all=new ArrayList<User>();
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;
		String sql="select id,username from t_user";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				all.add(user);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		
		return all;
	}
}
