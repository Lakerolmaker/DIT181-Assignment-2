
class SinglyLinkedList<Item> implements MyStack {
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
		
		l.insertAt(0,1);
		
	}

	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void top() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void topNPop() {
		// TODO Auto-generated method stub
		
	}
}
