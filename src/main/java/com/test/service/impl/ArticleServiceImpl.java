package com.test.service.impl;

import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;
import com.test.enums.ColorEnum;
import com.test.repository.ArticleRepository;
import com.test.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<UserEntity> findByColor(ColorEnum color) {

        List<ArticleEntity> articles = articleRepository.findByColor(color);
        List<UserEntity> users = new ArrayList<>();
        for (ArticleEntity article: articles) {
            users.add(article.getUser());
        }
        return users;
    }

    @Override
    public void save(ArticleEntity articleEntity) {
        try{
            articleRepository.save(articleEntity);
        } catch (Exception e) {
            System.out.println("Entered wrong data");
        }
    }
}
