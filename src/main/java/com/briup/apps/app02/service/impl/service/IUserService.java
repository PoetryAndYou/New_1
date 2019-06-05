package com.briup.apps.app02.service.impl.service;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;

import java.util.List;

/**
 * @author rui
 * @create 2019-06-04 16:24
 */
public interface IUserService {
    List<User> query(User user);
    List<User> findAll();//查询所有信息

    User findById(Long id);

    List<User> findType(String type);

    void delectUser(long id) throws Exception;

    void insertOrUpdate(User user);
}
