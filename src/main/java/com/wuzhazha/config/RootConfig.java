package com.wuzhazha.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static org.springframework.context.annotation.ComponentScan.*;
/**
 * spring ioc的上下文配置
 * @Author:wuzhazha
 * @Date: 2018/8/12 16:30
 * @Description:
 */
@Configuration
//定义spring的扫描报
@ComponentScan(value = "com.*",includeFilters = {@Filter(type = FilterType.ANNOTATION,value = {Service.class})})
@EnableTransactionManagement
//实现TransactionManagementConfigurer接口，可以配置注解驱动事务
public class RootConfig implements TransactionManagementConfigurer {
    private DataSource dataSource = null;

    /**
     * 初始化数据源
     * @return
     */
    @Bean(name="dataSource")
    public DataSource initDataSource(){
        if(dataSource != null){
            return dataSource;
        }
        Properties props = new Properties();
        props.setProperty("driverClassName","com.mysql.jdbc.Driver");
        props.setProperty("url","jdbc:mysql://localhost:3306/mytest");
        props.setProperty("username","root");
        props.setProperty("password","12345");
        props.setProperty("maxActive","200");
        props.setProperty("maxIdle","20");
        props.setProperty("maxWait","30000");
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    /**
     * mybatis session 工厂
     * @return
     */
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean initSqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(initDataSource());
        //配置mybatis配置文件
        Resource resource = new ClassPathResource("mybatis/mybatis-config.xml");
        sqlSessionFactory.setConfigLocation(resource);
        return sqlSessionFactory;
    }

    /**
     * mybatis接口扫描
     * @return
     */
    @Bean
    public MapperScannerConfigurer initMapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //扫描包
        msc.setBasePackage("com.*");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //区分注解扫描
        msc.setAnnotationClass(Repository.class);
        return msc;
    }

    /**
     * 注册注解事务，当@Transactional 使用的时候产生事务
     * @return
     */
    @Override
    @Bean(name="annotationDrivenTransactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }
}
