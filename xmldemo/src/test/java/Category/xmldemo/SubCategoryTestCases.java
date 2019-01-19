package Category.xmldemo;



import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import SpringMvc.xmldemo.HibernateConfiguration;
import model.Category;
import model.SubCategory;
import service.CategoryService;
import service.SubCategoryService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HibernateConfiguration.class)
public class SubCategoryTestCases {
	
	private Category category;
	
	@Autowired
	private CategoryService categoryService;
	private SubCategory subCategory;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Before
	public void setUp() {
		
	           category=new Category();
	       	category.setCategoryName("Electronics");
	        category.setCategoryDescription("this is electronics ");
	        categoryService.addCategory(category);
	         //  categoryService=new CategoryService();
	           subCategory=new SubCategory();
	           subCategory.setCategory(category);
	          // subCategoryService=new SubCategoryService();
	           
		
	}
	
	@Test
	public void testAddSubCategory() {
		 
		//subCategory.setCategory(category);
	
      //  categoryService.addCategory(category);
		subCategory.setSubCategoryName("laptop");
		subCategory.setSubCategoryDescription("This is laptop section");
		assertTrue(subCategoryService.addSubCategory(subCategory));
	}
	
	/*
	@Test
	public void testAddSubCategory1() {
		subCategory.setSubCategoryName("Laptops");
	 	subCategory.setSubCategoryDescription("This is Laptop section");
	  	SubCategory subCategory2=new SubCategory();
	   	subCategory2.setSubCategoryName("Mobiles");
	 	subCategory2.setSubCategoryDescription("This is mobile section");
	   assertTrue(subCategoryService.addSubCategory(subCategory));
	        assertTrue(subCategoryService.addSubCategory(subCategory2));
	      subCategoryService.deleteSubCategory(subCategory2);
	    
	}*/

	@After
	public void delete() {
		subCategoryService.deleteSubCategory(subCategory);
		categoryService.deleteCategory(category);
	}
}
