package com.matigou.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "ifeign")
public interface IFeign {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    String hello();

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    @ResponseBody
    default String goodbye(){
        return "goodbye";
    }
}
