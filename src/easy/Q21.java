package easy;

import basicDataStructure.ListNode;
/*
 * 2016.5.5
 * ���ûɶ��˵�ģ����Ǳ߽��жϡ�Ȼ�����ζ�ȡ���������н�С��Ԫ�أ������µ�����
 */
public class Q21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode head=new ListNode(0);
		ListNode copyhead=head;
		ListNode copy1=l1;
		ListNode copy2=l2;
		while(copy1!=null || copy2!=null){
			if(copy1!=null && copy2!=null){
				if(copy1.val<copy2.val){
					head.next=copy1;
					copy1=copy1.next;
					head=head.next;
				}else{
					head.next=copy2;
					copy2=copy2.next;
					head=head.next;
				}
			}else if(copy1==null){
				head.next=copy2;
				copy2=copy2.next;
				head=head.next;
			}else{
				head.next=copy1;
				copy1=copy1.next;
				head=head.next;
			}
		}
		return copyhead.next;
	}
}
