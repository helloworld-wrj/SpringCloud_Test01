package or.learn.springcloudconsumer80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import po.User;
import service.ClientService;

import javax.annotation.Resource;

@RestController
public class ConsumerController {


    @Resource
    private ClientService clientService;

    @RequestMapping("/consumer/getUserInfo")
    public String getUserInfo(){
        return this.clientService.getUserInfo();
    }


    @RequestMapping("/consumer/setUserInfo")
    public Boolean setUserInfo(User user){
        return clientService.setUserInfo(user);
    }

    @RequestMapping("/consumer/test")
    public String test(){
        return "test successfully";
    }



}
