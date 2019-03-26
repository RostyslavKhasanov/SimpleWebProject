package com.test;

import com.test.repository.ArticleRepository;
import com.test.repository.UserRepository;
import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;
import com.test.enums.ColorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@SpringBootApplication
public class TestApplication implements WebMvcConfigurer, CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            for (int i = 1; i < 11; i++) {
                UserEntity user = new UserEntity();
                user.setName("User" + i);
                user.setAge(16 + i);
                userRepository.save(user);
            }
        }

        List<ColorEnum> colors = new ArrayList<>();

        for (ColorEnum color : ColorEnum.values()) {
            colors.add(color);
        };

        long countUser = userRepository.count();

        if (articleRepository.count() == 0) {
            for (int i = 0; i < 15; i++) {
                ArticleEntity article = new ArticleEntity();
                int random_color = (int) (Math.random() * colors.size());
                article.setColor(colors.get(random_color));
                Long random_user = 1 + (long) (Math.random() * countUser);
                article.setUser(userRepository.getOne(random_user));
                article.setText("Some text here....." + i);
                articleRepository.save(article);
            }
        }

    }
}

