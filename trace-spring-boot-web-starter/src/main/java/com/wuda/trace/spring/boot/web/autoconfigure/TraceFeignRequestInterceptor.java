package com.wuda.trace.spring.boot.web.autoconfigure;

import com.wuda.trace.log.SubjectUtil;
import com.wuda.trace.web.Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(RequestInterceptor.class)
public class TraceFeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        /*
          feign 发送请求前,添加header.
         */
        requestTemplate.header(Constant.HEADER_REQUEST_ID, SubjectUtil.getSubject().getRequestId());
    }
}
