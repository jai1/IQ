package org.utils;

import java.util.HashSet;

import com.sun.org.apache.xpath.internal.axes.NodeSequence;

public class TreeNode<T> {
    public T val;
    public HashSet<TreeNode<T>> children = null;
    
    public TreeNode(HashSet<TreeNode<T>> n, T val) {
        this.children = n;
        this.val = val;
    }

    public TreeNode(T val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        return val.hashCode();
    }
    
    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {
    
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
    
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Node)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        TreeNode<T> c = (TreeNode<T>) o;
         
        // Compare the data members and return accordingly 
        return val.equals(c.val);
    }
    
    public TreeNode() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("{ Val : " + val + ", ");
        buff.append("Children : [");
        int i = 0;
        for (TreeNode<T> node : children) {
            buff.append(node);
            if (++i < children.size()) {
                buff.append(", ");
            }
        }
        buff.append("] }");
        return buff.toString();
    }
    
    
}
