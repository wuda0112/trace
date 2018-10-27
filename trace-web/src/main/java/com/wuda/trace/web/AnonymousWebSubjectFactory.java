package com.wuda.trace.web;

import com.wuda.trace.log.identity.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成未登录时的{@link AnonymousWebSubject}实例.
 *
 * @author wuda
 */
public class AnonymousWebSubjectFactory extends AbstractWebSubjectFactory {
    @Override
    public Subject createSubject(HttpServletRequest request, HttpServletResponse response) {
        String requestId = getOrCreateRequestId(request);
        String downStreamIp = request.getRemoteAddr();
        return new AnonymousWebSubject(requestId, downStreamIp);
    }
}
