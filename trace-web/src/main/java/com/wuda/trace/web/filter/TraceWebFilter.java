package com.wuda.trace.web.filter;

import com.wuda.trace.log.SubjectUtil;
import com.wuda.trace.log.identity.Subject;
import com.wuda.trace.web.WebSubjectFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当请求进入时,根据{@link ServletRequest}和
 * {@link ServletResponse}生成{@link Subject},然后绑定到当前线程.
 */
public class TraceWebFilter implements Filter {

    /**
     * 用于生成{@link Subject}实例.
     */
    private WebSubjectFactory webSubjectFactory;

    /**
     * 实例化.
     *
     * @param webSubjectFactory
     *         用于生成{@link Subject}实例.
     */
    public TraceWebFilter(WebSubjectFactory webSubjectFactory) {
        this.webSubjectFactory = webSubjectFactory;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Subject subject = webSubjectFactory.createSubject((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
            SubjectUtil.bind(subject);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            SubjectUtil.unbind();
        }
    }

}
