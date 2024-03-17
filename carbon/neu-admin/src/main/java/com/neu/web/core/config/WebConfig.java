package com.neu.web.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许跨域的域名
                .allowedMethods("*") // 允许的请求方法
                .allowedHeaders("*") // 允许的头部设置
                .allowCredentials(true);
    }
}
