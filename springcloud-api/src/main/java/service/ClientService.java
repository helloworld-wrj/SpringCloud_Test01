package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import po.User;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-REGISTER", fallbackFactory = ClientServiceFallBackFactory.class)
public interface ClientService {


    //可以传递参数
    @GetMapping("/register/getUserInfo")
    String getUserInfo();

    @PostMapping("/register/setUserInfo")
    boolean setUserInfo(User user);
}
