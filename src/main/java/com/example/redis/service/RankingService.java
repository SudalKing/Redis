package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RankingService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String LEADERBOARD_KEY = "leaderBoard";

    public boolean setUserScore(String userId, int score) {
        ZSetOperations zSetOps = redisTemplate.opsForZSet();
        zSetOps.add(LEADERBOARD_KEY, userId, score);

        return true;
    }

    public Long getUserRanking(String userId) {
        ZSetOperations zSetOps = redisTemplate.opsForZSet();
        Long rank = zSetOps.reverseRank(LEADERBOARD_KEY, userId);

        return rank;
    }

    public List<String> getTopRank(int limit) {
        ZSetOperations zSetOps = redisTemplate.opsForZSet();
        Set<String> rangeSet = zSetOps.reverseRange(LEADERBOARD_KEY, 0, limit - 1); // 내림차순, range(): 오름차순

        return new ArrayList<>(rangeSet);
    }
}
