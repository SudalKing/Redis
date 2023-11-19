package com.example.redis;

import com.example.redis.service.RankingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private RankingService rankingService;

    @Test
    void insertScore() {
        for (int i = 0; i < 1000000; i++) {
            int score = (int) (Math.random() * 1000000); // 0 ~ 999999
            String userId = "useR_" + i;
            rankingService.setUserScore(userId, score);
        }
    }

    @Test
    void getRanks() {
        rankingService.getTopRank(1); // 제대로 된 redis 성능 확인을 위해 처음 호출 세팅

        // 1)
        Instant before = Instant.now();
        Long userRank = rankingService.getUserRanking("useR_100");
        Duration elapsed = Duration.between(before, Instant.now());

        System.out.println(String.format("Rank(%d) - Took %d ms", userRank, elapsed.getNano() / 1000000));

        // 2)
        before = Instant.now();
        List<String> topRankers = rankingService.getTopRank(10);
        elapsed = Duration.between(before, Instant.now());

        System.out.println(String.format("Range - Took %d ms", elapsed.getNano() / 1000000));
    }

    @DisplayName("1. InMemorySortPerformance")
    @Test
    void inMemorySortPerformance(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int score = (int) (Math.random() * 1000000); // 0 ~ 999999
            list.add(score);
        }

        Instant before = Instant.now();
        Collections.sort(list); // nlogn
        Duration elapsed = Duration.between(before, Instant.now());
        System.out.println((elapsed.getNano() / 1000000) + " ms");
    }
}
