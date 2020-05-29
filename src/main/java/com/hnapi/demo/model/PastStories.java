package com.hnapi.demo.model;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "PAST_STORIES")
//@RedisHash("paststories")
public class PastStories implements Serializable {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String url;
    @Column
    private Integer score;
    @Column
    private String timeOfSubmission;
    @Column
    private String user;

    public PastStories() {}

    public PastStories(Long id, String title, String url, Integer score, String timeOfSubmission, String user) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.score = score;
        this.timeOfSubmission = timeOfSubmission;
        this.user = user;
    }

    public PastStories(String title, String url, Integer score, String timeOfSubmission, String user) {
        this.title = title;
        this.url = url;
        this.score = score;
        this.timeOfSubmission = timeOfSubmission;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTimeOfSubmission() {
        return timeOfSubmission;
    }

    public void setTimeOfSubmission(String timeOfSubmission) {
        this.timeOfSubmission = timeOfSubmission;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
