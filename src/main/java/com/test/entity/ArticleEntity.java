package com.test.entity;

import com.test.enums.ColorEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "articles")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column
    private ColorEnum color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
