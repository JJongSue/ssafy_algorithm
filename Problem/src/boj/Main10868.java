package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10868 {
	static int N, M;
	static int tree[] = new int[1_000_001];
	static int height = 1, now = 1;
	static int ans_min, ans_max;
	static void set_h() {
		for(height=1;height<N;height=(height<<1));
		//height=(height>>1);
		now = height;
		height--;
	}
	static void add_tree(int input) {
		int tmpnow = now;
		tree[tmpnow] = input;
		
		tmpnow = (tmpnow>>1);
		while(tmpnow!=0) {
			if(tree[tmpnow] == 0) {
				tree[tmpnow] = input;
			}else {
				tree[tmpnow] = Math.min(input, tree[tmpnow]);
			}
			tmpnow = (tmpnow >> 1);
		}
		now++;
	}
	static void get_num(int l, int r) {
		ans_min = Integer.MAX_VALUE;
		ans_max = 1;
		
		int tmpl = l+height, tmpr=r+height;
		while(tmpl<=tmpr) {
			if(tmpl%2 == 1) {
				ans_min = Math.min(ans_min, tree[tmpl]);
				tmpl++;
			}
			if(tmpr%2 == 0) {
				ans_min = Math.min(ans_min, tree[tmpr]);
				tmpr--;
			}
			tmpl = (tmpl>>1);
			tmpr = (tmpr>>1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set_h();
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			add_tree(input);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(l>r) {
				get_num(r, l);
			}else {
				get_num(l, r);				
			}
			sb.append(ans_min).append(" ").append("\n");
			//System.out.println(ans_min+" "+ans_max);
		}
		System.out.println(sb);
		
	}
}
