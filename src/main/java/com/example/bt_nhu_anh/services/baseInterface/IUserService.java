package com.example.bt_nhu_anh.services.baseInterface;

import com.example.bt_nhu_anh.models.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    User save(User t);

    void remove(Long id);
    User update(Long id ,User user);
}
