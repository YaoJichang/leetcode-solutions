//题解的方法更简洁
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummpy;
        while(fast!=null){
           if(slow.next!=null &&slow.next.val != fast.val){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
           }
           else if(slow.next == null || fast.next == null){
            break;
           } 
           else {
            while(fast!=null&&fast.val == slow.val){
                fast = fast.next;
            }
    
            pre.next = fast;
            slow = fast;
            
    
           }
        }

        return dummpy.next;

    }
}
