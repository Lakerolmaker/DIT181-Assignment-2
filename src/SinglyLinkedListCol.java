import java.util.Collection;

class SinglyLinkedListCol<Item> {
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
		  
		  private SinglyLinkedListCol<Item> list;
		  
		  public Iterator(SinglyLinkedListCol<Item> list) {
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
	    		previousprevNode = prevNode;
	    		prevNode = newNode;	//push prevnode 1 step back aka make a free space
	    		previousprevNode.next = newNode;		//point that node to the new node
	    		newNode.next = currentNode;		//point the newnode to the current node
	    		list.size++;
	    	}
	    	if(prevNode == null && currentNode!= null) { //current = first
	    		prevNode = newNode;
	    		newNode.next = currentNode;
	    		list.first = newNode;
	    		list.size++;
	    	}
	    	if(currentNode == null) {
	    		currentNode = newNode;
	    		prevNode.next = newNode;
	    		newNode.next = null;
	    		list.size++;
	    	}
	    }

		public void remove() {
			if(prevNode == null) { //cannot delete when current is at first
				System.out.println("prevNode null");
				 throw new IllegalStateException();
			}
			if( removeTriggered == true) {
				System.out.println("trigger = true");
			}
	    	if(previousprevNode == null) { 						// second 
				list.first = currentNode;
			}
	    	if (prevNode != null && previousprevNode != null) {	// in the middle
				previousprevNode.next = currentNode; 			//connect the previousPrev to current, passing prev.
			}													//same as word processor when backspacing
			list.size--;										//reduce size
			removeTriggered = true;
		}
	}

	public SinglyLinkedListCol() {
	}

	public int size() {
		return size;
	}

	public Item get(int n) {

		Node<Item> finder = first;
		
		for (int i = 0; i < n; i++) {

			if (finder != null) {
				finder = finder.next;
			} else {
				throw new IllegalArgumentException("Index ouf of bounds");
			}
		}
		return finder.el;
	}
	public int[] toArray() {
		int[] array = new int[size];
		int element = 0;
		for(int i = 0 ; i < size; i++) {
			element = (int) get(i);
			array[i] = element;
		}
		return array;
	}
	
	public boolean isEmpty() {
		if (first == null) 	{ return true; }
		else 				{ return false; }
	}
	
	public boolean contains(Item item) {
		for(int i = 0 ; i < size; i++) {
			if (get(i).equals(item)) {
			return true;	
			}
		}
		return false;
	}
	
	public Iterator<Item> iterator() {
		Iterator<Item> itr = new Iterator<>(this);
		if(first == null) { throw new UnsupportedOperationException(); }
		return itr;
	}
	
	
	public boolean add(Item item) {
		if (first == null) {
			Node<Item> newNode = new Node<>();
			newNode.el = item;
			first = newNode;
			size++;
			return true;

		} else {
			Node<Item> newNode = first;
			while (newNode.next != null) {
				newNode = newNode.next;
			}
			Node<Item> newTail = new Node<Item>();
			newTail.el = item;
			newTail.next = null;
			newNode.next = newTail;
			size++;
			return true;
		}
	}
	
	public boolean remove(Item item) { // item is element
		if (first == null) {
			return false;
		}
		if (first.el.equals(item)) {
			first = first.next;
			return true;
		}
		Node<Item> chicken = first;
		Node<Item> duck = null;

		while (chicken != null && !chicken.el.equals(item)) { 
			duck = chicken;
			chicken = chicken.next;
		}

		if (chicken == null) { return false; }
		// delete cur node
		duck.next = chicken.next;
		size--;
		return true;
	}
	
	public void clear() {
		first = null;
	}
	
//	public boolean equals(Item item) {
//		
//	}

	// Insert element x at index n in the list
/*	public void insertAt(int n, Item x) {
		SinglyLinkedListCol<Item> newList = new SinglyLinkedListCol<Item>();
		
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
	
*/
	// Remove the element at index n from the list
/*	public void removeAt(int n) { //IDK IF IT WORKS OR NOT
		size--;
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
*/
	// Reverse the list
	public void reverse() {

		SinglyLinkedListCol<Item> l = new SinglyLinkedListCol<Item>();
		
		for(int i = 0; i < size; i++) {
			l.push(this.get(i));
		}
				
		first =  l.getFirstNode();
	}

