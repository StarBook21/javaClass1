public class BalancedParentheses{
	public static void main(String [] args) {
		System.out.println(parenthesesBalanced("(())"));
	}
	public static boolean parenthesesBalanced(String input) {
		Stack<Character> blue = new Stack<Character>();

		for(int i = 0; i < input.length(); i++ ) {
			if(input.charAt(i) == '(') blue.push('(');
			try {
				if(input.charAt(i) == ')') blue.pop();
			}
			catch(Exception e) {
				return false;
			}
		}
		if(blue.size() > 0) return false;
		return true;
	}
}
class Stack<T> {
	   private LinkedList<T> data;

	   public Stack() {
	      data = new LinkedList<T>();
	   }

	   public T pop() throws Exception {
	      return data.removeHead();
	   }

	   public void push(T x) {
	      data.addHead(x);
	   }
	   public int size() {
		   return data.size();
	   }
	}
class LinkedList<T> {
	   // instance variables
	   private Node<T> head, tail;
	   private int size;

	   // constructor
	   public LinkedList() {
	      head = tail = null;
	      size = 0;
	   }

	   // utility methods

	   public int size() {
	      return size;
	   }

	   public boolean isEmpty() {
	      return size == 0;
	   }

	   // methods to change the list

	   public void addHead(T d) {
	      Node<T> n = new Node<T>(d, head);
	      head = n;
	      size++;
	      if (tail == null)
	         tail = head;
	   }

	   public void addTail(T d) {
	      Node<T> n = new Node<T>(d, null);
	      if (tail == null)
	         head = tail = n;
	      else {
	         tail.setNext(n);
	         tail = n;
	      }
	      size++;
	   }

	   public T removeHead() throws Exception {
	      if (head == null)
	         throw new Exception("Empty List");
	      Node<T> n = head;
	      head = head.getNext();
	      if (head == null)
	         tail = head;
	      size--;
	      return n.getData();
	   }

	   // LinkedList testing methods:

	   public String toString() {
	      String ans = "";
	      Node<T> n = head;
	      while (n != null) {
	         ans += n.getData();
	         ans += "-->";
	         n = n.getNext();
	      }
	      return ans;
	   }


	}
class Node<T> {
	   private T data;
	   private Node<T> next;

	   public Node() {
	      data = null;
	      next = null;
	   }

	   public Node(T d, Node<T> n) {
	      data = d;
	      next = n;
	   }

	   public T getData() {
	      return data;
	   }

	   public Node<T> getNext() {
	      return next;
	   }

	   public void setData(T d) {
	      data = d;
	   }

	   public void setNext(Node<T> n) {
	      next = n;
	   }

	}
