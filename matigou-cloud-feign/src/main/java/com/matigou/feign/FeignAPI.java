package com.matigou.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "test")
public interface FeignAPI {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    String hello();
}
