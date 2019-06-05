package com.briup.apps.app02.service.impl.service;

import com.briup.apps.app02.bean.Course;

import java.util.List;

/**
 * @author rui
 * @create 2019-06-05 13:39
 */
public interface ICourseService {
    List<Course> findALL();
    Course findById(Long id);
    void delect(Long id) throws Exception;
    void insertOrUpdate(Course course);
}
