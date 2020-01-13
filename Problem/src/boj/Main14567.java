package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14567 {
	static int cnt[], ans[];
	static int N, M;
	static ArrayList al[];
	//static boolean is_visit[];
	
	static class ArrayList{
		int size;
		int list[];
		public ArrayList(int size) {
			list = new int[size];
			this.size = 0;
		}
		
		void add(int x) {
			list[size++] = x;
		}
	}
	static class Queue{
		int size;
		int now;
		int q[];
		public Queue() {
			size = 0;
			now = 0;
			q = new int[1001];
		}
		void add(int x) {
			q[size++] = x;
		}
		int poll() {
			return q[now++];
		}
		boolean is_empty() {
			if(now == size) return true;
			return false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cnt = new int[N+1];
		ans = new int[N+1];
		al = new ArrayList[N+1];
		Queue q = new Queue();
		for(int i=1;i<=N;i++) al[i] = new ArrayList(N);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			cnt[tmp2]++;
			al[tmp1].add(tmp2);
			
			
			
		}
		for(int i=1;i<=N;i++) if(cnt[i]==0) q.add(i);
		int nums = 1;
		while(!q.is_empty()) {
			int size = q.size - q.now;
			for(int s=0;s<size;s++) {
				int now = q.poll();
				//System.out.println(now);
				ans[now] = nums;
				for(int i=0;i<al[now].size;i++) {
					int go = al[now].list[i];
					cnt[go]--;
					if(cnt[go] == 0) q.add(go);
				}
				
			}
			nums++;
		}
		for(int i=1;i<=N;i++) {
			System.out.print(ans[i]+" ");
		}
		
		
	}
}
