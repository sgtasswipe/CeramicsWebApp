package com.example.ceramicwebpage.controllers;

import com.example.ceramicwebpage.model.BlogPost;
import com.example.ceramicwebpage.model.Course;
import com.example.ceramicwebpage.service.BlogPostService;
import com.example.ceramicwebpage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/login")
    public String loginPage() {
        return "admin/admin_login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/admin_dash";
    }

    @GetMapping("/create-blog-post")
    public String createBlogPostForm(Model model) {
        model.addAttribute("blogPost", new BlogPost());
        return "admin/create-blog-post";
    }

    @PostMapping("/create-blog-post")
    public String createBlogPost(@ModelAttribute BlogPost blogPost) {
        blogPostService.saveBlogPost(blogPost);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/create-course")
    public String createCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "admin/create-course";
    }

    @PostMapping("/create-course")
    public String createCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/admin/dashboard";
    }
}