package service;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.Product;
@Component
@Transactional
public class ProductService {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
	try {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}catch(Exception e) {
		e.printStackTrace();
		sessionFactory.getCurrentSession().clear();
	    return false;
	}
	}
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateProduct(Product productId) {
		try {
			sessionFactory.getCurrentSession().update(productId);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Product getProduct(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, productId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Product> getAllProducts(){
	
		Session session=sessionFactory.getCurrentSession();
		try {
			Query<Product> query=session.createQuery("from Product",Product.class);
			List<Product> list=query.getResultList();
			return list;
		}catch(Exception e) {
			sessionFactory.getCurrentSession().clear();
		    e.printStackTrace();
		    return null;
		}
	}
}
