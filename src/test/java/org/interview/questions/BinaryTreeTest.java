package org.interview.questions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.utils.BinaryNode;

public class BinaryTreeTest {

    @Test
    public void convertListToBST_1() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(5);
                add(5);
                add(null);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertEquals(root.val, new Integer(4));

        assertEquals(root.left.val, new Integer(2));
        assertEquals(root.right.val, new Integer(5));

        assertEquals(root.left.left.val, new Integer(1));
        assertEquals(root.left.right, null);

        assertEquals(root.left.left.left, null);

        assertEquals(root.right.left.val, new Integer(5));
        assertEquals(root.right.right, null);

        assertEquals(root.right.left.left, null);
        assertEquals(root.right.left.right, null);
    }

    @Test
    public void convertListToBST_2() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(5);
                add(5);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertEquals(root.val, new Integer(4));

        assertEquals(root.left.val, new Integer(2));
        assertEquals(root.right.val, new Integer(5));

        assertEquals(root.left.left.val, new Integer(1));
        assertEquals(root.left.right, null);

        assertEquals(root.left.left.left, null);

        assertEquals(root.right.left.val, new Integer(5));
        assertEquals(root.right.right, null);

        assertEquals(root.right.left.left, null);
        assertEquals(root.right.left.right, null);
    }

    @Test
    public void convertBSTToList_1() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(5);
                add(5);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        List<Integer> result = BinaryTree.convertBSTToList(root);
        assertEquals(result, new ArrayList<Integer>() {
            {
                add(null);
                add(1);
                add(null);
                add(2);
                add(null);
                add(4);
                add(null);
                add(5);
                add(null);
                add(5);
                add(null);
            }
        });
    }

    @Test
    public void isvalidBST_1() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(5);
                add(5);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertTrue(BinaryTree.isValidBST(root));
        assertTrue(BinaryTree.isValidBST_1(root));
    }

    @Test
    public void isvalidBST_2() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(5);
                add(6);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertTrue(BinaryTree.isValidBST(root));
        assertTrue(BinaryTree.isValidBST_1(root));
    }

    @Test
    public void isvalidBST_3() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(6);
                add(5);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertFalse(BinaryTree.isValidBST(root));
        assertFalse(BinaryTree.isValidBST_1(root));
    }

    public void isvalidBalancedBST_1() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(null);
                add(4);
                add(6);
                add(5);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertTrue(BinaryTree.isValidBalancedBST(root));
    }

    public void isvalidBalancedBST_2() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(null);
                add(null);
                add(null);
                add(4);
                add(6);
                add(5);
            }
        };
        BinaryNode<Integer> root = BinaryTree.convertListToBST(list);
        assertFalse(BinaryTree.isValidBalancedBST(root));
    }
}
