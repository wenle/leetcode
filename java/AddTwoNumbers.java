/**
 * date 17/2/27
 *
 * @see https://leetcode.com/problems/add-two-numbers/?tab=Description
 * @author wenle
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode prev = null;
        int currentVal = 0;
        int overflow = 0;

        while(l1 != null && l2 != null) {

            int total = l1.val + l2.val + overflow;
            if(total >= 10) {
                currentVal = total - 10;
                overflow = 1;
            } else {
                currentVal = total;
                overflow = 0;
            }

            ListNode node = new ListNode(currentVal);
            if(prev != null) {
                prev.next = node;
            } else {
                head = node;
            }
            prev = node;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            ListNode left = (l1 != null) ? l1 : l2;
            while(left != null) {

                ListNode node;
                if(left.val + overflow >= 10) {
                    node = new ListNode(0);
                    overflow = 1;
                } else {
                    node = new ListNode(left.val + overflow);
                    overflow = 0;
                }
                if(prev != null) {
                    prev.next = node;
                } else {
                    head = node;
                }
                prev = node;
                left = left.next;
            }
        }

        if(overflow > 0) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        return head;
    }
}
