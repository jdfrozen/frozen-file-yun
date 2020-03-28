package com.frozen.frozenfileyun.controller;

import com.frozen.frozenfileyun.model.ResultBean;
import com.frozen.frozenfileyun.model.rsp.UserRsp;
import com.frozen.frozenfileyun.dto.User;
import com.frozen.frozenfileyun.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/save")
    public ResultBean save() throws Exception {
        userServiceImpl.save();
        return ResultBean.success();
    }

    @RequestMapping("/getOne")
    public ResultBean getOne() throws Exception{
        User user = userServiceImpl.getOne();
        UserRsp userRsp = new UserRsp();
        BeanUtils.copyProperties(user,userRsp);
        return ResultBean.success(userRsp);
    }
}
