package com.test.service;

import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;
import com.test.enums.ColorEnum;

import java.util.List;

public interface ArticleService {

    List<UserEntity> findByColor(ColorEnum color);

    void save(ArticleEntity articleEntity);
}
