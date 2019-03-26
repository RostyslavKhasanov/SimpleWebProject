package com.test.repository;

import com.test.entity.ArticleEntity;
import com.test.enums.ColorEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findByColor(ColorEnum color);

}
