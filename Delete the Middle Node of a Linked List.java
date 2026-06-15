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
        if(head.next==null) {
            return null;
        }
        
        ListNode temp = head;
        int n = 0;
        Map<Integer, ListNode> mp = new HashMap<>();
        while(temp!=null) {
            mp.put(n,temp);
            n++;
            temp = temp.next;
        }

        n/=2;
       
        temp = mp.getOrDefault(n,null);
        ListNode temp2 = mp.getOrDefault(n-1,null);



        if(temp2==null) {
            temp2 = temp.next;
        } else {
            temp2.next = temp.next;
        }

        return head;
    }
}