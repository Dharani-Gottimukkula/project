package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.User;
@Component
@Transactional
public class UserService {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean  addUser(User user) {
		
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return false;
		}
	}
	public User getUser(int userId) {
		try {
			return sessionFactory.getCurrentSession().get(User.class,userId);
		}catch(Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return null;
		}
	}
	
	public List<User> getAllUsers(){
		Session session=sessionFactory.getCurrentSession();
		try {
			Query<User> query=session.createQuery("from user",User.class);
			List<User> list=query.getResultList();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return null;
		}
	}
	
	public User login(String username,String password) {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("From User where username=:uname and password=:pass",User.class);
		    query.setParameter("uname",username);
		    query.setParameter("pass", password);
		     
		    return query.getSingleResult();
		}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}
}