package com.example.bt_nhu_anh.services;

import com.example.bt_nhu_anh.models.Blog;
import com.example.bt_nhu_anh.models.User;
import com.example.bt_nhu_anh.repositories.IUserRepository;
import com.example.bt_nhu_anh.services.baseInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User t) {
        return userRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void addBlogToUser(Long userId, Blog blog) {
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isPresent()) {
            User user = findUser.get();
            user.getBlogs().add(blog);
            userRepository.save(user);
        }
    }
}
