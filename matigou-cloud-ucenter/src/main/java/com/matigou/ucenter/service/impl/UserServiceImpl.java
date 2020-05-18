package com.matigou.ucenter.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.matigou.ucenter.controller.UserController;
import com.matigou.ucenter.service.UserService;
import com.matigou.web.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RefreshScope
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${user.name}")
    String name;

    private static List<UserVo> uvs = new ArrayList<UserVo>();
    static {
        UserVo userVo = new UserVo();
        userVo.setUsername("张三");
        uvs.add(userVo);
    }

    @Override
    public List<UserVo> findUsers() {
        LOGGER.info("UserServiceImpl-findUsers-start");
        UserVo userVo = new UserVo();
        userVo.setUsername(this.name);

        if (!uvs.contains(userVo)) {
            uvs.add(userVo);
        }
        return uvs;
    }
}
