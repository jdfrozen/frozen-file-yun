package com.frozen.frozenfileyun.service;

import com.frozen.frozenfileyun.dao.UserRepository;
import com.frozen.frozenfileyun.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
@Slf4j
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/save")
    public void save() throws Exception {
        User user = new User();
        user.setName("frozen");
        user.setUrl("http://jdfrozen.cn");
        User result = userRepository.save(user);
        log.info(result.toString());
    }
    @RequestMapping("/index")
    public User getOne() throws Exception{
        User user = userRepository.getOne(2l);
        log.info(user.toString());
        return user;
    }
}
