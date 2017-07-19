package com.hua.service;

import com.hua.pojo.User;
import com.hua.saf.UserDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public Map<String,Object> queryUser(Map<String,Object> map) {
        return userDao.queryUser(map);
    }
    
    public Map<String,Object> queryUsers(Map<String,Object> map) {
        return userDao.queryUsers(map);
    }
}
