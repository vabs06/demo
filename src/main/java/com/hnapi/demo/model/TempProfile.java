package com.hnapi.demo.model;

import java.util.List;

public class TempProfile {
    private String by;
    private Long id;
    private List<Long> kids;
    private Integer parent;
    private String text;
    private Long time;
    private String type;

    public TempProfile() { }

    public TempProfile(String by, Long id, List<Long> kids, Integer parent, String text, Long time, String type) {
        this.by = by;
        this.id = id;
        this.kids = kids;
        this.parent = parent;
        this.text = text;
        this.time = time;
        this.type = type;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getKids() {
        return kids;
    }

    public void setKids(List<Long> kids) {
        this.kids = kids;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

