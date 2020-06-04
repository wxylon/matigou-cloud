package com.matigou.ucenter.controller;

import com.matigou.ucenter.domain.MtgUser;
import com.matigou.ucenter.service.MtgUserService;
import com.matigou.ucenter.service.UserService;
import com.matigou.web.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    MtgUserService mtgUserService;

    @RequestMapping("/listUsers")
    public List<UserVo> listUsers(){
        LOGGER.info("UserController-listUsers-start");

        List<MtgUser> mtgUsers =  mtgUserService.queryAllByLimit(0, 10);

        LOGGER.info(mtgUsers.toString());

        return userService.findUsers();
    }

    @RequestMapping("/insert")
    public void inserUsers(MtgUser mtgUser){
        LOGGER.info("UserController-inserUsers-start");
        mtgUserService.insert(mtgUser);
    }
}
