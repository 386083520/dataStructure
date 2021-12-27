package LinkedList.leetcode;
// 203. 移除链表元素
public class Demo1 {

    public static ListNode removeElements(ListNode head, int val) {
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

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode header = new ListNode(arr);
        System.out.println(header);
        System.out.println(removeElements(header, 8));
    }
}
