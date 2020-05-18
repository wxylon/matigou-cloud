package com.matigou.web.controller;


import com.matigou.web.api.IUserService;
import com.matigou.web.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Resource
    IUserService iUserService;

    @RequestMapping({"/", "/index.html"})
    public List<UserVo> index(){
        LOGGER.info("HomeController-index-start");
        List<UserVo> list = iUserService.listUsers();
        return  list;
    }
}
