package org.interview.questions;

import java.util.ArrayList;
import java.util.List;

import org.utils.BinaryNode;

public class BinaryTree {
    /************************************************/
    /*
     * ##balancedBinarySearchTree ##BST ##isValidBST Check if a given tree is a valid Binary Search Tree The left
     * subtree of a node contains only nodes with keys less than OR equal to the node's key. The right subtree of a node
     * contains only nodes with keys greater than the node's key.
     */
    // Can't use Generic here due to MIN_VALUE and MAX_VALUE
    public static boolean isValidBST(BinaryNode<Integer> root) {
        return isValidBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }

    private static boolean isValidBST(Integer minValue, Integer maxValue, BinaryNode<Integer> node) {
        return node == null || (((node.val == Integer.MIN_VALUE || node.val.compareTo(minValue) > 0)
                && node.val.compareTo(maxValue) <= 0) && isValidBST(minValue, node.val, node.left)
                && isValidBST(node.val, maxValue, node.right));
    }

    /**************/
    public class Result {
        boolean result = false;
        int height = 0;

        public Result(int height, boolean result) {
            this.height = height;
            this.result = result;
        }
    }

    public static boolean isValidBalancedBST(BinaryNode<Integer> root) {
        return isValidBalancedBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root).result;

    }

    // #StaticFunctionAccessingInnerClass
    public static Result isValidBalancedBST(Integer minValue, Integer maxValue, BinaryNode<Integer> node) {
        if (node == null) {
            return (new BinaryTree()).new Result(0, true);
        }
        if ((node.val == Integer.MIN_VALUE || node.val.compareTo(minValue) > 0) && node.val.compareTo(maxValue) <= 0) {
            return (new BinaryTree()).new Result(0, false); // in case of false the height doesn't matter
        }
        Result right = isValidBalancedBST(node.val, maxValue, node.right);
        Result left = isValidBalancedBST(node.val, maxValue, node.right);

        if (!right.result || !left.result || Math.abs(left.height - right.height) > 1) {
            (new BinaryTree()).new Result(0, false); // in case of false the height doesn't matter
        }
        return (new BinaryTree()).new Result(Math.max(left.height, right.height) + 1, true);
    }

    /**************/
    /************************************************/
    /*
     * ##InorderTraversal - Left Mid Right ##Medium In order means the order in which you see the nodes if you were
     * looking from the bottom of the tree (left to right) In this method we use in order traversal and don't rely on
     * Integer.MIN_VALUE and Integer.MAX_VALUE Algorithm:- start from the left most node - the next node should be
     * greater than this node and so on. (i.e in order traversal where next Node > prev Node)
     */
    public static boolean isValidBST_1(BinaryNode<Integer> node) {
        prev = null;
        return isValidBST_1_helper(node);
    }

    // prev --> largest node lesser than the current node
    private static BinaryNode<Integer> prev = null;

    public static boolean isValidBST_1_helper(BinaryNode<Integer> node) {
        if (node == null) {
            return true;
        }
        if (!isValidBST_1_helper(node.left)) {
            return false;
        }
        if (prev != null && prev.val.compareTo(node.val) > 0) {
            return false;
        }
        prev = node;
        return isValidBST_1_helper(node.right);
    }

    /************************************************/
    /*
     * Assuming Balanced Binary Tree -- adding null to make it balanced
     */
    public static <T> BinaryNode<T> convertListToBST(List<T> list) {
        return convertListToBST(list, 0, list.size());
    }

    /*
     * ##PostOrderTraversal:- left right root
     */
    private static <T> BinaryNode<T> convertListToBST(List<T> list, int min, int max) {
        int midPoint = (max + min) / 2; // min + (max - min)/2
        if (min >= max || list.get(midPoint) == null) {
            return null;
        }
        BinaryNode<T> root = new BinaryNode<T>(list.get(midPoint));
        root.left = convertListToBST(list, min, midPoint);
        root.right = convertListToBST(list, midPoint + 1, max);
        return root;
    }

    /************************************************/
    /*
     * Assuming Balanced Binary Tree -- adding null to make it balanced
     */
    public static <T> List<T> convertBSTToList(BinaryNode<T> root) {
        List<T> arrayList = new ArrayList<T>();
        convertBSTToList(root, arrayList);
        return arrayList;
    }

    /*
     * ##PostOrderTraversal:- left right root
     */
    private static <T> void convertBSTToList(BinaryNode<T> root, List<T> arrayList) {
        if (root == null) {
            arrayList.add(null);
            return;
        }
        convertBSTToList(root.left, arrayList);
        arrayList.add(root.val);
        convertBSTToList(root.right, arrayList);
    }
    /************************************************/
}
