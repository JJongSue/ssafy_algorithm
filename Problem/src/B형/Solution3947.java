package B형;

public class Solution3947 {
	static int[] parents;
	
	static class road{
		int x;
		int y;
		int dis;
		public road(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}		
	}
	
	static int find_set(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		if(px != py) {
			parents[px] += parents[py];
			parents[py] = px;
		}
	}
	
	static class priorityQueue{
		road pq[];
		int now;
		public priorityQueue() {
			pq = new road[500000];
		}
		
		void add(road r) {
			pq[now] = r;
			int tmpnow = now;
			while(tmpnow!=0) {
				if(pq[(tmpnow-1)/2].dis > pq[tmpnow].dis ) {
					road tmp = pq[(tmpnow-1)/2];
					pq[(tmpnow-1)/2] = pq[tmpnow];
					pq[tmpnow] = tmp;
					
					tmpnow = (tmpnow-1)/2;
				}else break;
			}
			now++;
		}
		road poll() {
			road poll = pq[0];
			now--;
			pq[0] = pq[now];
			int tmpnow = 0;
			while(tmpnow*2+1<now) {
				int child = tmpnow*2+1;
				if(child+1 < now && pq[child].dis > pq[child+1].dis) {
					child++;
				}
				if(pq[child].dis < pq[tmpnow].dis) {
					road tmp = pq[child];
					pq[child] = pq[tmpnow];
					pq[tmpnow] = tmp;
					
					tmpnow = child;
				}
			}
			
			
			
			return poll;
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}
