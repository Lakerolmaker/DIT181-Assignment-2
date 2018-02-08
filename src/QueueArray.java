
class QueueArray<Item> {
  private final int initial_size = 4;
  private int size = 0; //the start?
  private Item[] arr;
  //i added these
  private int front = -1;
  private int back = -1;
  
  // We need this pragma to avoid warnings triggerred by
  // the unsafe cast to Item[].
  @SuppressWarnings("unchecked")
  
  public QueueArray() {
    arr = (Item [])new Object[initial_size];
  }
  public static void main (String[] args) {
	    QueueArray<Integer> q = new QueueArray<Integer>();
	    q.enqueue(4);
	    q.enqueue(5);
	    System.out.println(q.getFront());
	    q.dequeue();
	    q.enqueue(2);
	    System.out.println(q.getFront());
	  }

  public int size() {
    return size;
  }

  public void resize() {
	  //need to cast the object as an item to be able to do this
	  Item[] temp = (Item [])new Object[initial_size*2]; //why cant we just use ints lol
  
	  for(int i = 0; i < size; i++) {
		  temp[i] = arr[(front + i) % size];
	  }
	  
	  arr = temp;
	  front = 0;
	  
  }
  
  public void enqueue(Item x) {
	  if(size == 0) {
		  
	  }

    throw new UnsupportedOperationException();
  }

  public void dequeue() {
    if (size == 0) {
    	 throw new IllegalArgumentException("Queue size must be non-negative");
    }
  
    throw new UnsupportedOperationException();
  }

  public Item getFront() {
    if (size == 0) {
    	 throw new IllegalArgumentException("Queue size must be non-negative");
    }
     
    throw new UnsupportedOperationException();
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
}
