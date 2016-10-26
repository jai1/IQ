package org.interview.questions;

// ##GenericClass
public class BinaryNode<T> {
    public BinaryNode<T> left = null;
    public BinaryNode<T> right = null;
    public T val;

    public BinaryNode(BinaryNode<T> left, BinaryNode<T> right, T val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public BinaryNode(T val) {
        this.val = val;
    }
}
