package medium;

import java.util.*;

/*
 * 2016.8.19
 * 很不错的一道题。
 * 首先，设计了一个twi类用来记录推特的信息，包括用户id，推id和时间戳
 * 使用两个hashmap分别记录用户和其推特还有用户和其关注的人。
 * post操作。首先生成一个twi对象实例，查找在tweet表中是否有uid发过推特，如果没有就创建一个，有的话就在uid的推特列表后面加上最新的这条
 *           注意，由于后面的get操作最多只返回10条，因此，每个用户最多存10条推特即可，使用FIFO淘汰最老的。
 *           另外如果uid没有在关注表里面出现过，也应该在关注表里面增加uid的表项。
 * get操作。首先，得到用户的关注列表，如果用户没有在关注表里面出现，就先创建一个新的表项，并将自己加入自己的关注列表。
 *          然后，由于每个用户的推特表都是按照时间顺序排列的，要得到关注表里面所有用户发的时间戳最大的10条推特，相当于从n个有序列表里面区出最大的10个，可以利用堆来实现。
 *          在java中利用priorityqueue来实现堆，并且得到时间戳最大的10个推特
 * follow和unfollow操作，就是注意一下，不能自己取消关注自己。然后如果uid没有对应的表项，就新建一个。
 */
public class Q355 {
	public class Twitter {

		public class twi {
			int userid;
			int twid;
			int timestamp;

			public twi(int uid, int tid, int ts) {
				this.userid = uid;
				this.twid = tid;
				this.timestamp = ts;
			}
		}

		HashMap<Integer, List<twi>> tweet;
		HashMap<Integer, List<Integer>> follower;
		int timeStamp;

		/** Initialize your data structure here. */
		public Twitter() {
			tweet = new HashMap<Integer, List<twi>>(100);
			follower = new HashMap<Integer, List<Integer>>(100);
			timeStamp = 0;
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			twi twitt = new twi(userId, tweetId, timeStamp++);
			List<twi> list = tweet.get(userId);
			if (list == null) {
				list = new ArrayList<twi>();
				list.add(twitt);
				tweet.put(userId, list);
			} else {
				if (list.size() == 10) {
					list.remove(0);
				}
				list.add(twitt);
			}
			List<Integer> friend = follower.get(userId);
			if (friend == null) {
				friend = new LinkedList<Integer>();
				friend.add(userId);
				follower.put(userId, friend);
			}
		}

		public List<Integer> getNewsFeed(int userId) {
			List<Integer> res = new ArrayList<Integer>();
			List<Integer> friend = follower.get(userId);
			if (friend == null) {
				friend = new LinkedList<Integer>();
				friend.add(userId);
				follower.put(userId, friend);
				return res;
			}
			HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
			PriorityQueue<twi> pq = new PriorityQueue<twi>(friend.size(), new Comparator<twi>() {
				@Override
				public int compare(twi arg0, twi arg1) {
					// TODO Auto-generated method stub
					if (arg0.timestamp > arg1.timestamp) {
						return -1;
					} else if (arg0.timestamp < arg1.timestamp) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			for (int i = 0; i < friend.size(); i++) {
				int uid = friend.get(i);
				List<twi> list = tweet.get(uid);
				if (list == null) {
					temp.put(uid, 0);
				} else {
					temp.put(uid, list.size());
					pq.add(list.get(list.size() - 1));
				}

			}
			for (int i = 0; i < 10; i++) {
				if (pq.size() == 0)
					break;
				twi t = pq.poll();
				res.add(t.twid);
				Integer inte = temp.get(t.userid);
				inte--;
				if (inte != 0) {
					pq.add(tweet.get(t.userid).get((int) inte - 1));
					temp.put(t.userid, inte);
				} else {
					temp.put(t.userid, 0);
				}
			}
			return res;
		}

		public void follow(int followerId, int followeeId) {
			if (followerId == followeeId)
				return;
			List<Integer> list = follower.get(followerId);
			if (list == null) {
				list = new LinkedList<Integer>();
				list.add(followerId);
				list.add(followeeId);
				follower.put(followerId, list);
			} else if (!list.contains(followeeId)) {
				list.add(followeeId);
			}

		}

		public void unfollow(int followerId, int followeeId) {
			if (followerId == followeeId)
				return;
			List<Integer> list = follower.get(followerId);
			if (list == null) {
				list = new LinkedList<Integer>();
				list.add(followerId);
				follower.put(followerId, list);
			} else if (list.contains(followeeId)) {
				list.remove((Integer) followeeId);
			}
		}
	}
}
