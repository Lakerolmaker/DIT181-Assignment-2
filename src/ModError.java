import java.util.List;
import java.util.LinkedList;

class ModError {
  public static void main(String[] args) {
    List<Integer> numbers = new LinkedList<Integer>();
    for(int i = 0; i < 100; ++i) numbers.add(i);

    for (Integer x : numbers) {
      if (x % 10 == 0)
        numbers.remove(x);
    }
  }
}
