package com.hnapi.demo.service;

import com.hnapi.demo.DemoApplication;
import com.hnapi.demo.model.TopStories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RedisService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

//    After every 10 minute cache will the evict(flush).
    @Scheduled(fixedRate = 600000)
    @CacheEvict(value = "topStories", allEntries = true)
    public void applyCacheEvict() {
        LOGGER.debug("Cache has been cleared.");
    }

}
