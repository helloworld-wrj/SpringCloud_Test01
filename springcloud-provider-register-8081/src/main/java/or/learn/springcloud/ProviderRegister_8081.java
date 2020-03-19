package or.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //该注解可以不加，也可以注册到eureka
//@EnableDiscoveryClient //发现服务
public class ProviderRegister_8081 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderRegister_8081.class,args);
    }



}
