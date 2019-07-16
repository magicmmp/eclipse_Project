package removeDuplicatesFromSortedList_83;

class ListNode 
{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class Solution {
	
	public ListNode deleteDuplicates(ListNode head) 
	{
		if(head==null||head.next==null)
			return head;
		ListNode currNode=head; //当前节点位置
		while (currNode.next!=null) 
		{
			if(currNode.next.val!=currNode.val)
				currNode=currNode.next;//移向下一节点
			else 
				currNode.next=currNode.next.next;//不指向相同的节点
		}
		return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
