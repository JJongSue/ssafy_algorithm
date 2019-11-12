package algo;

public class 스택 {
	static class Stack implements stk{
		static final int STACK_SIZE = 10;
		static int stk[] = new int[STACK_SIZE];
		static int top = -1;
		
		
		@Override
		public void push(int value) {
			if(top == STACK_SIZE-1) {
				System.out.println("stack is full");
				return;
			}
			stk[++top]=value;
		}
		@Override
		public int top() {
			if(empty()) {
				return -1;
			}
			return stk[top];
		}
		@Override
		public int pop() {
			if(empty()) return -1;
			return stk[top--];
		}
		@Override
		public boolean empty() {
			if(top == -1) return true;
			return false;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Stack p = new Stack();
		for (int i = 0; i < 11; i++) {
			p.push(i);
		}

		System.out.println("top() 수행 : " + p.top());
		
		while (!p.empty()) {
			int value = p.pop();
			System.out.println(value);
		} 
		// stack empty
		p.pop();
	}

}
