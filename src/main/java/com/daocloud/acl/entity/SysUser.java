package com.daocloud.acl.entity;

import lombok.Data;

/**
 * @Author: dushiyu
 * @Date: 2019-08-01 16:34
 * @Version 1.0
 */
@Data
public class SysUser {

    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    private String roles;


}
