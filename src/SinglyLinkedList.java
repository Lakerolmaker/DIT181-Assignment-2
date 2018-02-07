
class SinglyLinkedList<Item> {
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
  //  if (...)
  //    throw new IllegalArgumentException("Index ouf of bounds");
    throw new UnsupportedOperationException();
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {
  //  if (...)
  //    throw new IllegalArgumentException("Index ouf of bounds");
    throw new UnsupportedOperationException();
  }

  // Remove the element at index n from the list
  public void removeAt(int n) {
  //  if (...)
  //    throw new IllegalArgumentException("Index ouf of bounds");
    throw new UnsupportedOperationException();
  }

  // Reverse the list
  public void reverse() {
  //  if (...)
  //    throw new IllegalArgumentException("Queue size must be non-negative");
    throw new UnsupportedOperationException();
  }

  public Iterator<Item> first() {
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


  public static void main (String[] args) {
    SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
    System.out.println(l.size());
  }
}
