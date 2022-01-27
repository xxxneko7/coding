package com.sol.algorithm.solution.dfs;

import java.util.*;

/**
 * 355. 设计推特
 */
class Twitter {
    public Twitter() {
        userIdToUser = new HashMap<>();
    }

    /**
     * 发送推文
     *
     * @param userId  用户ID
     * @param tweetId 推文ID
     */
    public void postTweet(int userId, int tweetId) {
        getUser(userId).postTweet(tweetId);
    }

    /**
     * 获取用户和关注人的最新几条推文
     *
     * @param userId 用户ID
     * @return 最新的几条推文
     */
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        // 多路合并问题，利用 大根堆 对用户和关注人的推文按时间排序
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((tweet1, tweet2) -> tweet2.timestamp - tweet1.timestamp);
        // 添加用户最新的一条推文
        if (user.recentTweet != null) {
            maxHeap.offer(user.recentTweet);
        }
        // 添加每个关注人最新的一条推文
        if (user.following != null && user.following.size() > 0) {
            for (Integer followingId : user.following) {
                Tweet recentTweet = getUser(followingId).recentTweet;
                if (recentTweet != null) {
                    maxHeap.offer(recentTweet);
                }
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        // 记录最新的推文，并用其上一条推文更新 大根堆
        while (!maxHeap.isEmpty() && count++ < MAX_NUM_OF_NEWS_FEED) {
            Tweet recentTweet = maxHeap.poll();
            newsFeed.add(recentTweet.id);
            if (recentTweet.last != null) {
                maxHeap.offer(recentTweet.last);
            }
        }
        return newsFeed;
    }

    /**
     * 关注
     *
     * @param followerId 关注者ID
     * @param followeeId 被关注者ID
     */
    public void follow(int followerId, int followeeId) {
        getUser(followerId).follow(followeeId);
    }

    /**
     * 取关
     *
     * @param followerId 关注者ID
     * @param followeeId 被关注者ID
     */
    public void unfollow(int followerId, int followeeId) {
        getUser(followerId).unfollow(followeeId);
    }

    /**
     * 获取用户
     *
     * @param userId 用户ID
     * @return 用户对象
     */
    public User getUser(int userId) {
        if (userIdToUser.containsKey(userId)) {
            return userIdToUser.get(userId);
        }
        User newUser = new User(userId);
        userIdToUser.put(userId, newUser);
        return newUser;
    }

    public class User {
        /**
         * ID
         */
        public int id;
        /**
         * 关注人ID集合
         */
        public Set<Integer> following;
        /**
         * 最新的一条推文
         */
        public Tweet recentTweet;

        public User(int id) {
            this.id = id;
            this.following = new HashSet<>();
        }

        /**
         * 关注用户
         *
         * @param followeeId 关注用户ID
         */
        public void follow(int followeeId) {
            if (id == followeeId) return;
            following.add(followeeId);
        }

        /**
         * 取关用户
         *
         * @param followeeId 关注用户ID
         */
        public void unfollow(int followeeId) {
            following.remove(followeeId);
        }

        /**
         * 发送推文
         *
         * @param tweetId 推文ID
         */
        public void postTweet(int tweetId) {
            recentTweet = new Tweet(tweetId, recentTweet);
        }
    }

    public class Tweet {
        /**
         * ID
         */
        public int id;
        /**
         * 时间戳
         */
        public int timestamp;
        /**
         * 上一条推文，便于在【堆排序】时替换出堆的元素
         */
        public Tweet last;

        public Tweet(int id, Tweet last) {
            this.id = id;
            this.timestamp = time++;
            this.last = last;
        }
    }

    /**
     * 可查看的最新推文的上限
     */
    private static final int MAX_NUM_OF_NEWS_FEED = 10;
    /**
     * 当前时间
     */
    private int time;
    /**
     * 用户ID到用户对象的映射
     */
    private Map<Integer, User> userIdToUser;
}

