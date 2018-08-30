package com.zsc.trade.config;

import com.zsc.trade.hander.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addPathPatterns中/**表示所有的路径都拦截，/*表示只拦截localhost：8080/的一层路径
         */
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .addPathPatterns("/")
                .excludePathPatterns("/login");

    }
}
