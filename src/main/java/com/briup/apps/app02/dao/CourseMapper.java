package com.briup.apps.app02.dao;

import com.briup.apps.app02.bean.Course;

import java.util.List;

/**
 * @author rui
 * @create 2019-06-05 13:19
 */
public interface CourseMapper {
    List<Course> findALL();//查询所有
    Course findById(Long id);//查询
    void delect(Long id);
    void insert(Course course);
    void update(Course course);
}
