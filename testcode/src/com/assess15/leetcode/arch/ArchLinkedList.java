package com.assess15.leetcode.arch;

/**
 * 链表
 * 迭代框架
 * 迭代访问/递归访问
 */
public class ArchLinkedList {

    private static ListNode loop(ListNode head) {
        // 递归 取值 head.value
        if (head.next == null) return head;
        ListNode rs = loop(head.next);
        return rs;
    }

    private static ListNode loop2(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代 取值 p.value
            System.out.println(p.value);
        }
        return head;
    }

    /**
     * 递归版 反转链表
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 部分反转链表
     * head = 1,2,3,4,5
     * m = 2
     * n = 4
     * head = 1,4,3,2,5
     *
     * @param head
     * @param m    start
     * @param n    end
     * @return
     */
    private static ListNode reverseRange(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseRange(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 反转链表前N节点
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseN(ListNode head, int n) {
        ListNode cur = null;
        if (n == 1) {
            cur = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = cur;
        return last;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        ListNode head = LinkedListUtils.getInstance().stringToListNode(str);

//        ListNode loop = loop(head);
//        ListNode loop = loop2(head);
//        ListNode loop = reverse(head);
//        ListNode loop = reverseN(head, 3);
        ListNode loop = reverseRange(head, 2, 4);

        String string = LinkedListUtils.getInstance().listNodeToString(loop);
        System.out.println(string);
    }

    /**
     * 链表节点
     */
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
