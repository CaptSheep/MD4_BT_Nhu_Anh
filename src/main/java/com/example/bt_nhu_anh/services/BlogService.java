package com.example.bt_nhu_anh.services;

import com.example.bt_nhu_anh.models.Blog;
import com.example.bt_nhu_anh.repositories.IBlogRepository;
import com.example.bt_nhu_anh.services.baseInterface.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;


    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Blog save(Blog t) {
      return blogRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);

    }

    @Override
    public Blog update(Long id, Blog blog) {
        if(blogRepository.existsById(id)){
            blog.setTime(new Date());
            blog.setId(id);
            return blogRepository.save(blog);
        }
        return null;
    }
}
