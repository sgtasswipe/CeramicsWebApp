package com.example.ceramicwebpage.controllers;

import com.example.ceramicwebpage.model.BlogPost;
import com.example.ceramicwebpage.model.Course;
import com.example.ceramicwebpage.model.Product;
import com.example.ceramicwebpage.service.BlogPostService;
import com.example.ceramicwebpage.service.CourseService;
import com.example.ceramicwebpage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> featuredProducts = productService.getAllProducts().subList(0, 3); // Get first 3 products
        model.addAttribute("featuredProducts", featuredProducts);
        return "home";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }


    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "portfolio";
    }
}
