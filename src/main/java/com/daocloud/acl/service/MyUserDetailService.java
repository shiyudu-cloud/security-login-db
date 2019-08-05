package com.daocloud.acl.service;

import com.daocloud.acl.entity.SysUser;
import com.daocloud.acl.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: dushiyu
 * @Date: 2019-08-01 16:28
 * @Version 1.0
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.getUserByName(s);
        if(null == user){
            throw  new  UsernameNotFoundException("用户名称：【"+s+"】不存在～");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new User(user.getUserName(),user.getPassword(), simpleGrantedAuthorities);
    }
}
