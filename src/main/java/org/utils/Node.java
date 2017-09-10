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
        Node c = (Node) o;
         
        // Compare the data members and return accordingly 
        return val.equals(c.val);
    }
    
    public Node() {
        // TODO Auto-generated constructor stub
    }
}
