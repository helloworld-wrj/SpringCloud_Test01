package or.learn.springcloudeureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //表示可以接收服务
public class SpringcloudEureka7001Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka7001Application.class, args);
    }


}
