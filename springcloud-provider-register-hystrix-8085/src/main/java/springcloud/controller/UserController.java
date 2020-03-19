package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import po.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
public class UserController {


    @GetMapping("/register/getUserInfo")
    public String getUserInfo(){
        return new User("default 8085","default 8085").toString();
    }

    @PostMapping("/register/setUserInfo")
    public void setUserInfo(@RequestBody User user){//添加注解后，.../register/setUserInfo?username=...&password=..将无法传递
        System.out.println(user);
    }


    @GetMapping("/register/getUserInfoByUsername/{id}")
    @HystrixCommand(fallbackMethod = "handGetUserInfoByUsernameHys")
    public String getUserInfoByUsername(@PathVariable("id") int id){
        Map<Integer,User> users = new HashMap<>();
        users.put(1, new User("user one 8085","123456789"));
        users.put(2, new User("user two 8085","123456789"));
        users.put(3, new User("user three 8085","123456789"));
        users.put(4, new User("user four 8085","123456789"));
        users.put(5, new User("user five 8085","123456789"));
        users.put(6, new User("user six 8085","123456789"));
        User user = users.get(id);
        if (user == null){
            user.setUsername("异常处理，username not exist");
            System.out.println(user.toString());
        }
        return user.toString();

    }

    public String handGetUserInfoByUsernameHys(@PathVariable("id") int id){
        return new User("username is not exist","this is handed by Hystrix").toString();
    }







}
