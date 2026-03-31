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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {       
        ListNode l3 = new ListNode(0);                      // create a temporary listnode
        ListNode tail = l3;                                 // Create a tracking listnode tail to track the tail end of l3
        int carry = 0;                          
        while(l1 != null || l2 != null || carry != 0){      // run loop till all conditions are false
            int d1 = (l1 != null) ? l1.val : 0;             // take digit from l1 if it exists
            int d2 = (l2 != null) ? l2.val : 0;             // take digit from l2 if it exists
            int sum = d1 + d2 + carry;                      // add digits d1, d2 and carry
            int d = sum % 10;                               // take the digit to be added to the new listNode
            carry = sum / 10;                               // put the remaining in carry
            ListNode nn = new ListNode(d);                  // create a new temporary listnode
            tail.next = nn;                                 // the tail end tracking values next value will be nn
            tail = tail.next;                               // update tail pointer
            l1 = (l1 != null) ? l1.next : null;             // update l1
            l2 = (l2 != null) ? l2.next : null;             // update l2
        }
        ListNode ans = l3.next;                             // create the final ans listNode which is connected to l3.next
        l3.next = null;                                     
        return ans;
    }
}