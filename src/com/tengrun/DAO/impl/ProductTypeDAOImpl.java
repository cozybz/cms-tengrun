package com.tengrun.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tengrun.DAO.ProductTypeDAO;
import com.tengrun.pojo.ProductType;
import com.tengrun.tools.DataBaseConnection;

public class ProductTypeDAOImpl implements ProductTypeDAO {

	@Override
	public int insert(String name) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="insert into product_type (productType) values (?)";
		dbc=new DataBaseConnection();
		
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, name);
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
	public int update(ProductType type) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="update product_type set productType=? where id=?";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, type.getProductType());
			pstmt.setInt(2, type.getId());
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
		String sql="delete from product_type where id=?";
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
	public List<ProductType> queryAll() {
		List<ProductType> all=new ArrayList<ProductType>();
		DataBaseConnection dbc=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql="select id,productType from product_type  order by id desc";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ProductType type=new ProductType();
				type.setId(rs.getInt(1));
				type.setProjectType(rs.getString(2));
				all.add(type);
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

	@Override
	public ProductType queryById(int id) {
		ProductType type=null;
		DataBaseConnection dbc=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql="select id,productType from product_type where id=?";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				type=new ProductType();
				type.setId(rs.getInt(1));
				type.setProjectType(rs.getString(2));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return type;
	}

}
