package com.hnapi.demo.service;

import com.hnapi.demo.DemoApplication;
import com.hnapi.demo.model.PastStories;
import com.hnapi.demo.model.TopStories;
import com.hnapi.demo.model.TopTenStories;
import com.hnapi.demo.repository.PastStoryRepository;
import com.hnapi.demo.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TopStoriesService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String hashName = "TopTenStories";

    @Value("${baseUrl.story}")
    private String baseURLForStory;

    @Value("${baseUrl.item}")
    private String baseUrlForItem;

    @Value("${suffix}")
    private String suffix;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private PastStoryRepository pastStoryRepository;


    public List<TopStories> topStories() {

        List<String> topTenIds = Stream.of(restTemplate.getForObject(baseURLForStory, String.class)
                .replace("[","")
                .replace("]","")
                .split(","))
                .limit(10)
                .collect(Collectors.toList());

        List<PastStories> pastStoriesList = new ArrayList<>();

        List<TopStories> storiesList = new ArrayList<>();

        PastStories pastStories;

        for(String id: topTenIds) {
            String link = baseUrlForItem + id  + suffix;

            TopTenStories topTenStories = restTemplate.getForObject(link, TopTenStories.class);

            TopStories topStories = new TopStories(topTenStories.getTitle()
                                                    , topTenStories.getUrl()
                                                    , topTenStories.getScore()
                                                    , Utility.getStoryAge(topTenStories.getTime())
                                                    , topTenStories.getBy());

            storiesList.add(topStories);
            pastStories = new PastStories(topStories.getTitle()
                                        , topStories.getUrl()
                                        , topStories.getScore()
                                        , topStories.getTimeOfSubmission()
                                        , topStories.getUser());
            pastStoriesList.add(pastStories);
        }

        LOGGER.debug("Top Stories Cached.");
        return storiesList;
    }
/*
    public void dumpForPastStories(List<PastStories> pastStoriesList) {
        Long time = new Date().getTime();
        for (PastStories pastStories:  pastStoriesList)
            pastStoryRepository.savePastStoriesList(time, pastStories.getTitle()
                , pastStories.getUrl()
                , pastStories.getScore()
                , pastStories.getTimeOfSubmission()
                , pastStories.getUser());
        LOGGER.debug("Past Stories Dumped.");

//        System.out.println(">>>> DumpForPastStory >>> " + currentStory);
//        pastStoryRepository.savePastStoriesList(currentStory);
    }

 */

}
