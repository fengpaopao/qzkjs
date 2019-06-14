package com.qzsq.article.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/2/15 16:08
 * 4  配置springboot的数据源
 */
@Configuration
public class DruidConfig {

    //指定配置文件中的数据源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }



}
