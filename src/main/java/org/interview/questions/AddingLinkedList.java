package org.interview.questions;

import org.utils.Node;

// ##Company-Amazon
public class AddingLinkedList {
    /*
     * Adding two numbers a 1 -> 2 -> 3 -> 4 b 7 -> 6
     * 
     * Answer:- 1 -> 3 -> 1 -> 0
     */
    public static Node<Long> add(Node<Long> head1, Node<Long> head2) {
        return reverse(add(reverse(head1), reverse(head2), 0l));
    }

    /*
     * Adding two numbers a 3 -> 2 -> 3 -> 4 b 7 -> 6
     * 
     * Answer:- 1 -> 0 -> 8 -> 3 -> 4
     */
    private static Node<Long> add(Node<Long> head1, Node<Long> head2, long carry) {
        assert (carry < 10);
        if (head1 == null && head2 == null) {
            return carry > 0 ? new Node<Long>(carry) : null;
        }
        long head1Val = (head1 != null ? head1.val : 0);
        long head2Val = (head2 != null ? head2.val : 0);
        assert (head1Val < 10);
        assert (head2Val < 10);
        long total = carry + head1Val + head2Val;
        Node<Long> node = new Node<Long>(total % 10);
        node.next = add((head1 != null ? head1.next : null), (head2 != null ? head2.next : null), total / 10);
        return node;

    }

    /*
     * ##ReverseLinkedList
     */
    private static Node<Long> reverse(Node<Long> head) {
        if (head == null) {
            return null;
        }
        Node<Long> currentNode = head;
        Node<Long> nextNode = head.next;
        currentNode.next = null;
        while (nextNode != null) {
            Node<Long> tmp = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = tmp;
        }
        return currentNode;
    }

    /*
     * Convert number to LinkedList:- 120 => 1-> 2 -> 0 0 => 0 012 => 1 -> 2
     */
    public static Node<Long> convertToNode(long number) {
        int length = length(number);
        return convertToNode(number, length);
    }

    private static Node<Long> convertToNode(long number, int length) {
        assert (length >= 1);
        if (length == 1) {
            return new Node<Long>(number);
        }
        long t = (long) Math.pow(10, length - 1);
        return new Node<Long>(convertToNode(number % t, length - 1), number / t);
    }

    private static int length(long number) {
        if (number < 10) {
            return 1;
        }
        return length(number / 10) + 1;
    }

    /*
     * Convert LinkedList to number:- 1-> 2 -> 0 => 120 0 => 0 1 -> 2 => 12 i.e convertToValue(convertToNode(number)) =>
     * number
     */
    public static long convertToValue(Node<Long> head) {
        return convertToValue(head, 0);
    }

    private static long convertToValue(Node<Long> head, long prefixToAdd) {
        if (head == null) {
            return prefixToAdd;
        }
        return convertToValue(head.next, prefixToAdd * 10 + head.val);
    }
}
