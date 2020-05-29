package com.hnapi.demo.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * This class is use as Helper class to calculate the Age(Story, Profile).
 */

public class Utility {

    public static String getStoryAge(long storyTime) {
        Date storyDate  = new Date(storyTime * 1000);
        Date now = new Date();
        long dateDiff = (long) (now.getTime() - storyDate.getTime());

        int diffDays = (int) (dateDiff / (24 * 60 * 60 * 1000));
        int diffHours = (int) (dateDiff / (60 * 60 * 1000));
        int diffMin = (int) (dateDiff / (60 * 1000));

        String resultedTime = "";
        if(diffDays == 0) {
            if(diffHours == 0)
                resultedTime = diffMin + ((diffMin > 1) ? " minutes": " minute");
            else
                resultedTime = diffHours + ((diffHours > 1) ? " hours": " hour");
        } else
            resultedTime = diffDays + ((diffDays > 1) ? " days": " day");

        return resultedTime;
    }

    public static String getProfileAge(long createdTime) {

        Calendar profileTime = Calendar.getInstance();
        Calendar currentTime = Calendar.getInstance();

        createdTime = createdTime * 1000L;
        profileTime.setTimeInMillis(createdTime);

        long today = new Date().getTime();
        currentTime.setTimeInMillis(today);

        String profileAge = String.valueOf(currentTime.get(Calendar.YEAR) - profileTime.get(Calendar.YEAR));
//        System.out.println(profileAge);
        return (( profileAge.length() != 1 && profileAge.charAt(0) == '1') ? profileAge + " year" :  profileAge + " years");
    }
}