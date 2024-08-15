
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummpyNode = new ListNode(-1);
        dummpyNode.next = head;
        ListNode pre = dummpyNode;
        ListNode last = pre;
        int temp = k;
        boolean flag = true; //用来判断还有没有last.next 避免空指针报错
        while(true){ 
            ListNode first = last.next;
            while(temp!=0){
                if(last.next == null)
                {
                    flag = false;
                    break;
                }

                last = last.next;
                temp--;
            }

            if(!flag)
            break;

            if(last!=null){ 
                ListNode cur = last.next;
                pre.next = null;
                last.next = null; //截断出一个子链表

                reverseLinkedList(first);//逆转子链表

                //接回到原来的链表里面
                pre.next = last;
                first.next = cur;

                //进行下一次反转
                temp = k;
                last = first;
                pre = first;
            }

            else{
                break;
            }

        }
      return dummpyNode.next;

    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
