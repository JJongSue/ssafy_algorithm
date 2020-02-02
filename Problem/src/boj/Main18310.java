package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18310 {
	static int l = 200_001, r=0, ans=100_001;
	static final long max_num = 200_000; 
	static long ans_sum = max_num*max_num;
	static long sum = 0;
	static long lsum=0, rsum=0, msum=0;
	static int N;
	static int map[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[N];
		
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			l = Math.min(l, map[i]);
			r = Math.max(r, map[i]);
		}
		if(l == r) ans = l;
		while(l<=r) {
			//if(ans < l) break;
			int mid = (l+r)/2;
			//System.out.println("L : " + l + " R : "+ r+" mid : "+mid);
			lsum=0;
			rsum=0;
			msum=0;
			for(int i=0;i<N;i++) {
				lsum += (Math.abs(map[i]-l));
				rsum += (Math.abs(map[i]-r));
				msum += (Math.abs(map[i]-mid));
			}
			if(rsum < lsum) {
				if(msum <= rsum) {
					if(msum < ans_sum) {
						ans_sum = msum;
						ans = mid;
					}else if(msum == ans_sum && mid < ans) {
						ans = mid;
					}
				}else {
					if(rsum < ans_sum) {
						ans = r;
						ans_sum = rsum;
					}else if(rsum == ans_sum && r < ans) {
						ans = r;
					}
				}
				l = mid+1;
				
				
			}else {
				if(msum < lsum) {
					if(msum < ans_sum) {
						ans_sum = msum;
						ans = mid;
					}else if(msum == ans_sum && mid < ans) {
						ans = mid;
					}
				}else {
					if(lsum < ans_sum) {
						ans = l;
						ans_sum = lsum;
					}else if(lsum == ans_sum && l < ans) {
						ans = l;
					}
				}
				r= mid-1;
			}
			
		}
		System.out.println(ans);
		
		
	}
	
	
	
}
