/**
 * Definition for singly-linked list. 单链表的定义
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //这个题其实前面150题有用到过它（判断有环） 经典做法：快慢指针 快的会第二次遇上慢的 当然也可以用哈希表（不是存表的值而是直接存这个节点）
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null ||head.next == null)
        return false;

        ListNode fast =  head.next;
        ListNode slow =  head;
        while(fast.next != null && fast.next.next != null){
            if(fast == slow)
            return true;

            fast = fast.next.next; //一定要记得 兔子一次跑两步
            slow = slow.next;

        }
        return false;
        
    }
}
