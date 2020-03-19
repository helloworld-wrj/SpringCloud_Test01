package or.learn.springcloudconsumer80;

import or.learn.rule.MyRule;
import or.learn.springcloudconsumer80.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//在微服务启动就加载自定义的Ribbon策略
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-REGISTER",configuration = ConfigBean.class)
public class SpringcloudConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumer80Application.class, args);
    }

}
