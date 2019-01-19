package service;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.SubCategory;

@Component
@Transactional
public class SubCategoryService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public SubCategoryService()
	{
		Configuration configuration=new Configuration();
		configuration.configure();
		
		sessionFactory=configuration.buildSessionFactory();
	}*/
	
	public boolean addSubCategory(SubCategory subcategory)
	{
	/*boolean result=true;
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();*/
	try{
		sessionFactory.getCurrentSession().save(subcategory);
	/*session.save(subcategory);*/
	/*tx.commit();*/
	return true;
	}catch(Exception e)
	  {
		
		e.printStackTrace();
		/*tx.rollback();*/
		sessionFactory.getCurrentSession().clear();
		return false;
	  }
}
	public boolean deleteSubCategory(SubCategory subcategory) {
		
		boolean result=true;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		try {
			
			session.delete(subcategory);
			tx.commit();
		
		}catch(Exception e)
		{
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			tx.rollback();
			result=false;
		}
		finally {
			session.close();
		}
	return result;
	}
	public SubCategory getSubCategory(int subCategoryId)
	{
		Session session=sessionFactory.openSession();
		try {
		return session.get(SubCategory.class,subCategoryId);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public List<SubCategory> getAllSubCategories(){
		Session session=sessionFactory.getCurrentSession();
		try {
			
				Query<SubCategory> query=session.createQuery("from SubCategory",SubCategory.class);
					List<SubCategory> list=query.getResultList();
					return list;
		}catch(Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return null;
		}
	}
}
