package fr.formation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableTransactionManagement 
@EnableJpaRepositories("dao")
public class JpaConfig 
{
	@Bean
	public DataSource dataSource() 
	{
		BasicDataSource dataSource = new BasicDataSource();

		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/restaurants");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMaxTotal(10);

		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource)
	{
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

		
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(this.hibernateProperties());

		return emf; 
	}

	public Properties hibernateProperties() 
	{
		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "false");

		return properties;
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
	
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
}
