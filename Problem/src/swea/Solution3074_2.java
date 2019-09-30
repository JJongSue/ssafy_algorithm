package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution3074_2 {
	static int N, M;
	static long arr[];
	static long ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new long[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(br.readLine());	
			}
			
			Arrays.sort(arr);
			long min = arr[0];
			long max = arr[0]*M;
			ans = max;
			is_num(min);
			bin_search(min, max);
			System.out.println("#"+tc+" "+ans);
	
		}
	}
	static void bin_search(long min, long max) {
		if(min >= max) {
			is_num(min);
			return;
		}
		long mid = (max+min)/2;
		int LR = is_num(mid);
		if(LR <= 0 ) {
			bin_search(min, mid-1);
		}else {
			bin_search(mid+1, max);
		}
	}
	
	// 0과 같거나 작으면 왼쪽 크면 오른쪽인 범위찾는 함수
	static int is_num(long val) {
		long sum = 0;
		for(int i=0;i<N;i++) {
			if(arr[i] > val) break;
			sum += (val/arr[i]);
			if(sum >= M) break;			
		}
		if(M-sum <= 0) {
			if(ans > val) ans = val;
			return -1;
		}
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
}
