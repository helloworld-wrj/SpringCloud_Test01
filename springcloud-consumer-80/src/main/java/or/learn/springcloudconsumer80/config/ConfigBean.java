package or.learn.springcloudconsumer80.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import or.learn.rule.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-REGISTER",configuration = RuleConfig.class)
public class ConfigBean { //相当于 spring applicationContent.xml

    //用于RestFul风格
    @Bean
    @LoadBalanced //Ribbon，用来配置负载均衡，若无配置，默认是轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

/*    @Bean
    public IRule testRule(){
        return new RandomRule();//Ribbon 已经实现的策略；
    }*/


    @Bean
    public MyRule testRule(){
        return new MyRule();
    }



}
