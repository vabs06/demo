package com.hnapi.demo.controller;

import com.hnapi.demo.model.Comments;
import com.hnapi.demo.model.PastStories;
import com.hnapi.demo.model.TopStories;
import com.hnapi.demo.repository.PastStoryRepository;
import com.hnapi.demo.service.CommentsService;
import com.hnapi.demo.service.TopStoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TopStoriesService topStoriesService;

    @Autowired
    public CommentsService commentsService;

    @Autowired
    private PastStoryRepository pastStoryRepository;


    @RequestMapping(value = "/top-stories", method = RequestMethod.GET)
    @Cacheable(value = "topStories")
    public List<TopStories> getTopStories() {
        return topStoriesService.topStories();

    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public List<Comments> getComments (@PathVariable String id) {
        return commentsService.getComments(id);
    }

    /*
    //  It is hard to implement for me right now.
    @RequestMapping(value = "/past-stories", method = RequestMethod.GET)
    public List<TopStories> getAllPastStories() {

        return new ArrayList<TopStories>();
    }

     */
}


