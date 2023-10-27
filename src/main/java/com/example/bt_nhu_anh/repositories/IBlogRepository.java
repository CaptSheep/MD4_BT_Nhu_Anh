package com.example.bt_nhu_anh.repositories;

import com.example.bt_nhu_anh.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
}
