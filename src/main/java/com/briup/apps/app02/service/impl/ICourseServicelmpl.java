package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.dao.CourseMapper;
import com.briup.apps.app02.service.impl.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rui
 * @create 2019-06-05 13:39
 */
@Service
public class ICourseServicelmpl implements ICourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> findALL() {
        return courseMapper.findALL();
    }

    @Override
    public Course findById(Long id) {
        return courseMapper.findById(id);
    }

    @Override
    public void delect(Long id) throws Exception {
        if (null == courseMapper.findById(id)) {
            throw new Exception("空指针异常");
        } else {
            courseMapper.delect(id);
        }
    }

    @Override
    public void insertOrUpdate(Course course) {
        if (null == course.getId()) {
            courseMapper.insert(course);
        } else {
            courseMapper.update(course);
        }
    }
}
