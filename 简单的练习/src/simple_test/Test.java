package simple_test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import sun.security.timestamp.TSRequest;

class hehe{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "我已经改写了toString()";
	}
}



/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	
    	ListNode head,curNode;
    	head=new ListNode(0);
    	curNode=head;//当前节点
    	while(l1!=null && l2!=null)
    	{
    		if(l1.val<l2.val)
    		{
    			curNode.next=l1;//连接下一个节点
    			l1=l1.next;
    		}
    		else 
    		{
    			curNode.next=l2;//连接下一个节点
    			l2=l2.next;
			}
    		curNode=curNode.next;//当前节点
    	}
    	curNode.next=(l1!=null)?l1:l2;
    	
		return head.next;
        
    }
}


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new hehe());
		
		LinkedHashMap<String,Integer> scores=new LinkedHashMap<>();
		scores.put("语文", 80);
		scores.put("数学", 90);
		scores.put("英语", 85);
		scores.forEach((key,value)->System.out.println(key+"------"+value));

	}

}
