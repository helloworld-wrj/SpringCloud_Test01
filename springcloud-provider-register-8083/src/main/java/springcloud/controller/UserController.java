package springcloud.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import po.User;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {


    //获取配置信息，得到具体微服务
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/register/getUserInfo")
    public String getUserInfo(){
        return new User("default3","default3").toString();
    }

    @PostMapping("/register/setUserInfo")
    public void setUserInfo(@RequestBody User user){//添加注解后，.../register/setUserInfo?username=...&password=..将无法传递
        System.out.println(user);
    }


    @GetMapping("/register/setTest")
    public void setTest(User user){
        System.out.println(user);
        discovery();
    }


    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("services: " + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-provider-register");
        for (ServiceInstance instance :
                instances) {
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getUri());
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getScheme());
        }

        return services;
    }

}
