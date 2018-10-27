package com.wuda.trace.web;

import com.wuda.trace.log.identity.Subject;

/**
 * 一种{@link Subject},当用户未登录时.
 *
 * @author wuda
 */
public class AnonymousWebSubject implements Subject {

    private String requestId;
    private String downStreamIp;

    /**
     * 构造器.
     *
     * @param requestId
     *         request id
     * @param downStreamIp
     *         ip address from
     */
    public AnonymousWebSubject(String requestId, String downStreamIp) {
        this.requestId = requestId;
        this.downStreamIp = downStreamIp;
    }

    @Override
    public Object getIdentity() {
        return "anon";
    }

    @Override
    public String getDownStreamIp() {
        return downStreamIp;
    }

    @Override
    public String getRequestId() {
        return requestId;
    }
}
