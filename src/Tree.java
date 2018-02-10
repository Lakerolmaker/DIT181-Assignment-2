import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

class Tree<Item extends Comparable<Item>> {
	// If the tree is empty, root is a null reference.
	protected Node<Item> root;

	// A node of a tree contains a label, and optionally
	// references to the roots of its left and right subtrees,
	// which might be null if the subtrees are empty.
	protected static class Node<Item> {
		public Node<Item> left;
		public Node<Item> right;
		public Item el;
	}

	public int size() {
		throw new UnsupportedOperationException();
	}

	// This method constructs the following
	// example tree with 5 in the root:
	//
	// __5__
	// / \
	// / \
	// 1 8
	// \ / \
	// 2 1 3
	// / \
	// 5 7
	public static Tree<Integer> exampleTree() {
		Node<Integer> t = new Node<Integer>();
		t.el = 5;
		Node<Integer> t1 = new Node<Integer>();
		t.left = t1;
		t1.el = 1;
		Node<Integer> t2 = new Node<Integer>();
		t.right = t2;
		t2.el = 8;
		Node<Integer> t12 = new Node<Integer>();
		t1.right = t12;
		t12.el = 2;
		Node<Integer> t21 = new Node<Integer>();
		t2.left = t21;
		t21.el = 1;
		Node<Integer> t22 = new Node<Integer>();
		t2.right = t22;
		t22.el = 3;
		Node<Integer> t211 = new Node<Integer>();
		t21.left = t211;
		t211.el = 5;
		Node<Integer> t212 = new Node<Integer>();
		t21.right = t212;
		t212.el = 7;

		Tree<Integer> res = new Tree<Integer>();
		res.root = t;
		return res;
	}

	// Return the height of the tree
	public int height() {
		throw new UnsupportedOperationException();
	}

	// Return the label of the leftmost node of a tree
	public Item leftMost() {
		throw new UnsupportedOperationException();
	}

	// Replace the tree with its mirror image
	public void mirror() {
		throw new UnsupportedOperationException();
	}

	// Print the nodes of the tree in depth-first order
	public void printDFS() {
		
		System.out.println(root.el);
		printDFSPPrinter(root.left);
		printDFSPPrinter(root.right);
		
	}
	
	private void printDFSPPrinter(Node node) {
		
			System.out.println(node.el);
		
			if(node.left != null) {
				printDFSPPrinter(node.left);
			}
			
			if(node.right != null) {
				printDFSPPrinter(node.right);
			}
			
	}
	


	// Here is how to create a generic static method
	// private static <Item> int doSomething(Node<Item> n) {
	// }

	// Print the nodes of the tree in breadth-first order
	public void printBFS() { // lucas. Method has O(n) complexity

		if(exampleTree() == null) { //I DONT KNOW IF THIS if statement IS CORRECT 
			throw new UnsupportedOperationException();
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) { // loop until queue is empty

			Node tempNode = queue.poll();
			System.out.println(tempNode.el);

			if(tempNode.left != null) { //go down the tree and insert left then right elements if it isnt null
				queue.add(tempNode.left);
			}
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	// Insert i into a binary search tree
	public void insertBST(Item i) { // lucas
		//we need to search for the place to put the new element,and insert it there
		//if new element is less than current nodes value, go to left subtree, else if its bigger go to right
		root = recursiveInsertion(root, i);
	//	throw new UnsupportedOperationException();
	}
	public Node recursiveInsertion(Node root, Item el2) {
		
		//Node root;
		if(root == null) { //incase tree is empty - not sure if correct
			root = new Node();
			root.el = el2;
			return root;
		}
		if((int)el2 <= (int)root.el) { //tree is not empty, so continue down tree, if element is less go left, if element is more go right
			//to allow duplicates we must have <= to here (or >= on the other one)
			root.left = recursiveInsertion(root.left, el2);
		}else if((int)el2 > (int)root.el) {
			root.right = recursiveInsertion(root.right, el2);
		}	
		return root;
	}

	// Print the nodes of the tree in breadth-first order
	public static <Item extends Comparable<Item>> Tree<Item> BuildDFS() {
		throw new UnsupportedOperationException();
	}

	// Return the n-th element in DFS order.
	// Throw an exception if index out of range.
	public void nthDFS(int n) {
		throw new UnsupportedOperationException();
	}

	// Check if the tree is a binary search tree
	public boolean isBST() {
		throw new UnsupportedOperationException();
	}

	// Check if item i exists in the binary search tree
	public boolean findBST(Item i) {
		throw new UnsupportedOperationException();
	}

	// Remove i from a binary search tree
	public void removeBST(Item i) {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		Tree<Integer> t = exampleTree();
		
		t.printDFS();
		System.out.println();
		t.insertBST(50);
		t.insertBST(4);

		System.out.println("------");
		t.printDFS();
	}

}
