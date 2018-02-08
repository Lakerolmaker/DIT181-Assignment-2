import java.util.Stack;
import java.util.Scanner;

class RPN {
  private Stack<Integer> operands = new Stack<Integer>();

  public RPN() {
  }


  public void loop() {
	  
    Scanner in = new Scanner(System.in);

    final String prompt = "> ";
    System.out.print(prompt);

    while(in.hasNext()){
      if(in.hasNextInt()) {
        int x = in.nextInt();
        operands.push(x);
       
       print();
     
      } else {
        String s=in.next();
        if(s.equals("quit")) {
          System.out.println("Quitting");
          break;
        }
        
        if(s.equals("+")) {
        	
        		int a = operands.pop();
        
        		int b = operands.pop();
        
        		int result = b + a;
      
        		operands.push(result);
       
        		print();

        	}else if(s.equals("-")) {
        	
        		int a = operands.pop();
        
        		int b = operands.pop();
        
        		int result = b - a;
      
        		operands.push(result);
       
        		print();

        	}else if(s.equals("*")) {
        	
        		int a = operands.pop();
        
        		int b = operands.pop();
        
        		int result = b * a;
      
        		operands.push(result);
       
        		print();

        	}else if(s.equals("/")) {
        	
        		int a = operands.pop();
        
        		int b = operands.pop();
        
        		int result = b / a;
      
        		operands.push(result);
       
        		print();

        	}
        
      }
     
      System.out.print(prompt);
    }
    
  }

  
    public void print() {
  	  
    	 String result = "";
    	
  	  for(int i = 0; i < operands.size(); i++) {
  		result +=  operands.get(i) + " ";
  	  }
  	  
  	  System.out.println(result);
  	  
    }
    
  public static void main (String[] args) {
    RPN calc = new RPN();
    calc.loop();
  }
  
  
  
}
