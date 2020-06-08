package com.matigou.ucenter.controller;

import com.matigou.ucenter.domain.MtgUser;
import com.matigou.ucenter.service.MtgUserService;
import com.matigou.ucenter.service.UserService;
import com.matigou.web.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "ucenter")
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    MtgUserService mtgUserService;

    @ApiOperation("用户列表")
    @GetMapping("/listUsers")
    public List<UserVo> listUsers(){
        LOGGER.info("UserController-listUsers-start");

        List<MtgUser> mtgUsers =  mtgUserService.queryAllByLimit(0, 10);

        LOGGER.info(mtgUsers.toString());

        return userService.findUsers();
    }

    @ApiOperation("新增用户")
    @PostMapping("/insert")
    public void inserUsers(@ApiParam MtgUser mtgUser){
        LOGGER.info("UserController-inserUsers-start");
        mtgUserService.insert(mtgUser);
    }
}
