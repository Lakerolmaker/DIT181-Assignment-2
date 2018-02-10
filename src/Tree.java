
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
  //      __5__
  //     /     \
  //    /       \
  //   1         8
  //    \       / \
  //     2     1   3
  //          / \
  //          5 7
  public static Tree<Integer> exampleTree() {
    Node<Integer> t = new Node<Integer> ();
    t.el = 5;
    Node<Integer> t1 = new Node<Integer> ();
    t.left = t1;
    t1.el = 1;
    Node<Integer> t2 = new Node<Integer> ();
    t.right = t2;
    t2.el = 8;
    Node<Integer> t12 = new Node<Integer> ();
    t1.right = t12;
    t12.el = 2;
    Node<Integer> t21 = new Node<Integer> ();
    t2.left = t21;
    t21.el = 1;
    Node<Integer> t22 = new Node<Integer> ();
    t2.right = t22;
    t22.el = 3;
    Node<Integer> t211 = new Node<Integer> ();
    t21.left = t211;
    t211.el = 5;
    Node<Integer> t212 = new Node<Integer> ();
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
    // Use Sytem.out.println() and el.toString() to print the elements
    throw new UnsupportedOperationException();
  }

  // Here is how to create a generic static method
  //private static <Item> int doSomething(Node<Item> n) {
  //}
  
  

  // Print the nodes of the tree in breadth-first order
  public void printBFS() { //lucas
    throw new UnsupportedOperationException();
  }

  // Insert i into a binary search tree
  public void insertBST(Item i) { //lucas
    throw new UnsupportedOperationException();
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

    System.out.println(t.size());
  }

}
