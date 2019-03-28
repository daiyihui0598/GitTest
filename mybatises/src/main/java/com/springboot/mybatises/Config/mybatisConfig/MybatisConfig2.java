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
@MapperScan(basePackages = "com.springboot.mybatises.Dao.test2",sqlSessionFactoryRef = "test2sqlSessionFactoryBean")
public class MybatisConfig2 {


    @Bean(name="test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="test2sqlSessionFactoryBean")
    public SqlSessionFactory getSqlSessionFactoryBean(@Qualifier("test2DataSource")DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/test2/*.xml"));
        return bean.getObject();
    }

    @Bean("test2SqlSessionTemplate")
    // 表示这个数据源是默认数据源
    public SqlSessionTemplate test2sqlsessiontemplate(
            @Qualifier("test2sqlSessionFactoryBean") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

}
