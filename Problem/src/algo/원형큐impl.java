package algo;

public class 원형큐impl {
	static class 큐 implements 원형큐{
		static final int MAX_N = 10;
		static int front=0;
		static int rear=0;
		static int queue[] = new int[MAX_N];
		

		@Override
		public boolean queueIsEmpty() {
			return (front==rear);
		}

		@Override
		public boolean queueIsFull() {
			
			return (((rear+1)%MAX_N)==front);
		}

		@Override
		public boolean queueEnqueue(int value) {
			if(queueIsFull()) return false;
			queue[rear] = value;
			rear = (rear+1)%MAX_N;
			return true;
		}

		@Override
		public Integer queueDequeue() {
			if(queueIsEmpty()) return -1;
			int ret = queue[front];
			front = (front+1)%MAX_N;
			return ret;
		}
		
	}
	
	
	
	public static void main(String arg[]) throws Exception {
		큐 q = new 큐();
		
		for (int i = 0; i < 10; i++) {
			q.queueEnqueue(i);
		}

		while (!q.queueIsEmpty()) {
			Integer value = q.queueDequeue();
			if (value != -1) {
				System.out.print(value.intValue() + " ");
			}
		}
		
		System.out.println();
	}

}
