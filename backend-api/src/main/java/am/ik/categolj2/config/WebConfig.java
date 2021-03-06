package am.ik.categolj2.config;

import am.ik.categolj2.core.web.accesslog.AccessLogMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.terasoluna.gfw.web.logging.TraceLoggingInterceptor;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    AccessLogMethodArgumentResolver accessLogMethodArgumentResolver() {
        return new AccessLogMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(accessLogMethodArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TraceLoggingInterceptor());
    }
}
