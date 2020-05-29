package com.hnapi.demo.model;

/**
 * This class is use for Comparing the Top 10 comment on the basis of child comment(s).
 */
public class CommonCommentsClass extends Comments {
    private int kidsCount;

    public CommonCommentsClass() { }

    public CommonCommentsClass(String text, String hnHandle, String hnAge) {
        super(text, hnHandle, hnAge);
    }

    public CommonCommentsClass(String text, String hnHandle, String hnAge, int kidsCount) {
        this(text, hnHandle, hnAge);
        this.kidsCount = kidsCount;
    }

    public int getKidsCount() {
        return kidsCount;
    }

    public void setKidsCount(int kidsCount) {
        this.kidsCount = kidsCount;
    }
}
