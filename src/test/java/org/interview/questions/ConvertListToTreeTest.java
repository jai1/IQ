package org.interview.questions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;
import org.utils.TreeNode;

import com.beust.jcommander.internal.Lists;

public class ConvertListToTreeTest {

    public ConvertListToTree obj = new ConvertListToTree<Integer>();
    
    @Test
    public void convertListToTreeTest_1() {
        List<List<Integer>> nodes = Lists.newArrayList();
        nodes.add(convertToList(10, 5));
        nodes.add(convertToList(15, 9));
        nodes.add(convertToList(2, 6));
        nodes.add(convertToList(10, 2));
        nodes.add(convertToList(10, 15));
        nodes.add(convertToList(2, 4));
        nodes.add(convertToList(15, 8));
        nodes.add(convertToList(4, 1));
        
        TreeNode root = obj.convertToTree(nodes);
        System.out.println("Root is " + root);
        assertEquals(root.val, 10);
    }
    
    @Test
    public void convertListToTreeTest_2() {
        List<List<Integer>> nodes = Lists.newArrayList();
        nodes.add(convertToList(15, 9));
        nodes.add(convertToList(2, 4));
        nodes.add(convertToList(15, 8));
        nodes.add(convertToList(4, 1));
        nodes.add(convertToList(10, 5));
        nodes.add(convertToList(2, 6));
        nodes.add(convertToList(10, 15));
        nodes.add(convertToList(10, 2));

        TreeNode root = obj.convertToTree(nodes);
        System.out.println("Root is " + root);
        assertEquals(root.val, 10);
    }

    private List<Integer> convertToList(Integer p, Integer c) {
        List<Integer> list = Lists.newArrayList();
        list.add(p);
        list.add(c);
        return list;
    }

}
