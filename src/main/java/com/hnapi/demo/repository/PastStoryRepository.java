package com.hnapi.demo.repository;

import com.hnapi.demo.model.PastStories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Component
public interface PastStoryRepository extends CrudRepository<PastStories, Long> {

//    @Query("INSERT INTO PAST_STORIES (id, title, url, score, timeOfSubmission, user) VALUES (?1, ?2, ?3, ?4, ?5, ?6)")
//    public void savePastStoriesList(Long Id, String title, String url, Integer score, String timeOfSubmission, String user);
}