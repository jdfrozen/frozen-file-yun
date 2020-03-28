package com.frozen.frozenfileyun.model.rsp;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Auther: frozen
 * @Date: 2020/3/28 12:27
 * @Description:
 */
@Data
@ToString
public class UserRsp {
    private Long id;
    private String name;
    private String url;
}
