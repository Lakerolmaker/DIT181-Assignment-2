
public interface MyStack<Item> {

	public void push(Item x);
	
	public Item pop();
	
	public boolean isEmpty();
	
	public void makeEmpty();
	
	public Item top();
	
	public Item topNPop(); 
	
}
