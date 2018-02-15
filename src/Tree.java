import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	public int size(Node<Item> node) {
		if (node == null) {
			return 0;
		} else {
			int counter = 0;
			counter = 1 + size(node.left) + size(node.right);
//			System.out.println("size counter: " + counter);
			return counter;
		}
	}

	  // This method constructs the following
	  // example tree with 5 in the root:
	  //
	  //      __5__
	  //     /     \
	  //    /       \
	  //   1         8
	  //    \       / \
	  //     2     1   3
	  //          / \
	  //          5 7
	
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
		
		if((root == null ) || root.el ==  null) {
			throw new UnsupportedOperationException();
		}else {
			System.out.println(root.el);
			printDFSPPrinter(root.left);
			printDFSPPrinter(root.right);
		}
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
	static int Treeindex = 0;
	static ArrayList<Node<Integer>> TreeArr = new ArrayList<Node<Integer>>();
	public static Tree<Integer> BuildDFS(int[] arr) {

		for(int  i = 0 ; i < arr.length; i++) {
			Node<Integer> node  = new Node<Integer>();
			node.el = arr[i];
			TreeArr.add(node);
		}
		
		Tree<Integer> tree = new Tree<Integer>();

		tree.root = buildTree(0);

		return tree;
		
	}
	
	private static Node<Integer> buildTree(int index) {
		
		Node<Integer> temp = TreeArr.get(index);
		Treeindex++;
		
		try {
			
			if(TreeArr.get(index + 1).el == temp.el *  2) {
				temp.left = buildTree(index + 1);
				
			}
			
			if(temp.left.el.equals(TreeArr.get(Treeindex).el - 1)){
				temp.right = buildTree(Treeindex);
			}
			
		} catch (Exception e) {}

		return temp;
	}
	
	

	// Return the n-th element in DFS order.
	// Throw an exception if index out of range.
	public void nthDFS(int n) {
		if(n > size(root) || n < 1) {
			System.out.println("n larger than size");
			throw new UnsupportedOperationException();
		}
		else {
			Node<Item> foundNode = nthNodeDFS(root, n);
			if(foundNode == null || foundNode.el == null) {
				System.out.println("node not found");
			}
			System.out.println(foundNode.el);	
		}
	}
	
	public Node<Item> nthNodeDFS(Node root, int n) {
		Stack<Node> stacc = new Stack<Node>();
		int counter = 0;
		Node<Item> foundNode = null;
		stacc.add(root);
		while (stacc.isEmpty() == false) {
			Node xicc = stacc.pop();
			counter ++;
//			System.out.println(counter);
		
			if(xicc.right!=null && counter < n) { stacc.add(xicc.right); }
			if(xicc.left!=null && counter < n) { stacc.add(xicc.left); }	
			if(counter == n) { 
				foundNode = xicc;
				return foundNode;
			}
//			System.out.println();
		}
		return foundNode;
	}
	
	public void printDFSStack(Node root) {
		Stack<Node> stacc = new Stack<Node>();
		if(root == null) {
			System.out.println("root is null");
		}
		stacc.add(root);
		while (stacc.isEmpty() == false) {
			Node xicc = stacc.pop();
			System.out.print(xicc.el + " ");
			
			if(xicc.right!=null) { stacc.add(xicc.right); }
			if(xicc.left!=null) { stacc.add(xicc.left); }
		}
		System.out.println();
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
	public void removeBST(Item i) { //uses method: removeRecursively
		root = removeRecursively(root, i);
	//	throw new UnsupportedOperationException();
	}
	private Item minValue(Node node) { //recursive menthod to find the min element, keep calling the method until we hit null
		if(node.left == null) {
			return (Item)node.el;
		}
		return minValue(node.left); //if the min wasnt found yet, keep going down to the left to reach the smaller n smaller numbers
	}
	public Node<Item> removeRecursively(Node root, Item el2) { //uses method: minvalue
		if(root == null) {
			System.out.println("Binary search tree is empty...");
			return root;
		}
		//to do if tree isnt empty:
		if(el2 == root.el) { //when node to remove is found
			
			if(root.left == null && root.right == null) { //the item has no children
				root = null; //make the item null to delete it
			}else if (root.left != null && root.right != null) { //if the item has 2 children
				Item minimumRight = minValue(root.right);//find the smallest biggest element to replace the item with
				root.el = minimumRight; //set the place of the old item to the item found
				root.right = removeRecursively(root.right, minimumRight); //take care of the rest of the items
			}else { //else if there is only 1 child:
				Node nodeToDelete = root; //?? cuz its not rly root anymore, its the node of el2 (i should rename.. lol)
				if(root.left != null) { //??
					root = root.left;
				}else {
					root = root.right;
				}
				nodeToDelete = null;
			}
		}else if((int)el2 < (int)root.el) { //go down the tree in left or right depending on the item value
			root.left = removeRecursively(root.left, el2); //keep going down looking on left side, if item to remove is smaller than the item we compare to
		}else if((int)el2 > (int)root.el) {
			root.right = removeRecursively(root.right, el2); //keep going down looking on right side, if item we want to remove was bigger than the item we compare to
		}
		return root;
	}

	public static void main(String[] args) {
		//Tree<Integer> t = exampleTree();
		
		int arr[] = {1, 2, 4, 5, 3};
		Tree<Integer> tree = BuildDFS(arr);
		
		System.out.println("done");
	}

}
