
class SinglyLinkedList<Item> implements MyStack<Item> {
	private int size = 0;
	private Node<Item> first;

	private static class Node<Item> {
		public Node<Item> next;
		public Item el;
	}
	
	public Node<Item> getFirstNode(){
		return first;
	}

	public static class Iterator<Item> {
		private Node<Item> previousprevNode; //LUL I DONT KNOW HOW TO DO REMOVE IF I DONT DO THIS
		  private Node<Item> prevNode; //previous node
		  private Node<Item> currentNode; 
		  private boolean removeTriggered;
		  
		  private SinglyLinkedList<Item> list;
		  
		  public Iterator(SinglyLinkedList<Item> list) {
			  this.list = list;
			  currentNode = list.first;
			  prevNode = null;
			  previousprevNode = null;
			  removeTriggered = false;
		  }
	/*	  public Iterator(Node<Item> anyNode, SinglyLinkedList<Item> list) {
			  //problem with this is that there will be no prevnode and previousprev at the start.
			  currentNode = anyNode;
			  this.list = list;
		  }
	*/	  
		public Item next() {
			//returns next item in collection
    		if(hasNext() == true) {	
    			previousprevNode = prevNode;
    			prevNode = currentNode; 		// advance prevnode to current
    			currentNode = currentNode.next; // advance currentnode to nextnode
    			removeTriggered = false;
    			return prevNode.el; 			// return the now advanced prev node
    			}
    		else {
    			throw new UnsupportedOperationException();
    		}
		}

		public boolean hasNext() {
			if(currentNode != null) {	return true; }
	    	if(currentNode == null) {	return false;}
	    	else { throw new UnsupportedOperationException(); }
		}

		public void insert(Item e) {
			Node<Item> newNode = new Node<Item>();
	    	newNode.el = e;
	    	if(prevNode != null) {
	    		prevNode = previousprevNode;	//push prevnode 1 step back aka make a free space
	    		previousprevNode.next = newNode;//point that node to the new node
	    		newNode.next = currentNode;		//point the newnode to the current node
	    	}
	    	if(prevNode == null) {
	    		prevNode = newNode;
	    		newNode.next = currentNode;
	    	}
	    	if(currentNode == null) {
	    		throw new UnsupportedOperationException();
	    	}
	    }

		public void remove() {
			if(prevNode == null || removeTriggered == false) { //cannot delete when current is at first
				 throw new IllegalStateException();
			}
	    	if(previousprevNode == null) {
				currentNode = list.first;
			}
	    	if (prevNode != null && previousprevNode != null) {	// in the middle
				previousprevNode.next = currentNode; 			//connect the previousPrev to current, passing prev.
			}													//same as word processor when backspacing
			list.size--;										//reduce size
			removeTriggered = true;
		}
	}

	public SinglyLinkedList() {
	}

	public int size() {
		return size;
	}

	public Item get(int n) {

		Node finder = first;
		

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

		SinglyLinkedList<Item> newList = new SinglyLinkedList<Item>();
		
		for(int i = 0; i < n; i++) {
			newList.push(this.get(i));
		}
		
		newList.push(x);
		
		for(int i = n ; i < size; i++) {
			newList.push(this.get(i));
		}
		
		first =  newList.getFirstNode();
		
		size++;
		
		this.reverse();
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

		SinglyLinkedList<Item> l = new SinglyLinkedList<Item>();
		
		for(int i = 0; i < size; i++) {
			l.push(this.get(i));
		}
				
		first =  l.getFirstNode();
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

		l.push(6);
		l.push(5);
		l.push(3);
		l.push(2);
		l.push(1);
		
		l.insertAt(3, 4);
		
//		l.print();
		Iterator<Integer> iterator = new Iterator<>(l);
		
//		System.out.println("current: " + iterator.currentNode.el);
//		System.out.println("prevprev: " + iterator.previousprevNode.el);
//		System.out.println("prev: " + iterator.prevNode.el);
		
		for ( ; iterator.hasNext() == true; iterator.next()) {
			if(iterator.previousprevNode != null) {
				System.out.println("prevprev: " + iterator.previousprevNode.el);
			}
			if(iterator.prevNode != null) {
				System.out.println("prev: " + iterator.prevNode.el);
			}
			System.out.println("current: " + iterator.currentNode.el);
			System.out.println();
		}
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
	public Item pop() {
		if(!isEmpty()) {
			first = first.next;
			return first.el;
		}else {
			return null;
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
	public Item top() {
		return first.el;
	}

	@Override
	public Item topNPop() {
		if(!isEmpty()) {
			Node<Item> oldFirst = first; 
			first = first.next;
			return oldFirst.el;
		}else {
			return null;
		}		
	}

	public void print() {
		for(int i = 0 ; i < size; i++) {
			System.out.println(get(i));
		}
	}
	
}
