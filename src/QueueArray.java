
class QueueArray<Item> {
  private final int initial_size = 4;
  private int size = 0; //the start? //probably the length of existing elements
  private Item[] arr;
  //i added these
  private int front = 0;
  private int back = -1; //do we need a back or just use size() for this?? 
  //we need a back because to know the size we have to know where it ends first 
  //bruh you payin attention in class right
  
  // We need this pragma to avoid warnings triggerred by
  // the unsafe cast to Item[].
  @SuppressWarnings("unchecked")
  	public QueueArray() {
	  arr = (Item [])new Object[initial_size];
  
  }

  public int size() {
    return size;
  }

  public void resize() {
	  //need to cast the object as an item to be able to do this
	  Item[] temp = (Item [])new Object[initial_size * 2]; 
	  //why cant we just use ints lol
	  
	  System.out.println("resizing");
	  //for the total amount of elements
	  //
	  for(int i = 0; i < size; i++) {
		  temp[i] = arr[(front + i) % size()];
	  }
	  
	  arr = temp;
	  front = 0;
	  back = size(); //dont need i think
	  
  }
  
  public void enqueue(Item x) {
	 System.out.println("back before adding: " + back);
	  if(size == arr.length) { //if the array is full resize
		  System.out.println("array full, resizing");
		  resize();
		  //add the item
		  back++;
		  arr[back] = x;
		  size++;
	  }
	  if(size() < arr.length) {
//		  front = 0; //change this maybe
	  		back++;
	  		arr[back] = x;//put new element in after incrementing bacc
	  		size++;
	  		System.out.println("back after adding: " + back);
	  }
 //   throw new UnsupportedOperationException();
  }

  public void dequeue() {
    if (size == 0) {
    	 throw new IllegalArgumentException("Queue size must be non-negative");
    }
    else {
    	System.out.println("front before: " + front );
    	front++;
    	size--;
    	System.out.println("front after: " + front);
    }
//    throw new UnsupportedOperationException();
  }

  public Item getFront() {
    if (size == 0) {
    	 throw new IllegalArgumentException("Queue size must be non-negative");
    }
    
    throw new UnsupportedOperationException();
  }

  // Represent the contents of the list as a String
 
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(arr[front].toString());
      for (int i = 1; i < size; ++i) {
        res.append(", ");
        res.append(arr[i].toString());
      }
    }
    res.append("}");
    return res.toString();
  }
  
  public void printArr() {
	  System.out.print("{");
	  for (int i = 0; i < arr.length; i++) {
		  System.out.print(arr[i] + " ");
	  }
	  System.out.print("}");
	  System.out.println();
  }
  public static void main (String[] args) {
	    QueueArray<Integer> q = new QueueArray<Integer>();
	    q.printArr();
	    System.out.println(q.toString());
	    q.enqueue(4);
	    System.out.println(q.toString());
	    q.enqueue(5);
	    System.out.println(q.toString());
	    q.enqueue(5);
	    System.out.println(q.toString());
	    
	    q.dequeue();
	    System.out.println(q.toString());
	    q.dequeue();
	    System.out.println(q.toString());
	    q.dequeue();
	    System.out.println(q.toString());
	    q.printArr();
	    
	    q.enqueue(5);
	    System.out.println(q.toString());
	    q.printArr();
//	    q.enqueue(5);
//	    System.out.println(q.toString());
	   // q.enqueue(5);
	    //System.out.println(q.getFront());
	   // q.dequeue();
	   // q.enqueue(2);
	   // System.out.println(q.getFront());
	   System.out.println(q.toString());
	 }
}
