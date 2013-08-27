package com.tengrun.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tengrun.DAO.ProductDAO;
import com.tengrun.pojo.Product;
import com.tengrun.tools.DataBaseConnection;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int insert(Product product) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="insert into t_product (productType,information,imgURL,name) values (?,?,?,?)";

		try {
			dbc=new DataBaseConnection();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, product.getProductType());
			pstmt.setString(2, product.getInformation());
			pstmt.setString(3, product.getImgUrl());
			pstmt.setString(4, product.getName());
			

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
	public int update(Product product) {
		// TODO Auto-generated method stub
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="update t_product set productType=?,information=?,imgURL=?,name=? where id=?";
		
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, product.getProductType());
			pstmt.setString(2, product.getInformation());
			pstmt.setString(3, product.getImgUrl());
			pstmt.setString(4, product.getName());
			pstmt.setInt(5, product.getId());
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
	public int delete(int id) {
		int flag=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql="delete from t_product where id=?";
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
	public Product queryById(int id) {
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product product=null; 
		String sql="select id,productType,information,imgURL,name from t_product where id=?";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
					product = new Product();
					product.setId(rs.getInt(1));
					product.setProductType(rs.getString(2));
					product.setInformation(rs.getString(3));
					product.setImgUrl(rs.getString(4));
					product.setName(rs.getString(5));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return product;
	}

	@Override
	public List<Product> queryAll() {
		List<Product> all=new ArrayList<Product>();
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product product=null;
		String sql="select id,productType,information,imgURL,name from t_product order by id desc";
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				product = new Product();
				product.setId(rs.getInt(1));
				product.setProductType(rs.getString(2));
				product.setInformation(rs.getString(3));
				product.setImgUrl(rs.getString(4));
				product.setName(rs.getString(5));
				all.add(product);
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
	public List<Product> queryByLike(String cond) {
		 List<Product> all = new ArrayList<Product>();
		 String sql = "select id,productType,information,imgURL,name from t_product where id like ? or productType like ? or information like ?";
		 PreparedStatement pstmt = null;
		 DataBaseConnection dbc = null;
		 dbc = new DataBaseConnection();
		 	 
		 try {
			 pstmt = dbc.getConnection().prepareStatement(sql);
			 pstmt.setString(1, "%" + cond + "%");
			 pstmt.setString(2, "%" + cond + "%");
			 pstmt.setString(3, "%" + cond + "%");
			 
			 ResultSet rs = pstmt.executeQuery();
			 while (rs.next())
			 {
				 Product product = new Product();
				product.setId(rs.getInt(1));
				product.setProductType(rs.getString(2));
				product.setInformation(rs.getString(3));
				product.setImgUrl(rs.getString(4));
				product.setName(rs.getString(5));
				all.add(product);
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
	public List<Product> queryByPage(String type, int maxline, int curpage) {
		List<Product> all=new ArrayList<Product>();
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		String sql=null;
		ResultSet rs=null;
		dbc=new DataBaseConnection();
		try {
			if(type==null)
			{
				sql="select id,productType,information,imgURL,name from t_product  order by id desc  limit ?,?";
				pstmt=dbc.getConnection().prepareStatement(sql);
				pstmt.setInt(1, (curpage-1)*maxline);
				pstmt.setInt(2, maxline);
				rs=pstmt.executeQuery();
			}else{
				sql="select id,productType,information,imgURL,name from t_product where productType=?  order by id desc limit ?,?";
				pstmt=dbc.getConnection().prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, (curpage-1)*maxline);
				pstmt.setInt(3, maxline);
				rs=pstmt.executeQuery();
			}

			while(rs.next())
			{
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setProductType(rs.getString(2));
				product.setInformation(rs.getString(3));
				product.setImgUrl(rs.getString(4));
				product.setName(rs.getString(5));
				all.add(product);
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
	public int totalPage(String type, int maxline) {
		int total=0;
		DataBaseConnection dbc=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		dbc=new DataBaseConnection();

		try {
			if(type!=null)
			{
				sql="select id from t_product where productType=?";
				pstmt=dbc.getConnection().prepareStatement(sql);
				pstmt.setString(1, type);
				rs=pstmt.executeQuery();
			}else{
				sql="select id from t_product";
				pstmt=dbc.getConnection().prepareStatement(sql);
				rs=pstmt.executeQuery();
			}

			while(rs.next())
			{
				total++;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		if(total%maxline>0)
		{
			total=total/maxline+1;
		}else{
			total=total/maxline;
		}
		return total;
	}
	}


