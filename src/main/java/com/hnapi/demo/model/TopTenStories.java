package com.hnapi.demo.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

/**
 * This Bean is responsible to fetch all the result.
 */

//@RedisHash("TopTenStories")
public class TopTenStories implements Serializable {
    private Long id;
    private Long descendants;
    private String by;
    private List<Long> kids;
    private Integer score;
    private Long time;
    private String title;
    private String url;

    public TopTenStories() {}

    public TopTenStories(Long id, Long descendants, String by, List<Long> kids,
                         Integer score, Long time, String title, String url) {
        this.id = id;
        this.descendants = descendants;
        this.by = by;
        this.kids = kids;
        this.score = score;
        this.time = time;
        this.title = title;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDescendants() {
        return descendants;
    }

    public void setDescendants(Long descendants) {
        this.descendants = descendants;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public List<Long> getKids() {
        return kids;
    }

    public void setKids(List<Long> kids) {
        this.kids = kids;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "TopTenStories{" +
                "id=" + id +
                ", descendants=" + descendants +
                ", by='" + by + '\'' +
                ", kids=" + kids +
                ", score=" + score +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
