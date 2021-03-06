package com.mine.warriorsserverribbon.config;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler;
import com.mine.warriorsservercommon.config.filter.CrossFilter;
import com.mine.warriorsservercommon.utils.RestTemplateUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @Program: warriors-party
 * @Description: 全局配置
 * @Author: Mine.Lee
 * @Create: 2018-11-15 18:42
 * @Version: v1.0
 */
@Configuration
public class GlobalConfig {

    @Bean
    LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    CrossFilter CrossFilter() {
        return new CrossFilter();
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    RestTemplateUtil restTemplateUtil() {
        return new RestTemplateUtil();
    }

}
