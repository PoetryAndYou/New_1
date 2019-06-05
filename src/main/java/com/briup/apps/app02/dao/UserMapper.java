package com.briup.apps.app02.dao;

import com.briup.apps.app02.bean.User;

import java.util.List;

/**
 * @author rui
 * @create 2019-06-04 16:01
 */
public interface UserMapper {
    List<User> query(User user);

    List<User> findAll();//查询所有信息

    User selectByPrimaryKey(Long id);//根据id查询信息

    List<User> selectByType(String type);//根据类型查询

    void delectUser(long id );

     void insert(User user);
     void update(User user);

}
