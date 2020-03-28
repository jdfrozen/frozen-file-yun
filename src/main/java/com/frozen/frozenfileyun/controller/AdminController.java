package com.frozen.frozenfileyun.controller;

import com.frozen.frozenfileyun.model.ResultBean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    /**
     * 获取系统配置
     */
    @RequestMapping("/index")
    public ResultBean getConfig() {
        return ResultBean.success("hello");
    }
}
