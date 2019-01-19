package SpringMvc.Frontend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import model.Product;
import service.ProductService;
import service.SubCategoryService;

@Controller
public class ProductController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/addProduct")
	public String addProductPage(Model model) {
		model.addAttribute("product", new  Product());
		model.addAttribute("subCategories",subCategoryService.getAllSubCategories());
		return "addProduct";
		
	}
	
	@PostMapping("/addProduct")
	public String addNewProduct(@ModelAttribute("product")Product product,HttpServletRequest request){
	
		if(productService.addProduct(product)) {
			System.out.println(request.getServletContext().getRealPath("/"));
			String appPath=request.getServletContext().getRealPath("/");
			
			File file=new File(appPath+"/resources/images");
			
			if(!file.exists()) {
				file.mkdirs();
			}
			try {
				InputStream is=product.getProductImage().getInputStream();
				byte[] imageBytes=new byte[is.available()];
				is.read(imageBytes);
				
				FileOutputStream fileOutputStream=new FileOutputStream(file.getPath()+"/"+product.getProductId()+".jpg");
				fileOutputStream.write(imageBytes);
				fileOutputStream.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/allProducts";
	}
    
	@GetMapping("/allProducts")
	public String allproducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "allProducts";
	}
	
	@GetMapping("/product/${id}")
	public String getProduct(@PathVariable("id")int productId) {
		productService.getProduct(productId);
		return "allProducts";
	}
}
