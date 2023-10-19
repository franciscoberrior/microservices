package org.neoris.microservices.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "accountEntityManagerFactory",
    transactionManagerRef = "accountTransactionManager",
    basePackages = {"org.neoris.microservices.accounts"})
public class AccountDatasourceConfiguration {

  @Value("${spring.datasource.account.username}")
  private String username;
  @Value("${spring.datasource.account.password}")
  private String password;
  @Value("${spring.datasource.account.url}")
  private String url;

  @Bean(name = "accountProperties")
  @ConfigurationProperties("spring.datasource.account")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(name = "accountDatasource")
  @ConfigurationProperties(prefix = "spring.datasource.account")
  public DataSource datasource(@Qualifier("accountProperties") DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().build();
  }

  @Bean(name = "accountEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
      (EntityManagerFactoryBuilder builder,
          @Qualifier("accountDatasource") DataSource dataSource) {
    return builder.dataSource(dataSource)
        .packages("org.neoris.microservices.accounts")
        .persistenceUnit("accounts").build();
  }

  @Bean(name = "accountTransactionManager")
  @ConfigurationProperties("spring.jpa")
  public PlatformTransactionManager transactionManager(
      @Qualifier("accountEntityManagerFactory") EntityManagerFactory entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}