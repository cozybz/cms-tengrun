package com.tengrun.DAO;
import com.tengrun.pojo.Product;
import java.util.List;

public interface ProductDAO {
	 public int insert(Product product);
	 public int update(Product product);
	 public int delete(int id);   
	 public Product queryById(int id);   
	 public List<Product> queryAll();   
	 public List<Product> queryByLike(String cond);
	 public List<Product> queryByPage(String type,int maxline,int curpage);
	 public int totalPage(String type,int maxline);
}
