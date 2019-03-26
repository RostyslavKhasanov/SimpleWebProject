package com.test.service;

import com.test.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findByAgeAfterNumber(int number);

    List<String> findUsersByCountOfArticles();

    void save(UserEntity userEntity);
}
