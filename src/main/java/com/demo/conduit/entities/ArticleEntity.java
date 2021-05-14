package com.demo.conduit.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity(name = "articles")
@Getter
@Setter
public class ArticleEntity extends BaseEntity {
    private String slug;
    private String description;
    private String body;
    private String title;
    private UserEntity author;

    @ManyToOne(fetch = FetchType.EAGER)
    public UserEntity getAuthor() {
        return author;
    }
}