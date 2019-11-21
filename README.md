# SpringCould 学习
SpringCloud 我是利用SpringBoot版本2.2.1.RELEASE、SpringCloud版本Hoxton.RC2的开发分布式系统基础的开发，以上库中有eureka、feign、hystrix，springcould 中的config、ribbon、zuul简单上手

SpringCloud主要采用的Eureka，Dubbo主要采用的是zookeeper。

## provider 服务提供者（provider，provider2 测试负载均衡）
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

## consumer 服务消费者
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
## Eureka  服务的注册发现 
      端口号官网默认8761，我这里用的是8766 localhost:8766  
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
  关于Eureka配置的含义及其默认值主要参考下表：

## 服务注册类配置
省略了eureka.client前缀

<table> 参数名	                                       说明	                                                        默认值<table>
<table>enabled	                                     启用Eureka客户端	                                             true
<table>registryFetchIntervalSeconds	               从Eureka服务端获取注册信息的间隔时间，单位为秒	                   30
<table>instanceInfoReplicationIntervalSeconds	     更新实例信息的变化到Eureka服务端的间隔时间，单位为秒	            30
<table>initialInstanceInfoReplicationIntervalSeconds	初始化实例信息到Eureka服务端的间隔时间，单位为秒	                40
<table>eurekaServiceUrlPollIntervalSeconds	         轮询Eureka服务端地址更改的间隔时间，单位为秒。当我们
                                             与Spring CLoud Config整合，动态刷新Eureka的serviceURL
                                             地址时需要关注该参数	                                           300
<table>eurekaServerReadTimeoutSeconds	             读取Eureka Server信息的超时时间，单位为秒	                       8
<table>eurekaServerConnectTimeoutSeconds	           链接Eureka Server的超时时间，单位为秒	                           5
<table>eurekaServerTotalConnections	               从Eureka客户端到所有Eureka服务端的连接总数	                     200
<table>eurekaServerTotalConnectionsPerHost	         从Eureka客户端到每个Eureka服务端主机的连接总数	                  50
<table>eurekaConnectionIdleTimeoutSeconds	         Eureka服务端连接的空闲关闭时间，单位为秒	                        30
<table>heartbeatExecutorThreadPoolSize	             心跳连接池的初始化线程数	                                         2
<table>heartbeatExecutorExponentialBackOffBound	   心跳超时重试延迟时间的最大乘数值	                                 10
<table>cacheRefreshExecutorThreadPoolSize	         缓存刷新线程池的初始化线程数	                                     2
<table>cacheRefreshExecutorExponentialBackOffBound	 缓存刷新重试延迟时间的最大乘数值                                	 10
<table>useDnsForFetchingServiceUrls	               使用DNS来获取Eureka服务端的serviceUrl	                           false
<table>registerWithEureka	                         是否要将自身的实例信息注册到Eureka服务端	                        true
<table>preferSameZoneEureka	                       是否偏好使用处于相同Zone的Eureka服务端	                           true
<table>filterOnlyUpInstances	                       获取实例时是否过滤，仅保留UP状态的实例	                            true
<table>fetchRegistry	                               是否从Eureka服务端获取注册信息	                                   true

## 服务实例类eureka.instance配置

<table>参数名                                      	说明                                                          	默认值
<table>preferIpAddress	                            是否优先使用IP地址作为主机名的标识	                              false
<table>leaseRenewalIntervalInSeconds	              Eureka客户端向服务端发送心跳的时间间隔，单位为秒	                  30
<table>leaseExpirationDurationInSeconds	          Eureka服务端在收到最后一次心跳之后等待的时间上限，
                                            单位为秒。超过该时间之后服务端会将该服务实例从服务清单中剔除，
                                            从而禁止服务调用请求被发送到该实例上	                             90
<table>nonSecurePort	                              非安全的通信端口号	                                               80
<table>securePort	                                安全的通信端口号	                                                443
<table>nonSecurePortEnabled	                      是否启用非安全的通信端口号	                                       true
<table>securePortEnabled	                          是否启用安全的通信端口号	
<table>appname	                                    服务名，默认取spring.application.name的配置值，如果没有则为unknown	
<table>hostname	                                  主机名，不配置的时候讲根据操作系统的主机名来获取	

## zuul 服务监控
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-actuator</artifactId>
        </dependency>
## ribbon

ribbon是一个用来做负载均衡的组件。
spring-cloud-starter-netflix-eureka-client依赖已经添加了spring-cloud-starter-netflix-ribbon，故在项目中可以直接使用ribbon，不用重新添加依赖。

## config  配置中心
它支持配置文件放在在配置服务的内存中，也支持放在远程Git仓库里。引入spring cloud config后，我们的外部配置文件就可以集中放置在一个git仓库里，config server，用来管理所有的配置文件，维护的时候需要更改配置时，只需要在本地更改后，推送到远程仓库，所有的服务实例都可以通过config server来获取配置文件，这时每个服务实例就相当于配置服务的客户端config client
     
     服务端
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
      客户端
      <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
       </dependency>
