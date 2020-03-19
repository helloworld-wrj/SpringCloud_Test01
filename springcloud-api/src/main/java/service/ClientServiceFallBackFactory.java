package service;

import feign.hystrix.FallbackFactory;

import org.springframework.stereotype.Component;
import po.User;

@Component
public class ClientServiceFallBackFactory implements FallbackFactory {

    @Override
    public ClientService create(Throwable throwable) {
        return new ClientService() {
            @Override
            public String getUserInfo() {
                return new User("当前服务已经关闭，客户端提供了服务降级", "现在处于服务降级的状态").toString();
            }

            @Override
            public boolean setUserInfo(User user) {
                return false;
            }
        };
    }
}
