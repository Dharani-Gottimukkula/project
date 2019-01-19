package SpringMvc.xmldemo;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="service")
@EnableTransactionManagement
public class HibernateConfiguration {
	
	/*dataSource(){
		
		BasicDataSource source=new BasicDataSource();
		source.setDriverClassName("org.h2.Driver");
		source.setUrl("jdbc:h2:tcp://localhost/~/Demo1");
		source.setUsername("sa");
		source.setPassword("sa");
	}
	
	property(){
		
		Properties p=new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql","true" );
	}*/

	@Bean
	public SessionFactory getSessionFactory() {
		BasicDataSource source=new BasicDataSource();
		source.setDriverClassName("org.h2.Driver");
		source.setUrl("jdbc:h2:tcp://localhost/~/hibernatedemo");
		source.setUsername("sa");
		source.setPassword("sa");
		
		Properties p=new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql","true" );
		
		LocalSessionFactoryBuilder session=new LocalSessionFactoryBuilder(source);
		//session.setProperties(p);
		session.addProperties(p);
		session.scanPackages("model");
		SessionFactory sf=session.buildSessionFactory();
		return sf;
		
	}
      @Bean	
	  public HibernateTransactionManager manager(SessionFactory sessionFactory) {
		  HibernateTransactionManager manager=new HibernateTransactionManager(sessionFactory);
		  return manager;
	  }

	}
