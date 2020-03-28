package com.frozen.frozenfileyun.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: frozen
 * @Date: 2020/3/28 20:37
 * @Description:
 */
@Service
public class LocalServiceImpl {
    @Value("${fileyun.basepath}")
    protected String basepath;

    public String getBasepath() {
        return basepath;
    }
}
