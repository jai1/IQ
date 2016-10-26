package org.utils;

//##GenericClass
public class Node<T> {
    public Node next = null;
    public T val;

    public Node(Node n, T val) {
        this.next = n;
        this.val = val;
    }

    public Node(T val) {
        this.val = val;
    }

    public Node() {
        // TODO Auto-generated constructor stub
    }
}
