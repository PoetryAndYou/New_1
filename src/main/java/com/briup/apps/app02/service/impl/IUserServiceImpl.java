package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.impl.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rui
 * @create 2019-06-04 16:06
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Resource//自动注入
    private UserMapper userMapper;


    @Override
    public List<User> query(User user) {

        return userMapper.query(user);

    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findType(String type) {
        return userMapper.selectByType(type);
    }

    @Override
    public void delectUser(long id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new Exception("空指针");
        } else {
            userMapper.delectUser(id);
        }

    }

    public void insertOrUpdate(User user) {
        if (user.getId() == null) {
            userMapper.insert(user);
            user.setStatus("正常");
        } else {
            userMapper.update(user);
        }


    }
}
