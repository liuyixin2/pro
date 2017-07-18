package com.hua.service;

import com.hua.pojo.User;
import com.hua.saf.UserDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public Map queryUser(Map map) {

        return userDao.queryUser(map);
    }
}
