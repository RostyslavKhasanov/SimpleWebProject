package com.test.service.impl;

import com.test.repository.UserRepository;
import com.test.entity.UserEntity;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findByAgeAfterNumber(int number) {
        List<UserEntity> users = userRepository.findByAgeAfter(number);
        return users;
    }

    @Override
    public List<String> findUsersByCountOfArticles() {
        List<UserEntity> users = userRepository.findAll();
        List<String> usersName = new ArrayList<>();
        for (UserEntity user: users) {
            if (user.getArticles().size() > 2)
            usersName.add(user.getName());
        }
        return usersName;
    }

    @Override
    public void save(UserEntity userEntity) {
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            System.out.println("Entered wrong data");
        }
    }
}
