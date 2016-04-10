package com.xsalefter.stackoverflowmvn;

import java.io.PrintWriter;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class Config {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.xsalefter.stackoverflowmvn.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaProperties(hibernateProperties());

        return emf;
    }


    @Bean
    public PlatformTransactionManager transactionManager(final LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory.getObject());

        return txManager;
    }


    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();
        properties.setProperty("jdbcUrl", "jdbc:postgresql://localhost/general_testing");
        properties.setProperty("dataSource.user", "postgres");
        properties.setProperty("dataSource.password", "admin");
        properties.setProperty("dataSource.databaseName", "general_testing");
        properties.put("dataSource.logWriter", new PrintWriter(System.out));
        HikariConfig config = new HikariConfig(properties);

        return new HikariDataSource(config);
    }

    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.ProgressDialect");
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        return properties;
    }
}
