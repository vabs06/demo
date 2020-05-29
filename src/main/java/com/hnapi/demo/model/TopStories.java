package com.hnapi.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * This Bean will be cache for the upcoming 10 minutes for every user.
 * After 10 minutes it will flush from the cache.
 *  [Title, Url, Score, Time of submission, User who submitted]
 */


@RedisHash("topstories")
public class TopStories implements Serializable {
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

    public TopStories() {}

    public TopStories(String title, String url, Integer score, String timeOfSubmission, String user) {
        this.title = title;
        this.url = url;
        this.score = score;
        this.timeOfSubmission = timeOfSubmission;
        this.user = user;
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

    @Override
    public String toString() {
        return "TopStories{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", score=" + score +
                ", timeOfSubmission=" + timeOfSubmission +
                ", user='" + user + '\'' +
                '}';
    }
}

