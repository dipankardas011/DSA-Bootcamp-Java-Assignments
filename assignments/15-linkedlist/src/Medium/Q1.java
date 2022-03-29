package Medium;

import java.util.List;

class Twitter {

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {

    }

    public List<Integer> getNewsFeed(int userId) {

    }

    public void follow(int followerId, int followeeId) {

    }

    public void unfollow(int followerId, int followeeId) {

    }
}


public class Q1 {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(userId,tweetId);
        List<Integer> param_2 = obj.getNewsFeed(userId);
        obj.follow(followerId,followeeId);
        obj.unfollow(followerId,followeeId);
    }
}
