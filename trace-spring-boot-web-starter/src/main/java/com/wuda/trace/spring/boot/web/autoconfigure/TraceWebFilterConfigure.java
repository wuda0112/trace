package com.wuda.trace.spring.boot.web.autoconfigure;

import com.wuda.trace.web.AnonymousWebSubjectFactory;
import com.wuda.trace.web.WebSubjectFactory;
import com.wuda.trace.web.filter.TraceWebFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceWebFilterConfigure {

    @Bean
    @ConditionalOnMissingBean
    public WebSubjectFactory getWebSubjectFactory() {
        return new AnonymousWebSubjectFactory();
    }

    @Bean
    public FilterRegistrationBean<TraceWebFilter> traceWebFilterRegistrationBean() {
        FilterRegistrationBean<TraceWebFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(traceWebFilter());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public TraceWebFilter traceWebFilter() {
        return new TraceWebFilter(getWebSubjectFactory());
    }

}
