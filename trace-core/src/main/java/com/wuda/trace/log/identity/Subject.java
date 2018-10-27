package com.wuda.trace.log.identity;

/**
 * 类似于<a href="http://shiro.apache.org">Apache Shiro</a>中对Subject的定义.
 * 一个Subject实例，最直观的就是一个"User".
 * Subject代表了两个服务之间交互时,一次请求中所携带的信息.
 * 比如,在web环境中,浏览器和后端服务交互时,每次请求浏览器都会携带用户信息,cookie等等.
 */
public interface Subject {

    /**
     * 唯一标记.可以是用户名,用户ID,nickname,只要能唯一区分即可.
     *
     * @return identity
     */
    Object getIdentity();

    /**
     * ip address from.
     *
     * @return ip
     */
    String getDownStreamIp();

    /**
     * 一次完整的请求的Id.什么是<strong>一次完整请求</strong>?
     * 比如:用户在浏览器上点击了"查看"功能,后端服务可能只调用一次就给用户返回了内容,
     * 但是也有可能调用了多个微服务的内容才得到完整的信息,这样对于后端来说,就不止一次请求了,
     * 但是对于"查看"功能来说,这是一次请求.
     *
     * @return request id
     */
    String getRequestId();

}
