package com.hua.service;

import com.hua.pojo.User;

import java.util.Map;

/**
 * Created by Administrator on 2017-07-18.
 */
public interface IUserService {
    User getUser(int id);

    Map<String,Object> queryUser(Map<String,Object> map);
    
    Map<String,Object> queryUsers(Map<String,Object> map);
}
