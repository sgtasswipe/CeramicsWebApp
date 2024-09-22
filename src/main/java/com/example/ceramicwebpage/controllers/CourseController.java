package com.example.ceramicwebpage.controllers;

import com.example.ceramicwebpage.model.Course;
import com.example.ceramicwebpage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String courses(Model model) {
        List<Course> courses = courseService.getAllCourses() ;
        model.addAttribute("courses", courses);
    return "courses";}
}