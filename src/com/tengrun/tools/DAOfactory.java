package com.tengrun.tools;

import com.tengrun.DAO.ProductDAO;
import com.tengrun.DAO.ProductTypeDAO;
import com.tengrun.DAO.UserDAO;
import com.tengrun.DAO.impl.ProductDAOImpl;
import com.tengrun.DAO.impl.ProductTypeDAOImpl;
import com.tengrun.DAO.impl.UserDAOImpl;

public class DAOfactory 
{
	
	public static UserDAO getUserDAOInstance()
	{  
		return new UserDAOImpl();
	}  
	public static ProductDAO getProductDAOInstance()
	{  
		return new ProductDAOImpl(); 
	}  
	public static ProductTypeDAO getProductTypeDAOInstance()
	{  
		return new ProductTypeDAOImpl(); 
	}  
}

