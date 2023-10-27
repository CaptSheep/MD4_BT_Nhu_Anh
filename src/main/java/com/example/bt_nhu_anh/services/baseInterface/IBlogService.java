package com.example.bt_nhu_anh.services.baseInterface;



import com.example.bt_nhu_anh.models.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog t);

    void remove(Long id);
    Blog update(Long id ,Blog blog);
}
