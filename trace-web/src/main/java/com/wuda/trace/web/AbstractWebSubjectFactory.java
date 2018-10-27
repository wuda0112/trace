package com.wuda.trace.web;

import com.wuda.trace.log.identity.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 使用http header传递request id.
 */
public abstract class AbstractWebSubjectFactory implements WebSubjectFactory {

    /**
     * 　如果http header中存在request id,则获取并返回;如果不存在则生成并返回.
     *
     * @param request
     *         request
     * @return request id
     */
    protected String getOrCreateRequestId(HttpServletRequest request) {
        String requestId = request.getHeader(Constant.HEADER_REQUEST_ID);
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }
        return requestId;
    }

    public abstract Subject createSubject(HttpServletRequest request, HttpServletResponse response);
}
