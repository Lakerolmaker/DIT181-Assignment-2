
class SinglyLinkedList<Item> implements MyStack<Item> {
	private int size = 0;
	private Node<Item> first;

	private static class Node<Item> {
		public Node<Item> next;
		public Item el;
	}

	public static class Iterator<Item> {
		public Item next() {
			throw new UnsupportedOperationException();
		}

		public boolean hasNext() {
			throw new UnsupportedOperationException();
		}

		public void insert(Item e) {
			throw new UnsupportedOperationException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public SinglyLinkedList() {
	}

	public int size() {
		return size;
	}

	public Item get(int n) {

		Node finder = first.next;

		for (int i = 0; i < n; i++) {

			if (finder != null) {
				finder = finder.next;
			} else {
				throw new IllegalArgumentException("Index ouf of bounds");
			}

		}
		return (Item) finder.el;
	}

	// Insert element x at index n in the list
	public void insertAt(int n, Item x) {

		Node finder = first.next;

		for (int i = 0; i < n; i++) {

			if (finder != null) {
				finder = finder.next;
			} else {
				throw new IllegalArgumentException("Index ouf of bounds");
			}

		}

		Node newNode = new Node<Item>();
		newNode.el = x;

		newNode.next = finder;

		finder.next = newNode;

	}

	// Remove the element at index n from the list
	public void removeAt(int n) { //IDK IF IT WORKS OR NOT
		// n is the position in of the element we wanna delete
		Node finder = first;
		if (first == null) { // incase the list is empty
			throw new UnsupportedOperationException();
			//return;
		}else if(n == 0) {
			first = finder.next; //we just move the head if we r at first index
			return;
		}	
		for(int i = 0; i < n-1; i++) { //must also check until finder becomes null? maybe add finder!=null
			finder = finder.next;
		}

		if(finder.next == null || finder == null) {
			throw new IllegalArgumentException("Index ouf of bounds");
		}
		
		Node nextNode = finder.next.next;	
		finder.next = nextNode;

	}

	// Reverse the list
	public void reverse() {

		Node<Item> storage = first;
		int index = 0;

		for (int i = 0; i < size - 1; i++) {

			Node<Item> finder = storage;
			Node<Item> checker = storage;

			for (int z = 0; z < size; z++) {

				checker = finder.next;

				if (checker != null) {
					finder = finder.next;
				} else {
					break;
				}

			}

			this.insertAt(index, finder.el);
			index++;
		}

	}

	public Iterator<Item> first() {
		throw new UnsupportedOperationException();
	}

	// Represent the contents of the list as a String
	/*
	 * public String toString() { StringBuilder res = new StringBuilder("{"); if
	 * (size > 0) { res.append(firstEl.toString()); for (int i = 1; i < size; ++i) {
	 * res.append(", "); res.append(el.toString()); } } res.append("}"); return
	 * res.toString(); }
	 */

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		System.out.println(l.size());
		
		l.push(1);
		l.push(2);
		System.out.println("done");
	}

	@Override
	//: Adds value to a new node at the top of the stack
	public void push(Item x) {

		Node newNode = new Node();
		newNode.el = x;
		newNode.next = first;
		first = newNode;
		size++;
	}

	@Override
	public void pop() {
		if(!isEmpty()) {
			first = first.next;
		}
	}

	@Override
	public boolean isEmpty() { //idk if correct
		if(first == null) {
			return true;
		}
		else return false;
	}

	@Override
	public void makeEmpty() { //idk if correct
		first = null;
	}

	@Override
	public int top() {
		return (int)first.el;
	}

	@Override
	public int topNPop() {
		if(!isEmpty()) {
			Node<Item> oldFirst = first; 
			first = first.next;
			return (int)oldFirst.el;
		}else {
			return -1;
		}		
	}

}
