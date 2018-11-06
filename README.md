分布式日志追踪。在微服务之间调用时，通过request header传递
当前request id的方式，将【同一次请求链】串联起来。目前只支持微服务之间用
feign调用的情况，在每次发起feign请求时，都将request id设置
到当前request header中。

# 使用步骤

- 引入依赖
- 实现WebSubjectFactory，根据request/response pair生成Subject，比如

```
public class AnonymousWebSubjectFactory extends AbstractWebSubjectFactory {
    @Override
    public Subject createSubject(HttpServletRequest request, HttpServletResponse response) {
        String requestId = getOrCreateRequestId(request);
        String downStreamIp = request.getRemoteAddr();
        return new AnonymousWebSubject(requestId, downStreamIp);
    }
}
```
- 注册WebSubjectFactory，比如

```
@Bean
public WebSubjectFactory getWebSubjectFactory() {
    return new AnonymousWebSubjectFactory();
}
```

# 核心概念
- Subject

```
一个Subject实例，最直观的就是一个"User"。Subject代表了两个服务之间交互时，请求中所携带的用户，requestId等信息。
```
- request id

```
1, 属于同一个动作的多个请求共享同一个request id。
比如，用户在页面点击【查看】功能，而这个功能在后台实际发起了５次请求，则这５次请求的request id一样

2,  使用http header传递reqest id，header name=Trace-Request-Id
```