/*	public Iterator<Item> first() {
		//returns the first node, but in the book first() returns the first node in the list as well but is only for empty lists. Like a dud.
		  Iterator<Item> itr = new Iterator<>(this);
		  if(first == null) { throw new UnsupportedOperationException(); }
		  return itr;
	}
*/
	// Represent the contents of the list as a String
	/*
	 * public String toString() { StringBuilder res = new StringBuilder("{"); if
	 * (size > 0) { res.append(firstEl.toString()); for (int i = 1; i < size; ++i) {
	 * res.append(", "); res.append(el.toString()); } } res.append("}"); return
	 * res.toString(); }
	 */

	public static void main(String[] args) {
		SinglyLinkedListCol<Integer> s = new SinglyLinkedListCol<Integer>();

//		 s.removeAt(0);
	 
//		 System.out.println(s.size);
		
		
		
		SinglyLinkedListCol<Integer> l = new SinglyLinkedListCol<Integer>();

		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		// l.removeAt(2);
		l.remove(3);
		l.print();
		l.remove(2);
		System.out.println();
		l.print();
		System.out.println(l.remove(9));
		
		System.out.println("size: " + l.size());
//		Iterator<Integer> iterator = new Iterator<>(l);
//		
////		System.out.println("current: " + iterator.currentNode.el);
////		System.out.println("prevprev: " + iterator.previousprevNode.el);
////		System.out.println("prev: " + iterator.prevNode.el);
//		
//		for ( ; iterator.hasNext() == true; iterator.next()) {
//			if(iterator.previousprevNode != null) {
//				System.out.println("prevprev: " + iterator.previousprevNode.el);
//			}
//			if(iterator.prevNode != null) {
//				System.out.println("prev: " + iterator.prevNode.el);
//			}
//			System.out.println("current: " + iterator.currentNode.el);
//			System.out.println(l.get(1));
//			System.out.println();
//		}
//		Iterator<Integer> itr2 = new Iterator<>(l);
//		
//		System.out.println(l.first.el);
//		System.out.println(itr2.currentNode);
//		System.out.println(itr2.currentNode.el);
//		for( ; itr2.hasNext() == true; itr2.next()) {
//			itr2.insert(999);
//		}
//		for ( ; iterator.hasNext() == true; iterator.next()) {
//			if(iterator.previousprevNode != null) {
//				System.out.println("prevprev: " + iterator.previousprevNode.el);
//			}
//			if(iterator.prevNode != null) {
//				System.out.println("prev: " + iterator.prevNode.el);
//			}
//			System.out.println("current: " + iterator.currentNode.el);
//			System.out.println();
//		}
//		System.out.println("size: " + l.size());
//		for(int x = 0; x < 14 ; x++) {
//			System.out.println(l.get(x));
//		}
//		
//		Iterator<Integer> itr3 = l.first();
//		for( ; itr3.hasNext() == true; itr3.next()) {
//			itr3.insert(10000);
//		}
//		for(int x = 0; x < 14 ; x++) {
//			System.out.println(l.get(x));
//		}
//		
		
		
	}
	
	//: Adds value to a new node at the top of the stack
	public void push(Item x) {
		Node newNode = new Node();
		newNode.el = x;
		
		newNode.next = first;
		first = newNode;
		size++;
	}
//
//	@Override
//	public Item pop() {
//		if(!isEmpty()) {
//			first = first.next;
//			return first.el;
//		}else {
//			return null;
//		}
//	}
//
//	@Override
//	public boolean isEmpty() { //idk if correct
//		if(first == null) {
//			return true;
//		}
//		else return false;
//	}
//
//	@Override
//	public void makeEmpty() { //idk if correct
//		first = null;
//	}
//
//	@Override
//	public Item top() {
//		return first.el;
//	}
//
//	@Override	
//	public Item topNPop() {
//		if(!isEmpty()) {
//			Node<Item> oldFirst = first; 
//			first = first.next;
//			return oldFirst.el;
//		}else {
//			return null;
//		}		
//	}

	public void print() {
		for(int i = 0 ; i < size; i++) {
			System.out.println(get(i));
		}
	}
	
}

