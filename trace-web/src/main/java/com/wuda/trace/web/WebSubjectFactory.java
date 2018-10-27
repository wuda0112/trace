package com.wuda.trace.web;

import com.wuda.trace.log.identity.Subject;
import com.wuda.trace.log.identity.SubjectFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成{@link Subject}实例.
 */
public interface WebSubjectFactory extends SubjectFactory {

    /**
     * 根据request/response生成{@link Subject}实例.
     *
     * @param request
     *         请求
     * @param response
     *         响应
     * @return {@link Subject}
     */
    Subject createSubject(HttpServletRequest request, HttpServletResponse response);

}
