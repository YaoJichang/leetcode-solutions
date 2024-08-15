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
 //用GPT帮你修改 增加了head与prev
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 如果 list1 为空，直接返回 list2
        if (list1 == null) return list2;
        // 如果 list2 为空，直接返回 list1
        if (list2 == null) return list1;

        ListNode head = list1;  // 用于保存 list1 的头节点
        ListNode prev = null;   // 用于追踪 list1 的前一个节点

      while(list2!= null&&list1!=null){
        if(list2.val<=list1.val){
            ListNode tempNode = list2.next;
            if (prev != null) {
                    prev.next = list2;
            } else {
            head = list2;  // 更新 head，如果 list2 的头节点比 list1 的头节点小
                }
            list2.next = list1;
            prev = list2;
            list2 = tempNode;
        }
        else{
            prev = list1;
            list1 = list1.next;
        }

      }
      // 如果 list2 还有剩余节点，直接接到 list1 的末尾
        if (list2 != null) {
            prev.next = list2;
        }

        return head;

    }
}
