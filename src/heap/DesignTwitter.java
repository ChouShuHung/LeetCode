package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DesignTwitter {

  public static void main(String[] args) {
    Twitter obj = new Twitter();

    obj.postTweet(1, 5);
    System.out.println(obj.getNewsFeed(1));
    obj.follow(1, 2);
    obj.postTweet(2, 6);
    System.out.println(obj.getNewsFeed(1));
    obj.unfollow(1, 2);
    System.out.println(obj.getNewsFeed(1));
  }
}

class Twitter {

  // HashSet -> add and delete in O(1)
  Map<Integer, Set<Integer>> followList;
  Map<Integer, Map<Integer, Integer>> userFeeds;
  int count;

  public Twitter() {
    followList = new HashMap<>();
    userFeeds = new HashMap<>();
    count = 0;
  }

  /**
   * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
   * Each call to this function will be made with a unique tweetId.
   * @param userId
   * @param tweetId
   */
  public void postTweet(int userId, int tweetId) {
    if (!userFeeds.containsKey(userId)) {
      Map<Integer, Integer> newFeeds = new HashMap<>();
      newFeeds.put(++count, tweetId);
      userFeeds.put(userId, newFeeds);
    } else {
      userFeeds.get(userId).put(++count, tweetId);
    }
  }

  /**
   * Retrieves the 10 most recent tweet IDs in the user's news feed.
   * Each item in the news feed must be posted by users who the user followed or by the user themself.
   * Tweets must be ordered from most recent to least recent.
   * @param userId
   * @return
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> most10recentFeeds = new ArrayList<>();
    Set<Integer> tweeters = new HashSet<>();
    tweeters.add(userId);

    Map<Integer, Integer> userTweets = new HashMap<>();
    if (followList.containsKey(userId)) {
      tweeters.addAll(followList.get(userId));
    }

    Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
    for (int followee : tweeters) {
      if (userFeeds.containsKey(followee)) {
        userTweets.putAll(userFeeds.get(followee));
      }
    }
    for (int count : userTweets.keySet()) {
      heap.add(count);
    }
    for (int i=0; i < 10 && !heap.isEmpty(); i++) {
      most10recentFeeds.add(userTweets.get(heap.poll()));
    }

    return most10recentFeeds;
  }

  // The user with ID followerId started following the user with ID followeeId.
  public void follow(int followerId, int followeeId) {
    if (!followList.containsKey(followerId)) {
      Set<Integer> followees = new HashSet<>();
      followees.add(followeeId);
      followList.put(followerId, followees);
    } else {
      followList.get(followerId).add(followeeId);
    }
  }

  // The user with ID followerId started unfollowing the user with ID followeeId.
  public void unfollow(int followerId, int followeeId) {
    if (
      followList.containsKey(followerId) &&
      followList.get(followerId).contains(followeeId)
    ) {
      followList.get(followerId).remove(followeeId);
    } else {
      System.out.println("Cannot find any followee.");
    }
  }
}
