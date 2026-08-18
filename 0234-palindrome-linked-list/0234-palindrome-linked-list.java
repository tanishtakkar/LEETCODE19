/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(checkPalindrome(head)==1){
            return true;
        }
        return false;
    }
   private static int checkPalindrome(ListNode head) {
    if(head==null || head.next==null){
        return 1;
    }
      ListNode slow=head;
      ListNode fast=head;
      while(fast.next!=null && fast.next.next!=null){
          slow=slow.next;
          fast=fast.next.next;
      }
      slow=slow.next;
      ListNode prev=null;
      while(slow!=null){
          ListNode next=slow.next;
          slow.next=prev;
          prev=slow;
          slow=next;
      }
      ListNode first=head;
      ListNode second=prev;
      while(second!=null){
          if(first.val!=second.val){
              return 0;
          }
          first=first.next;
          second=second.next;
      }
      return 1;
  }

}