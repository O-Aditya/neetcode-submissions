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

    private ListNode Middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null &&fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode first = head;
        ListNode mid = Middle(head);
        ListNode second = mid.next;
        mid.next = null;      // VERY IMPORTANT
        second = Reverse(second);
        
        while(second != null){

            ListNode firstnext = first.next;
            ListNode secondnext = second.next;

            first.next = second;
            second.next = firstnext;

            first = firstnext;
            second = secondnext;


        }
        
    }
}
