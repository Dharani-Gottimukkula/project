package Category.xmldemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassesKey;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import SpringMvc.xmldemo.HibernateConfiguration;
import model.Category;
import service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HibernateConfiguration.class)
public class CategoryTestCases {
	
	private Category category;
	@Autowired
	private CategoryService categoryService;

	@Before
	public void setUp()
	{
		 category=new Category();
		category.setCategoryName("electronics");
		category.setCategoryDescription("this is electronics section");
	
		//categoryService=new CategoryService();
	}
	
	@Test
	public void testAddCategory1() {
		assertTrue(categoryService.addCategory(category));
	}
	
	/*@Test
	public void testGetCategory() {
		categoryService.addCategory(category);
		assertEquals(category,categoryService.getCategory(category.getCategoryId()));
	}*/
	
	@After
	public void tearDown() {
		categoryService.deleteCategory(category);
	}
}
