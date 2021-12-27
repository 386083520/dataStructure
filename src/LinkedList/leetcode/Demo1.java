package LinkedList.leetcode;
// 203. 移除链表元素
public class Demo1 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        while (pre.next != null) {
            ListNode cur = pre.next;
            if(cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
            }else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
