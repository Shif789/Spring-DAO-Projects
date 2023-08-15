package in.ineuron.config.product;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "db2EntityManagerFactory",
		transactionManagerRef = "db2TransactionManager",
		basePackages = "in.ineuron.repo.product"
		)
public class Db2Config {

	//DataSource
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "db2.datasource")
	public DataSource db2DataSource() {
		
		return DataSourceBuilder.create().build();
	}
	
	//EntityManagerFactory
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder emfb) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		
		return emfb.dataSource(db2DataSource()).packages("in.ineuron.config.model.product").properties(map).persistenceUnit("ineuronDb").build();
	}
	
	// TransactionManagement
	@Bean
	@Primary
	public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
