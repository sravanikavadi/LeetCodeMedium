package org.LeetCodeMedium;

import java.util.List;

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class SortLinkedList {
    ListNode head = null;
    public static void main(String args[]){
        SortLinkedList list = new SortLinkedList();
        list.push(4);
        list.push(2);
        list.push(1);
        list.push(3);
        System.out.println("head = "+ list.head.val);
        ListNode result = sortList(list.head);
        while(result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public void push(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);
        ListNode result = merge(left, right);
        return result;
    }
    public static ListNode getMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        ListNode result;
        if(left.val <= right.val){
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
}
