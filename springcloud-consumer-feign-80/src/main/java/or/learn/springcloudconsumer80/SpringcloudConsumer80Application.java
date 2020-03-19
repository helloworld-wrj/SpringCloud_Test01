package or.learn.springcloudconsumer80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"or.learn.springcloudconsumer80","service"})
@EnableFeignClients(basePackages = {"or.learn.springcloudconsumer80","service"})
public class SpringcloudConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumer80Application.class, args);
    }

}
