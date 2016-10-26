package org.interview.questions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.Node;

public class AddingLinkedListTest {

    @Test
    public void convertToNodeTest_1() {
        long number = 1230;
        Node head = AddingLinkedList.convertToNode(number);
        Assert.assertEquals(head.val, 1l);
        Assert.assertEquals(head.next.val, 2l);
        Assert.assertEquals(head.next.next.val, 3l);
        Assert.assertEquals(head.next.next.next.val, 0l);
        Assert.assertEquals(head.next.next.next.next, null);
    }

    @Test
    public void convertToNodeTest_2() {
        long number = 0;
        Node head = AddingLinkedList.convertToNode(number);
        Assert.assertEquals(head.val, 0l);
    }

    @Test
    public void convertToNodeTest_3() {
        long number = 1;
        Node head = AddingLinkedList.convertToNode(number);
        Assert.assertEquals(head.val, 1l);
    }

    @Test
    public void convertToValue_1() {
        long number = 1230;
        Assert.assertEquals(number, AddingLinkedList.convertToValue(AddingLinkedList.convertToNode(number)));
    }

    @Test
    public void convertToValue_2() {
        long number = 0;
        Assert.assertEquals(number, AddingLinkedList.convertToValue(AddingLinkedList.convertToNode(number)));
    }

    @Test
    public void convertToValue_3() {
        long number = 1;
        Assert.assertEquals(number, AddingLinkedList.convertToValue(AddingLinkedList.convertToNode(number)));
    }

    @Test
    public void addTest_1() {
        long number1 = 1234;
        long number2 = 4;
        Node head = AddingLinkedList.add(AddingLinkedList.convertToNode(number1),
                AddingLinkedList.convertToNode(number2));
        Assert.assertEquals(head.val, 1l);
        Assert.assertEquals(head.next.val, 2l);
        Assert.assertEquals(head.next.next.val, 3l);
        Assert.assertEquals(head.next.next.next.val, 8l);
        Assert.assertEquals(head.next.next.next.next, null);
    }

    @Test
    public void addTest_2() {
        long number1 = 1234;
        long number2 = 6;
        Node head = AddingLinkedList.add(AddingLinkedList.convertToNode(number1),
                AddingLinkedList.convertToNode(number2));
        Assert.assertEquals(head.val, 1l);
        Assert.assertEquals(head.next.val, 2l);
        Assert.assertEquals(head.next.next.val, 4l);
        Assert.assertEquals(head.next.next.next.val, 0l);
        Assert.assertEquals(head.next.next.next.next, null);
    }

    @Test
    public void addTest_3() {
        long number1 = 9982;
        long number2 = 18;
        Node head = AddingLinkedList.add(AddingLinkedList.convertToNode(number1),
                AddingLinkedList.convertToNode(number2));
        Assert.assertEquals(head.val, 1l);
        Assert.assertEquals(head.next.val, 0l);
        Assert.assertEquals(head.next.next.val, 0l);
        Assert.assertEquals(head.next.next.next.val, 0l);
        Assert.assertEquals(head.next.next.next.next.val, 0l);
        Assert.assertEquals(head.next.next.next.next.next, null);
    }
}
