package com.beyond233.mybatispluslearn.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-04 16:17
 */
@Configuration
@MapperScan({"com.beyond233.mybatispluslearn.mapper","com.beyond233.mybatispluslearn.generator.mapper"})
@EnableTransactionManagement
public class MyBatisPlusConfig {

    /**乐观锁*/
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**分页*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**逻辑删除*/
    @Bean
    public ISqlInjector iSqlInjector(){
        return new LogicSqlInjector();
    }

    /**SQL执行性能分析插件*/
    @Bean
    @Profile("dev")
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //SQL日志输出时格式化SQL语句，便于查看
        performanceInterceptor.setFormat(true);
        //设置SQL语句执行的最大时间，超过MaxTime则抛出异常
//        performanceInterceptor.setMaxTime(100L);

        return performanceInterceptor;
    }

}
