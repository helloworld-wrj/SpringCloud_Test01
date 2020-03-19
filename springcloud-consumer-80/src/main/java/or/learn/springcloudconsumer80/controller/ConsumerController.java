package or.learn.springcloudconsumer80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import po.User;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8081";

    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-REGISTER";


    @RequestMapping("/consumer/getUserInfo")
    public String getUserInfo(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/register/getUserInfo",String.class);
    }


    @RequestMapping("/consumer/setUserInfo")
    public Boolean setUserInfo(User user){
        System.out.println(user);

        Boolean b = restTemplate.postForObject(REST_URL_PREFIX+"/register/setUserInfo",user,Boolean.class);
        System.out.println(b);
        return b;
    }

    @RequestMapping("/consumer/getUserInfoByUsername/{id}")
    public String getUserInfoByUsername(@PathVariable("id") int id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/register/getUserInfoByUsername/" + id,String.class);
    }



}
