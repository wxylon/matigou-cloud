package com.matigou.web.api;


import com.matigou.web.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "matigou-cloud-ucenter")
public interface IUserService {

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public List<UserVo> listUsers();
}
