package com.daocloud.acl.mapper;

import com.daocloud.acl.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author: dushiyu
 * @Date: 2019-08-01 16:34
 * @Version 1.0
 */
@Repository
public interface SysUserMapper {
    /**
     * 根据用户名称查询用户信息
     * @param userName
     * @return
     */
    @Select("select * from sys_user where username = #{userName}")
    @Results({
            @Result(property = "userName",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "nickName",column = "nickname"),
            @Result(property = "roles",column = "roles")
    })
    SysUser getUserByName(String userName);

    /**
     * 新增用户
     * @param user
     */
    @Insert("insert into sys_user(username,password,nickname,roles) values (#{user.userName},#{user.password},#{user.nickName},#{user.roles})")
    void insert(@Param("user") SysUser user);

}
