package or.learn.springcloudconsumer80.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ConfigBean { //相当于 spring applicationContent.xml

    //用于RestFul风格
    @Bean
    @LoadBalanced //Ribbon，用来配置负载均衡，若无配置，默认是轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
