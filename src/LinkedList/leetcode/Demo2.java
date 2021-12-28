package LinkedList.leetcode;
// 203. 移除链表元素
public class Demo2 {

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        /*ListNode res = removeElements(head.next, val);
        if(head.val == val) {
            return res;
        }else {
            head.next = res;
            return head;
        }*/
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next: head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode header = new ListNode(arr);
        System.out.println(header);
        System.out.println(removeElements(header, 6));
    }
}
