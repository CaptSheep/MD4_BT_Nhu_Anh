package com.example.bt_nhu_anh.controllers;

import com.example.bt_nhu_anh.models.Blog;
import com.example.bt_nhu_anh.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(("*"))
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("")
    public Iterable<Blog> showAllBlog(){
        return blogService.findAll();
    }
    @PostMapping("/create")
    public Blog addBlog( @RequestBody Blog blog){
        return blogService.save(blog);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBlog(@PathVariable Long id){
        blogService.remove(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        Blog updateBlog = blogService.update(id,blog);
        if(updateBlog != null)
        return new ResponseEntity<Blog>(updateBlog, HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
