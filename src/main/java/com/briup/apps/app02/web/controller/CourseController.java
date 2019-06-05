package com.briup.apps.app02.web.controller;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.service.impl.ICourseServicelmpl;
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
 * @create 2019-06-05 13:40
 */
@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    private ICourseServicelmpl iCourseServicelmpl;

    @ApiOperation("查询课程表")
    @GetMapping("findALL")
    public List<Course> findALL() {
        return iCourseServicelmpl.findALL();
    }

    @ApiOperation("id课程表")
    @GetMapping("findById")
    Course findById(@ApiParam(value = "id", required = true) @RequestParam(value = "id") Long id) {
        return iCourseServicelmpl.findById(id);
    }

    @ApiOperation("删除")
    @GetMapping("delect")
    public void delect(Long id) throws Exception {
        iCourseServicelmpl.delect(id);
    }

    @ApiOperation("更新插入")
    @GetMapping("insertOrUpdate")
    public String insertOrUpdate(Course course) {
        try {
            if (null == course.getId()) {
                iCourseServicelmpl.insertOrUpdate(course);
                return "插入成功";
            } else {
                iCourseServicelmpl.insertOrUpdate(course);
                return "更新成功";
            }
        } catch (Exception e) {
            return "失败";
        }


    }
}
