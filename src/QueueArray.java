
class QueueArray<Item> {
  private final int initial_size = 4;
  private int size = 0; //the start?
  private Item[] arr;
  //i added these
  private int front = -1;
  private int back = -1; //do we need a back or just use size() for this??
  
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
	    q.enqueue(5);
	    q.enqueue(5);
	    q.enqueue(5);
	   // q.enqueue(5);
	    //System.out.println(q.getFront());
	   // q.dequeue();
	   // q.enqueue(2);
	   // System.out.println(q.getFront());
	   System.out.println(q.toString());
	  }

  public int size() {
    return size;
  }

  public void resize() {
	  //need to cast the object as an item to be able to do this
	  Item[] temp = (Item [])new Object[initial_size*2]; //why cant we just use ints lol
	  System.out.println("in resize");
	  for(int i = 0; i < size; i++) {
		  temp[i] = arr[(front + i) % size()];
	  }
	  
	  arr = temp;
	  front = 0;
	  back = size(); //dont need i think
	  
  }
  
  public void enqueue(Item x) {
	 System.out.println("back before adding new"+back);
	  if(initial_size == size) { //??
		  System.out.println("entered resize");
		  resize();
	  }
	  if(front == -1) front = 0; //change this maybe
	  back++;
	  arr[back] = x;
	  size++;
	  System.out.println("back after adding new" + back);
 //   throw new UnsupportedOperationException();
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
}
