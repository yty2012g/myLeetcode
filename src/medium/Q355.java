package medium;

import java.util.*;

/*
 * 2016.8.19
 * �ܲ����һ���⡣
 * ���ȣ������һ��twi��������¼���ص���Ϣ�������û�id����id��ʱ���
 * ʹ������hashmap�ֱ��¼�û��������ػ����û������ע���ˡ�
 * post��������������һ��twi����ʵ����������tweet�����Ƿ���uid�������أ����û�оʹ���һ�����еĻ�����uid�������б����������µ�����
 *           ע�⣬���ں����get�������ֻ����10������ˣ�ÿ���û�����10�����ؼ��ɣ�ʹ��FIFO��̭���ϵġ�
 *           �������uidû���ڹ�ע��������ֹ���ҲӦ���ڹ�ע����������uid�ı��
 * get���������ȣ��õ��û��Ĺ�ע�б�����û�û���ڹ�ע��������֣����ȴ���һ���µı�������Լ������Լ��Ĺ�ע�б�
 *          Ȼ������ÿ���û������ر��ǰ���ʱ��˳�����еģ�Ҫ�õ���ע�����������û�����ʱ�������10�����أ��൱�ڴ�n�������б�������������10�����������ö���ʵ�֡�
 *          ��java������priorityqueue��ʵ�ֶѣ����ҵõ�ʱ�������10������
 * follow��unfollow����������ע��һ�£������Լ�ȡ����ע�Լ���Ȼ�����uidû�ж�Ӧ�ı�����½�һ����
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
