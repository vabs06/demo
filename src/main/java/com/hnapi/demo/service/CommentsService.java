package com.hnapi.demo.service;

import com.hnapi.demo.model.*;
import com.hnapi.demo.utils.SortByComment;
import com.hnapi.demo.utils.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentsService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String hashName = "TopTenStories";

    @Value("${baseUrl.item}")
    private String baseUrlForItem;

    @Value("${baseUrl.user}")
    private String baseUrlForUser;

    @Value("${suffix}")
    private String suffix;

    @Autowired
    private RestTemplate restTemplate;


    public List<Comments> getComments(String id) {

        List<CommonCommentsClass> commonCommentsList = new ArrayList<>();

        String storyUri = baseUrlForItem + id + suffix;

        TopTenStories topTenStories = restTemplate.getForObject(storyUri, TopTenStories.class);


        List<Long> kids = topTenStories.getKids()
                .stream()
                .limit(10)
                .collect(Collectors.toList());

        Comments comments;
        CommonCommentsClass commonCommentsClass;


        for(Long kidId: kids) {
            String userUri = baseUrlForItem +  kidId + suffix;

            TempProfile tempProfile = restTemplate.getForObject(userUri, TempProfile.class);

            String hnHandle = Objects.requireNonNull(tempProfile).getBy();

            String hnAge = getHNAge(hnHandle);

            int commentKidCount = 0;

            if(tempProfile.getKids() != null && tempProfile.getKids().size() != 0) {
                commentKidCount = tempProfile.getKids().size();
            }
            commonCommentsClass = new CommonCommentsClass(tempProfile.getText(), hnHandle, hnAge, commentKidCount);

            commonCommentsList.add(commonCommentsClass);
        }



        commonCommentsList.sort(new SortByComment());

        List<Comments> commentsList = new ArrayList<>();

        for (Comments c: commonCommentsList){
            comments = new Comments(c.getText(), c.getHnHandle(), c.getHnAge());
            commentsList.add(comments);
        }

        LOGGER.debug("Done with comments.");
        return commentsList;
    }

    public String getHNAge(String hnHandle) {
        String profileLink = baseUrlForUser + hnHandle + suffix;
        UserProfile userProfile = restTemplate.getForObject(profileLink, UserProfile.class);
        return Utility.getProfileAge(userProfile.getCreated());
    }

}
