package com.zhangpingyang.springcloud_producer;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumbersTest {
    @Test
    public void test1() {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        ListNode listNode = addTwoNumbers(l11, l21);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int index1 = 0;
        int index2 = 0;
        ListNode tempNode;
        tempNode = l1;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            index1 ++;
        }
        tempNode = l2;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            index2++;
        }
        ListNode reNode;
        if (index1 > index2) {
            int index3 = index1 - index2;
            ListNode listNode;
            while (index3-- == 0) {
                listNode = l1.next;

                if (index3 == 0) {
                    break;
                }
            }
            while (index1-- > 0) {
                l2.val += l1.val;
            }
            return l2;
        } else {
            int index3 = index2 - index1;
            ListNode listNode = null;
            while (index3-- > 0) {
                listNode = l1.next;

                if (index3 == 0) {
                    break;
                }
            }
            if (listNode == null) {
                listNode = l1;
            }


            while (true) {
                reNode = new ListNode(l2.val + listNode.val);
                l2 = l2.next;
                listNode = listNode.next;
                if (l2 != null) {
                    reNode.next = new ListNode(l2.val + listNode.val);
                } else {
                    break;
                }
            }

            return reNode;
        }
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
