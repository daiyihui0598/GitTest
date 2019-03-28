package com.springboot.mybatises.Config.mybatisConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;



@Configuration
@MapperScan(basePackages = "com.springboot.mybatises.Dao.test1",sqlSessionFactoryRef = "test1sqlSessionFactoryBean")
public class MybatisConfig1  {

    @Bean(name="test1DataSource")
    @Primary
    //@Primary默认是这个配置，config2中不能加,只能有一个默认配置
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }
     
    @Bean(name="test1sqlSessionFactoryBean")
    @Primary
    public SqlSessionFactory getSqlSessionFactoryBean(@Qualifier("test1DataSource")DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/test1/*.xml"));
        return bean.getObject();
    }

    @Bean("test1SqlSessionTemplate")
    // 表示这个数据源是默认数据源
    @Primary
    public SqlSessionTemplate test1sqlsessiontemplate(
            @Qualifier("test1sqlSessionFactoryBean") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

}
