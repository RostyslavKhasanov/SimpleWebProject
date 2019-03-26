package com.test.controller;

import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;
import com.test.enums.ColorEnum;
import com.test.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("user/color")
    public ResponseEntity<?> getUserByColor(@RequestParam ColorEnum color) {
        List<UserEntity> users = articleService.findByColor(color);
        return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ArticleEntity article) {
        articleService.save(article);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
