### 一、介绍
spring cloud测试应用，包括，服务提供、注册、消费, 

利用springboot提供的Restful风格，
### 二、环境
- IDEA
- springboot 2.2.4
- java 11



### 三、各个组件
1. api模块
2. 服务提供模块
3. 注册中心
4. 客户端

#### 3.1 创建服务提供
provider模块，8081、8083、8084、（前三个服务功能一样），对比8082

#### 3.2 创建消费者（客户端），实现与服务模块联系

#### 3.3 创建注册中心，eureka
1. 导包 ,eureka(Server)
2. 写配置
3. 添加注解
4. 创建
5. 启动启动类，访问默认页面，http://localhost:port
6. 配置eureka集群，将eureka复制多份（端口不同），修改其配置
```
defaultZone: http://${eureka.instance.hostname}/eureka/   #单注册中心
defaultZone: http://localhost:7002/eureka/,http://localhost:7003/eureka/ #eureka集群
```

#### 3.4 创建服务模块，向注册中心注册
1. 添加api、eureka(starter)依赖
2. 写配置
3. 先启动eureka，再启动服务模块，打开eureka后台监控页面，如果相关信息注册进去即可

#### 3.5 Ribbon， 客户端实现负载均衡
1. 导进Ribbon依赖，（在eureka依赖修改为ribbon依赖即可）
2. 执行采用Ribbon默认策略，修改自带策略，自定义策略

#### 3.6 Feign 面向接口的负载均衡策略
将客户端模块复制一份（为了对比），启动类注解，如果两个模块之间上一级包名不一样，需要写两个
@ComponentScan(basePackages = {"or.learn.springcloudconsumer80","service"})
@EnableFeignClients(basePackages = {"or.learn.springcloudconsumer80","service"})


#### 3.7 Hystrix 服务熔断（服务端），服务降级（客户端）
##### 3.7.1 服务熔断
1. 新建一个与8081一样的模块，8085
2. 添加Hystrix依赖，将eureka（starter）依赖改为hystrix即可
3. 添加fallbackMethod(回调)函数，
4. 在可能发生熔断的请求添加@HystriXCommand()注解，启动类添加注解@EnableCircuitBreaker
5. 测试，启动eureka，8085，再用客户端访问测试

##### 3.7.2 服务降级，利用feign（集成了Hystrix）
1. 在api模块的service添加一个实现了FallBackFactory接口的实现类
2. 改下该方法，将返回对象改为相应接口，并且添加实现
3. 在相应的的Feign接口，fallbackFactory = FallBackFactory接口的实现类
4. 启动测试，启动eureka，服务模块，feign做负载均衡的客户端，访问，一样正常
5. 关闭服务模块，继续访问测试

##### 3.7.3 可视化监控页面，DashBoard，监控客户端请求，故与客户端有关，配置了熔断的请求才可以监控
1. 直接利用maven新建模块，添加依赖，客户端依赖 + hystrix + hystrix dashboard + actuator（服务端也需要配置）
2. 添加配置文件，设置端口
3. 添加启动类，启动访问 url+port + hystrix
4. 在配置了hystrix服务熔断的服务模块-8085的启动类添加bean
```
@Bean
public ServletRegistrationBean hystrixMetricsStreamServlet(){
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
    registrationBean.addUrlMappings("/actuator/hystrix.stream");
    registrationBean.setLoadOnStartup(1);
    return registrationBean;
}
```
5. 启动注册中心，启动可视化模块，启动服务模块8085
6. 打开http://localhost:8085/actuator/hystrix.stream，访问配置了熔断请求的url，可以看到ping信息
7. 将**http://localhost:8085/actuator/hystrix.stream**写入导可视化页面，即可
----2020/03/19


