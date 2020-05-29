package com.hnapi.demo.utils;

import com.hnapi.demo.model.Comments;
import com.hnapi.demo.model.CommonCommentsClass;

import java.util.Comparator;

public class SortByComment implements Comparator<CommonCommentsClass> {


    @Override
    public int compare(CommonCommentsClass o1, CommonCommentsClass o2) {
          return o2.getKidsCount() - o1.getKidsCount();
    }
}
