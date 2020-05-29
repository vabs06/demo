package com.hnapi.demo.model;

/**
 * This Bean is responsible to get the Top 10 comment for the passed story id.
 * [Text(Comment), HNhandle, HNage(how old profile)]
 */
public class Comments {
    private String text;
    private String hnHandle;
    private String hnAge;

    public Comments() { }

    public Comments(String text, String hnHandle, String  hnAge) {
        this.text = text;
        this.hnHandle = hnHandle;
        this.hnAge = hnAge;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHnHandle() {
        return hnHandle;
    }

    public void setHnHandle(String hnHandle) {
        this.hnHandle = hnHandle;
    }

    public String  getHnAge() {
        return hnAge;
    }

    public void setHnAge(String hnAge) {
        this.hnAge = hnAge;
    }

}
