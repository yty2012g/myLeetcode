package medium;

import basicDataStructure.ListNode;
/*
 * 2016.5.1 
 * 注意：进位的条件是a+b>=10，同时，在最后一位出现进位时，需要补充最高位
 */
public class Q2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res=new ListNode((l1.val+l2.val)%10);
		ListNode one=l1.next;
		ListNode two=l2.next;
		ListNode t=res;
		int jin=(l1.val+l2.val)>=10?1:0;
		while(one!=null || two!=null){
			int a=one==null?0:one.val;
			int b=two==null?0:two.val;
			ListNode temp=new ListNode((a+b+jin)%10);
			t.next=temp;
			t=temp;
			if((a+b+jin)>=10) jin=1;
			else jin=0;
			one=one==null?null:one.next;
			two=two==null?null:two.next;
		}
		if(jin==1){
			t.next=new ListNode(1);
		}
		return res;
	}
}
