package com.example.ceramicwebpage.service;

import com.example.ceramicwebpage.model.BlogPost;
import com.example.ceramicwebpage.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();

    }

public void saveBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);

    }
}