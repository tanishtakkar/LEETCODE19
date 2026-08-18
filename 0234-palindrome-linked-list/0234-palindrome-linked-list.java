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
        if(head==null || head.next ==null){
        return true;
       }
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode prev = null; 
        ListNode curr=slow.next;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } 
        ListNode first = head;
        ListNode second = prev;
        while(second!=null){
            if(first.val != second.val){
                return false;
            }
            else{
                first = first.next;
                second = second.next;
            }  
        }
        return true;
    }

}