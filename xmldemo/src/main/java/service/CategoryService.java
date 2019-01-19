package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.Category;


@Component
@Transactional
public class CategoryService {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public CategoryService() { Configuration configuration=new Configuration();
	 * configuration.configure();
	 * 
	 * sessionFactory=configuration.buildSessionFactory(); }
	 */

	public boolean addCategory(Category category) {

		boolean result = true;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(category);
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return result;
	}

	/*
	 * try { sessionFactory.getCurrentSession().save(category); return true;
	 * }catch(Exception e) { e.printStackTrace();
	 * sessionFactory.getCurrentSession().clear(); return false; }
	 */

	public boolean deleteCategory(Category category) {
		{
			boolean result = true;
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			try {
				session.delete(category);
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
				return false;
			} finally {
				session.close();
			}
			return result;
		}
	}

	public Category getCategory(int categoryId) {

		Session session = sessionFactory.openSession();
		try {
			return session.get(Category.class, categoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean updateCategory(Category categoryId) {
		try {
			sessionFactory.getCurrentSession().update(categoryId);
		return true;
		  }catch(Exception e) { 
			  e.printStackTrace();
		  sessionFactory.getCurrentSession().clear(); 
		  return false; 
		
	}
	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession();
		try {
			Query<Category> query = session.createQuery("from Category", Category.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}