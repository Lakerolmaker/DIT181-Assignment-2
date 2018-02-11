class SinglyLinkedList<Item> {
  private int size = 0;
  private Node<Item> first;
//the first node is created

  private static class Node<Item> implements MyStack{
    public Node<Item> next;
    public Item el;
//the next node is created

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
  
////////////////////Iterator////////////////////////
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
    	if(currentNode.next != null) {	return true; }
    	if(currentNode.next == null) {	return false;}
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
    
    public Item retrieve() {
    	if (currentNode != null) {
    		return currentNode.el;
    	}
    	else { throw new UnsupportedOperationException(); }
    }
  }
  
  public SinglyLinkedList() {
	  first = null;
  }

  public int size() {
    return size;
  }

  public Item get(int n) {
  //complexity = O(n)
	  if (n > size() || n < 0 ) {
		  throw new IllegalArgumentException("Index ouf of bounds");
	  }

	Node<Item> finder = first.next;

	for(int i = 0; i < n + 1; i++) {
		//this assumes that we do not know the length of the list, but we know size...
		if(finder != null) {
			finder =  finder.next;
		}else {
			throw new IllegalArgumentException("Index ouf of bounds");
		}
		
	}
	  return (Item) finder.el;
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {

	  Node finder = first.next;
	  
	  Node newNode = new Node<Item>();
	  newNode.el = x;
	  newNode.next = finder;
	  finder.next = newNode;
		
  
  }

  // Remove the element at index n from the list
  public void removeAt(int n) {
	  if(n > size || n < 1) {
		  throw new IllegalArgumentException("Index Out of bounds");
	  }
	  if (first != null) {
		  
	  }
  //    throw new IllegalArgumentException("Index ouf of bounds");
    throw new UnsupportedOperationException();
  }

  // Reverse the list
  public void reverse() {
	 
	  Node<Item> storage = first;
	  int index = 0;
	  
	  for(int i = 0 ;  i < size - 1; i++) {
  
		  	Node<Item> finder = storage;
		  	Node<Item> checker = storage;

			for(int z = 0; z < size; z++) {
				
				checker =  finder.next;
				
				if(checker != null) {
					finder =  finder.next;
				}else {
					break;
				}
			}
			  
		  this.insertAt(index, finder.el);
		  index++;
	  }
	  
	  
  }
  
  public void printList (SinglyLinkedList<Item> list) {
	  Iterator<Item> iterator = list.first();
	  for(; iterator.hasNext(); iterator.next()) {
		  System.out.print(" " + iterator.currentNode.el);
	  }
	  System.out.println();
  }

  public Iterator<Item> first() {
//returns the first node, but in the book first() returns the first node in the list as well but is only for empty lists. Like a dud.
	  Iterator<Item> itr = new Iterator<>(this);
	  if(first == null) { throw new UnsupportedOperationException(); }
	  return itr;
  }

  // Represent the contents of the list as a String
  /*
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(firstEl.toString());
      for (int i = 1; i < size; ++i) {
        res.append(", ");
        res.append(el.toString());
      }
    }
    res.append("}");
    return res.toString();
  }*/


  public static void main (String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
    System.out.println(list.size());
    list.get(0);
    
    
  }
}
