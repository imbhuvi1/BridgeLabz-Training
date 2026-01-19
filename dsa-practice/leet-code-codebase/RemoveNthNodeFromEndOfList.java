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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //part1 - find index of element
        ListNode temp = head;
        
        int length = 0;

        while(temp!=null){
            length++;
            temp=temp.next;
        }
        System.out.println(length);

        if(length-n == 0){
            return head.next;
        }
        int targetIdx = length-n;
        
        //part 2
        temp = head;
        int curr = 0;
        for(int i=1; i<length; i++){
            
            if(i==targetIdx){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}