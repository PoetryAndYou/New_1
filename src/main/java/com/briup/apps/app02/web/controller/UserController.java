package com.briup.apps.app02.web.controller;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.impl.service.IUserService;
import com.briup.apps.app02.utils.Message;
import com.briup.apps.app02.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rui
 * @create 2019-06-04 16:07
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    MessageUtil messageUtil;

    @GetMapping("/findAll")
    public Message findAll() {
        List<User> list = userService.findAll();
        return MessageUtil.message("success", list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "", required = true) @RequestParam(value = "id") Long id) {
        User use = userService.findById(id);
        return MessageUtil.message("success", use);
    }

    @ApiOperation("通过type查询")
    @GetMapping("findType")
    public Message findType(@ApiParam(value = "type", required = true) @RequestParam(value = "type") String type) {
        List<User> list = userService.findType(type);
        return MessageUtil.message("success", list);
    }

    @ApiOperation("删除")
    @GetMapping("delect")
    public Message delectUser(@ApiParam(value = "id") @RequestParam(value = "id") long id) throws Exception {
        userService.delectUser(id);
        return MessageUtil.message("sucess");
    }

    @ApiOperation("插入更新")
    @GetMapping("insertOrUpdate")
    public Message insertOrUpdate(User user) {
        try {
            if (user.getId() == null) {
                userService.insertOrUpdate(user);
                return MessageUtil.message("sucess");
            } else {
                userService.insertOrUpdate(user);
                return MessageUtil.message("sucess");
            }
        } catch (Exception e) {
            return MessageUtil.error("error");
        }


    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(User user) {
        List<User> list = userService.query(user);
        return MessageUtil.message("success", list);
    }

}
