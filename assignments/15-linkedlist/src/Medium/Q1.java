package Medium;

import java.util.*;

class Twitter {

    private static class Tweet {
        int tweetId;
        int timePosted;

        public Tweet(int tweetId, int timePosted) {
            this.tweetId = tweetId;
            this.timePosted = timePosted;
        }
    }

    static int timeStamp;
    int feedMaxNum;
    Map<Integer, Set<Integer>> follows; // [userID]{...unique followers}
    Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        timeStamp = 0;
        feedMaxNum = 10;
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
            // follow itself
            follow(userId, userId);
        }
        tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> feedHeap = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.timePosted - o2.timePosted;
            }
        });

        Set<Integer> myFollowers = follows.get(userId);
        if (myFollowers != null) {
            for (int fff : myFollowers) {
                List<Tweet> followersTweets = tweets.get(fff);
                if (followersTweets == null)
                    continue;

                // accessing the tweets of each followers of usreID
                for (Tweet t : followersTweets) {
                    if (feedHeap.size() < feedMaxNum)
                        feedHeap.add(t);
                    else {
                        if (t.timePosted > feedHeap.peek().timePosted) {
                            feedHeap.add(t);
                            feedHeap.poll();// removeing the oldest
                        } else {
                            break;// as the feedSize() > 10 and t.timePosted is less than the minHeap val
                        }
                    }
                }
            }
        }

        List<Integer> myFeed = new ArrayList<>();
        while (!feedHeap.isEmpty()) {
            myFeed.add(0, feedHeap.poll().tweetId);// push at front so thaat smallest at first get to back after done
        }
        return myFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId))
            follows.put(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId) || followeeId == followerId)
            return ;
        follows.get(followerId).remove(followeeId);
    }
}


public class Q1 {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        String[] option = new String[]{"Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"};
        List<List<Integer>> params = new ArrayList<>();
        params.add(new ArrayList<>());
        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(1);
        params.get(params.size() - 1).add(5);

        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(1);

        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(1);
        params.get(params.size() - 1).add(2);

        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(2);
        params.get(params.size() - 1).add(6);

        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(1);

        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(1);
        params.get(params.size() - 1).add(2);

        params.add(new ArrayList<>());
        params.get(params.size() - 1).add(1);
        System.out.println(params);

        for (String choice : option) {

            switch (choice) {
                case "postTweet" -> {
                    obj.postTweet(params.get(0).get(0),params.get(0).get(1));
                    params.remove(0);
                    System.out.println("null");
                }
                case "getNewsFeed" -> {
                    System.out.println(obj.getNewsFeed(params.get(0).get(0)));
                    params.remove(0);
                }

                case "follow" -> {
                    obj.follow(params.get(0).get(0),params.get(0).get(1));
                    System.out.println("null");
                    params.remove(0);
                }
                case "unfollow" -> {
                    obj.unfollow(params.get(0).get(0),params.get(0).get(1));
                    System.out.println("null");
                    params.remove(0);
                }
                default -> {
                    params.remove(0);
                    System.out.println("null");
                }
            }
        }
    }
}
