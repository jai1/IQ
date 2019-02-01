package org.interview.questions;

/*
 * ##Company-Netflix
 * ##Easy 
 * 
 * Given an Binary Tree where child links to parent (usually its reverse). 
 * Find LCA in O(1) space complexity.
 */
public class LeastCommonAncestor<T extends Comparable<T>> {

	public class Node {
		T value;
		Node parent;
		public Node(T val, Node par) {
			value = val;
			parent = par;
		}
	}
	
	public static void main(String[] args) {
		LeastCommonAncestor<Integer> l = new LeastCommonAncestor();
		LeastCommonAncestor<Integer>.Node node1 = l.new Node(1, null);
		LeastCommonAncestor<Integer>.Node node2 = l.new Node(2, node1);
		LeastCommonAncestor<Integer>.Node node3 = l.new Node(3, node1);
		LeastCommonAncestor<Integer>.Node node4 = l.new Node(4, node2);
		LeastCommonAncestor<Integer>.Node node5 = l.new Node(5, node2);
		LeastCommonAncestor<Integer>.Node node9 = l.new Node(9, node5);
		LeastCommonAncestor<Integer>.Node node10 = l.new Node(10, node3);

		LeastCommonAncestor.Node n = l.getLCA(node4, node5);
		System.out.println("LCA is " + n.value);
		
		n = l.getLCA(node2, node10);
		System.out.println("LCA is " + n.value);
		
	}
	

	Node getLCA(Node n1, Node n2) {
		int steps1 = countStepsToRoot(n1);
		int steps2 = countStepsToRoot(n2);

//		System.out.println("Node n1 is " + n1.value);
//		System.out.println("Steps n1 is " + steps1);
//
//		System.out.println("Node n2 is " + n2.value);
//		System.out.println("Steps n2 is " + steps2);

		if (steps1 < steps2) {
			n2 = incrementBySteps(n2, steps2 - steps1);
		} else if(steps2 < steps1) {
			n1 = incrementBySteps(n1, steps1 - steps2);
		}
		return findLCA(n1, n2);
	}

	private int countStepsToRoot(Node n1) {
		if (n1 == null) {
			return 0;
		}
		return 1 + countStepsToRoot(n1.parent);
	}

	private Node findLCA(Node n1, Node n2) {
//		System.out.println("Node1 = " + n1.value);
//		System.out.println("Node2 = " + n2.value);
		if (n1 == n2) {
			return n1;
		}
		return findLCA(n1.parent, n2.parent);
	}

	private Node incrementBySteps(Node n1, int steps) {
		for (int i = 0; i < steps; i++) {
			n1 = n1.parent;
		}
		return n1;
	}
}
