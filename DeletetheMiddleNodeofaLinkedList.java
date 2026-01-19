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
    public ListNode deleteMiddle(ListNode head) {
        int size =0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        System.out.println(size);
        if(size==1){
            return null;
        }
        if(size==2){
            head.next = null;
            return head;
        }
        int mid = size/2;

        temp = head;
        for(int i=1; i<mid; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}