/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        int length=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                // ListNode temp=slow.next;
                // length=1;
                // while(temp!=slow){
                //     temp=temp.next;
                //     length++;
                    
                // }
                break;
            }
        }
            if(fast==null || fast.next==null){
                return null;
            }
        
        // if(length==0){
        //     return null;
        // }
        // ListNode f=head;
        // ListNode s=head;
        // while(length>0){
        //     s=s.next;
        //     length--;
        // }
        // while(f!=s){
        //     f=f.next;
        //     s=s.next;
        // }
        // return s;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}