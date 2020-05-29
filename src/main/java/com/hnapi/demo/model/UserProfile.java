package com.hnapi.demo.model;

import java.util.List;

/**
 * This bean is responsible to get all the informatioin about User.
 * Using this bean can calculate the age.
 */

public class UserProfile {
    private String id;
    private Long created;
    private Long karma;
    private List<Long> submitted;
    private String about;
    private Integer delay;

    public UserProfile() { }

    public UserProfile(String id, Long created, Long karma, List<Long> submitted, String about, Integer delay) {
        this.id = id;
        this.created = created;
        this.karma = karma;
        this.submitted = submitted;
        this.about = about;
        this.delay = delay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getKarma() {
        return karma;
    }

    public void setKarma(Long karma) {
        this.karma = karma;
    }

    public List<Long> getSubmitted() {
        return submitted;
    }

    public void setSubmitted(List<Long> submitted) {
        this.submitted = submitted;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}
