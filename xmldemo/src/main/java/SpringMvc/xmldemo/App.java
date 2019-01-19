package SpringMvc.xmldemo;

import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.CategoryService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      /*Configuration configuration=new Configuration();
      configuration.configure();
      
      configuration.buildSessionFactory();*/
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HibernateConfiguration.class);
    	System.out.println(context.getBean(CategoryService.class));
    }
}
