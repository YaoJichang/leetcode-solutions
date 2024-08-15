//用快慢指针 能实现一趟扫描!
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head; //这个你给忘记了！
        ListNode pre = dummpy;
        ListNode slow = head;
        ListNode fast = head;
        int temp = n;

        //slow比fast晚n步更新
        while(temp!=0){
            fast = fast.next;
            temp--;
        }

        while(fast!=null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = slow.next;

        return dummpy.next;

    }
}
