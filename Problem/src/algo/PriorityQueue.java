package algo;

public class PriorityQueue {
	int pq[];
	int now;
	public PriorityQueue() {
		pq = new int[1000];
		now = 0;
	}
	public void add(int input) {
		if(now<1000) {
			int tmp = now;
			
			pq[tmp] = input;
			while(tmp != 0) {
				if(pq[tmp] > pq[(tmp-1)/2]) {
					int pqtmp = pq[tmp];
					pq[tmp] = pq[(tmp-1)/2];
					pq[(tmp-1)/2] = pqtmp;
					tmp = (tmp-1)/2;
				}else break;
			}
			now++;
			
		}else {
			System.out.println("pq is full");
		}
	}
	public int poll() {
		if(now == 0) {
			System.out.println("is_empty");
			return -1;
		}
		int r = pq[0];
		pq[0] = pq[now-1];
		now--;
		int tmp = 0;
		while(tmp*2+1 < now) {
			if(pq[tmp*2+1]>pq[tmp]) {
				int change = pq[tmp];
				pq[tmp] = pq[tmp*2+1];
				pq[tmp*2+1] = change;
				tmp = tmp*2+1;
			}else break;
		}
		
		
		return r;
	}
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.add(1);
		pq.add(2);
		pq.add(3);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		pq.add(4);
		pq.add(2);
		pq.add(3);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
	
	
	
}
