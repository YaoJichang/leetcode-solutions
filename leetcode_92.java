class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建一个哑节点，它的 next 指向 head，用于简化边界情况
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode pre = dummyNode;
        // 移动 pre 到 left 位置的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        
        // `start` 指向要反转区域的第一个节点
        ListNode start = pre.next;
        // `then` 是用于遍历反转的节点
        ListNode then = start.next;
        
        // 进行反转操作
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        // 返回新的头节点
        return dummyNode.next;
    }
}
