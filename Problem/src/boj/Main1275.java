package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1275 {
	static StringBuilder sb = new StringBuilder();
	
	static class index_tree{
		long t[];
		int h;
		int now;
		public index_tree() {
			t = new long[500_000];
			
		}
		public void set_h(int N) {
			for(h=1;h<N;h=(h<<1));
			h = (h<<1);
//			for(int i=0;i<h;i++) {
//				t[i] = Long.MAX_VALUE;
//			}
			now = h+1;
		}
		public void add(int x) {
			//t[now] = x;
			int tmp = now;
			while(tmp != 0) {
				t[tmp] += x;
				tmp = (tmp>>1);
			}
			now++;
		}
		public void change(int w, int x) {
			long cnum =  (x - t[h+w]);
			int tmp = w+h;
			while(tmp != 0) {
				t[tmp] += cnum;
				tmp = (tmp>>1);
			}
		}
		public void get_num(int l, int r) {
			l = l+h;
			r = r+h;
			long sum = 0;
			while(l <= r) {
				if( (l&1) == 1 ) {
					sum += t[l++];
				}
				if( (r&1) == 0) {
					sum += t[r--];
				}
				l = (l>>1);
				r = (r>>1);
			}
			sb.append(sum).append("\n");
		}
		 
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		index_tree it = new index_tree();
		it.set_h(N);
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) it.add(Integer.parseInt(st.nextToken()));
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(l < r) {
				it.get_num(l, r);
			}else {
				it.get_num(r, l);
			}
			it.change(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb);
		
		
		
		
	}
}
