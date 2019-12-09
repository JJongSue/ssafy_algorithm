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
			
			pq[tmp+1] = input;
			while(tmp != 0) {
				if(pq[tmp] > pq[(tmp-1)/2]) {
					int pqtmp = pq[tmp];
					pq[tmp] = pq[(tmp-1)/2];
					pq[(tmp-1)/2] = pqtmp;
					tmp = (tmp-1)/2;
				}else return;
			}
			
		}else {
			System.out.println("pq is full");
		}
	}
	public int poll() {
		int r = pq[0];
		pq[0] = pq[now-1];
		
		
		
		return r;
	}
	
	
	
}
