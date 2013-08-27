package com.tengrun.DAO;

import java.util.List;

import com.tengrun.pojo.ProductType;

public interface ProductTypeDAO {
	 public int insert(String name);
	 public int update(ProductType type);
	 public int delete(int id);   
	 public List<ProductType> queryAll();  
	 public ProductType queryById(int id);   
}
