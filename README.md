分布式日志追踪。在微服务之间调用时，通过request header传递
当前request id的方式，将【同一次请求链】串联起来。目前只支持微服务之间用
feign调用的情况，在每次发起feign请求时，都将request id设置
到当前request header中。