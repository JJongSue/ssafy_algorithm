package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2042 {
	static long[] tree = new long[1000005*4];
	static int s;
	static void upgrade_tree(int x, long cnt) {
		if(x == 0) return;
		tree[x] = tree[x]+cnt;
		upgrade_tree(x>>1, cnt);
	}
	static long find_tree(int left, int right) {
		int L = left, R = right;
		long res = 0;
		while(L <=R ) {
			if( (L&1) != 0) res = (res + tree[L++]);
			if( (R&1) == 0 ) res = (res+tree[R--]);
			L >>= 1;
			R>>= 1;
		}
		
		return res;
	}
	static void init(int size, int _default) {
		s = 1;
		for(s=1;s<size;s*=2);
		s = s-1;
		for(int i=1;i<=s*2+1;i++) tree[i] = _default;
	}
	static void update(int x, long cnt) { upgrade_tree(x+s, cnt-tree[x+s]);}
	static long find(int left, int right) { return find_tree(left+s, right+s);  }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		init(size, 0);
		for(int i=0;i<size;i++) {
			long tmp = Integer.parseInt(br.readLine());
			update(i+1, tmp);
		}
		for(int i=0;i<m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				update(b, c);
			}else {
				System.out.println(find(b, (int)c));
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
