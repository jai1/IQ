package org.interview.questions;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.interview.questions.ConvertListToTree.ExtendedTreeNode;
import org.utils.TreeNode;

/*
 * ##hard ##Yahoo ##ComplexDataStructure
 * 1) create tree from input value. 
 *             [ parent, child]
 * Input :- [[ 10, 5],
 *              [15, 9],
 *               [2, 6],
 *               [10, 2],
 *                [10, 15],
 *                [2, 4],
 *                [15, 8], 
 *                [4, 1]]
 * Output:- 
 * 
 *                     10
 *                 /    |    \
 *               2      5     15     
 *             /   \         /   \
 *           4      6       9     8
 *          /
 *        1
 * 
 */
public class ConvertListToTree<T> {
    public class ExtendedTreeNode extends TreeNode<T> {
        public ExtendedTreeNode(T t) {
            super(t);
        }

        public ExtendedTreeNode(HashSet<TreeNode<T>> hashSet, T p) {
            super(hashSet, p);
        }

        public boolean isRoot = true;
    }
    
    public TreeNode<T> convertToTree(List<List<T>> parentChildList) {
        // Such complex Data structure since neither HashMap nor HashSet has a getKey function.
        HashMap<T, ExtendedTreeNode> nodes = new HashMap<T, ExtendedTreeNode>();
        for (List<T> parentChild : parentChildList) {
            assert(parentChild.size() == 2);
            T p = parentChild.get(0);
            T c = parentChild.get(1);

            // Two steps since putIfAbsent returns null if value was not initially present there.
            nodes.putIfAbsent(p, new ExtendedTreeNode(new HashSet<TreeNode<T>>(), p));
            ExtendedTreeNode parent = nodes.get(p);
            
            nodes.putIfAbsent(c, new ExtendedTreeNode(new HashSet<TreeNode<T>>(), c));
            ExtendedTreeNode child = nodes.get(c);
            child.isRoot = false;
            parent.children.add(child);
        }
        return findRoot(nodes);
    }

    private TreeNode<T> findRoot(HashMap<T, ExtendedTreeNode> nodes) {
        for (Entry<T, ExtendedTreeNode> e : nodes.entrySet()) {
            if (e.getValue().isRoot) {
                return e.getValue();
            }
        }
        return null;
    }
}
