package SpringMvc.Frontend;

import org.hibernate.metamodel.internal.AbstractAttribute;
import org.hibernate.tuple.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import model.Category;
import model.SubCategory;

import service.CategoryService;
import service.SubCategoryService;

@Controller
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	
	
	
@RequestMapping("/")	
public  ModelAndView index() {
	 ModelAndView mv=new ModelAndView("index");
	return mv;
}


    /*@RequestMapping(value="/addcategory",method=RequestMethod.GET)*/

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
    	model.addAttribute("category", new Category());
        return "addcategory";
    }
    
      /*@RequestMapping(value="/addcategory",method=RequestMethod.POST)*/
      
      @PostMapping("/addcategory")
       public String addNewCategory(@ModelAttribute("category")Category category){
       categoryService.addCategory(category);
       return "redirect:/allCategories";
    }
    
      @GetMapping("/allCategories")
      public String allCategoriesPage(Model model) {
    	  model.addAttribute("categories",categoryService.getAllCategories());
    	  return "allCategories";
      }
	  
      @GetMapping("/editcategory/{categoryId}")
      public String editCategory(@PathVariable("categoryId")int categoryId, Model model) {
      model.addAttribute("category",categoryService.getCategory(categoryId));
      return "editcategory";
    	  
      }
      @PostMapping("/updatecategory")
      public String updateCategory(@ModelAttribute("category")Category category) {
    	  categoryService.updateCategory(category);
    	  return"redirect:/allCategories";
    	  
      }
      
     
      @GetMapping("/addsubcategory")
      public String addSubCategoryPage(Model model) {
    	  model.addAttribute("categories", categoryService.getAllCategories());
    	  model.addAttribute("subcategory",new SubCategory() );
    	  return "addsubcategory";
      }
      
      @PostMapping("/addsubcategory")
      public String addSubCategory(@ModelAttribute("subcategory")SubCategory subcategory) {
    	  subCategoryService.addSubCategory(subcategory);
    	  return "redirect:/allsubcategories";
      }
      
      @RequestMapping("/allsubcategories")
      public String allSubCategories(Model model) {
    	  model.addAttribute("subcategories",subCategoryService.getAllSubCategories());
    	  return "allsubcategories";
      }
	/*@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("myname","dharani");
		return mv;
	}*/

}
