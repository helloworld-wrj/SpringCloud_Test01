package or.learn.springcloudproviderquery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import po.User;

@RestController
public class QueryController {

    @GetMapping("/queryGetUserInfo")
    public String queryGetUserInfo(){
        return new User("getQuery","getQuery").toString();
    }

    @PostMapping("/queryGetUserInfo")
    public String querySetUserInfo(User user){
        return user.toString();
    }
}
