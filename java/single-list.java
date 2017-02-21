//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;
         while(list != null) {
        	 if (list.next == null) {
        		 break;
        	 }
        	 if (list.val == list.next.val) {
        		 list.next = list.next.next;
        	 } else {
        		 list = list.next;
        	 }
         }

         return head;

    }

}
