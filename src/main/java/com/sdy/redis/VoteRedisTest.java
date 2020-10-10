package com.sdy.redis;

import com.google.common.collect.Lists;
import com.sun.org.apache.regexp.internal.RE;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author: sundy
 * @date: 2020/10/9 14:58
 * @description:
 */
public class VoteRedisTest {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    public static final int VOTE_SCORE = 432;
    public static final int ARTICLES_PER_PAGE = 25;
    private static final Jedis voteRedis = new Jedis("39.105.129.105");

    public static void main(String[] args) {
//        for (int i = 1; i <= 3; i++) {
//            postArticle(i, "测试文章-" + i);
//        }
//        postArticle(2, "测试文章-2");
        System.out.println(getArticles(1, "score:"));
//        createArticle(1);
//        addArticle("article:1", 1);

    }

    private static void createArticle(Integer articleId) {
//        voteRedis.zadd("time:", 0, "article:" + articleId);
    }


    /**
     * article = article:123456
     *
     * @param article
     */
    public static void articleVote(String article, Integer userId) {
        long cutoff = System.currentTimeMillis() - ONE_WEEK_IN_SECONDS;
        if (voteRedis.zscore("time:", article) < cutoff) {
            return;
        }
        String articleId = article.split(":")[1];
        if (voteRedis.sadd("voted:" + articleId, "user:" + userId) > 0) {
            voteRedis.zincrby("score:", VOTE_SCORE, article);
            voteRedis.hincrBy(article, "votes", 1);
        }
    }

    public static String postArticle(Integer userId, String title) {
        String user = "user" + userId;
        String articleId = String.valueOf(voteRedis.incr("article:"));
        String voted = "voted:" + articleId;
        voteRedis.sadd(voted, user);
        voteRedis.expire(voted, ONE_WEEK_IN_SECONDS);
        long now = System.currentTimeMillis();
        String article = "article:" + articleId;
        Map<String, String> map = new HashMap();
        map.put("title", title);
        map.put("poster", user);
        map.put("time", now + "");
        map.put("votes", 1 + "");
        voteRedis.hmset(article, map);
        voteRedis.zadd("score:", now + VOTE_SCORE, article);
        voteRedis.zadd("time:", now, article);
        return articleId;
    }

    public static List<Map<String, String>> getArticles(int page, String order) {
        long start = (page - 1) * ARTICLES_PER_PAGE;
        long end = start + ARTICLES_PER_PAGE - 1;
        Set<String> ids = voteRedis.zrevrange(order, start, end);
        List<Map<String, String>> articles = new ArrayList<>();
        ids.forEach(id -> {
            final Map<String, String> articleDate = voteRedis.hgetAll(id);
            articleDate.put("id", id);
            articles.add(articleDate);
        });
        return articles;
    }
}
