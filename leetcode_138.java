class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一步：复制每个节点，并插入到原节点之后
        Node currentNode = head;
        while (currentNode != null) {
            Node copyNode = new Node(currentNode.val);
            copyNode.next = currentNode.next;
            currentNode.next = copyNode;
            currentNode = copyNode.next;
        }

        // 第二步：设置复制节点的 random 指针
        currentNode = head;
        while (currentNode != null) {
            if (currentNode.random != null) {
                currentNode.next.random = currentNode.random.next; //为啥 想清楚！
            }
            currentNode = currentNode.next.next;
        }

        // 第三步：将原链表和复制链表分离
        currentNode = head;
        Node copyHead = head.next;
        Node copyNode = copyHead;
        while (currentNode != null) {
            currentNode.next = currentNode.next.next;// 原链表也要去分离修护！不然会抛出异常（因为对原链表进行了修改）
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next; 
            }
            currentNode = currentNode.next;
            copyNode = copyNode.next;
        }


        return copyHead;
    }
}
