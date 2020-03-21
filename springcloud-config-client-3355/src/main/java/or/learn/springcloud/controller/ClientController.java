package or.learn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaInfo;

    @GetMapping("/getYumConfigInfo")
    public String getYumConfigInfo(){
        return "applicationName: " + applicationName + " =========== " +
                "serverPort: " + serverPort + " =========== " +
                "eurekaInfo: " + eurekaInfo;

    }
}
