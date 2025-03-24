package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    // Create a new blog
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    // Fetch all blogs with pagination
    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    // Fetch a single blog by ID
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    // Update an existing blog
    public Optional<Blog> updateBlog(Long id, Blog blogDetails) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(blogDetails.getTitle());
            blog.setContent(blogDetails.getContent());
            blog.setAuthor(blogDetails.getAuthor());
            return blogRepository.save(blog);
        });
    }

    // Delete a blog by ID
    public boolean deleteBlog(Long id) {
        return blogRepository.findById(id).map(blog -> {
            blogRepository.delete(blog);
            return true;
        }).orElse(false);
    }
}
