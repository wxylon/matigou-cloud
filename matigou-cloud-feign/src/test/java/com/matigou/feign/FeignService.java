package com.matigou.feign;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients(clients = IFeign.class)
@RestController
@Configuration
@EnableAutoConfiguration
@RibbonClient(name = "ifeign", configuration = RibbonConfig.class)
public class FeignService implements IFeign {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "success";
    }

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    @ResponseBody
    public String goodbye() {
        return "goodbye1";
    }
}
