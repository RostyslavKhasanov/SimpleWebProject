package com.test.service;

import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;
import com.test.enums.ColorEnum;
import com.test.repository.ArticleRepository;
import com.test.service.impl.ArticleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Mock
    private ArticleRepository articleRepository;

    @Test
    public void testFindByColor() {

        UserEntity user1 = new UserEntity();
        user1.setName("Test user 1 with green");

        UserEntity user2 = new UserEntity();
        user1.setName("Test user 2 with green");

        List<UserEntity> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user2);

        ArticleEntity article1 = new ArticleEntity();
        article1.setUser(user1);
        article1.setColor(ColorEnum.GREEN);

        ArticleEntity article2 = new ArticleEntity();
        article2.setUser(user2);
        article2.setColor(ColorEnum.GREEN);

        List<ArticleEntity> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

        when(articleRepository.findByColor(ColorEnum.GREEN)).thenReturn(articles);

        List<UserEntity> users = articleService.findByColor(ColorEnum.GREEN);

        Assert.assertEquals(expected, users);
    }
}
