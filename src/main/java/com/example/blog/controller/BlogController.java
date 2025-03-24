package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/{id}/summary")
    public ResponseEntity<String> summarizeBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isPresent()) {
            String summary = openAIService.summarizeText(blog.get().getContent());
            return ResponseEntity.ok(summary);
        }
        return ResponseEntity.notFound().build();
    }
}
