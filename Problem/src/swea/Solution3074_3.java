package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3074_3 {
	static int N, M;
	static long arr[];
	static long ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 갯수
		int T = Integer.parseInt(br.readLine());		
		for(int tc = 1 ; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//N : 심사대 M : 사람수
			//tk를 저장할 arr배열
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new long[N];
			long min = Long.MAX_VALUE;
			for(int i=0;i<N;i++) {
				arr[i] = Long.parseLong(br.readLine());
				min = Math.min(min, arr[i]);
			}
			
			//Arrays.sort(arr);
			
			long max = arr[0]*M;
			ans = max;
			
			System.out.println("#"+tc+" "+bin_search(min, max));
	
		}
	}
	static long bin_search(long min, long max) {
		if(min == max) return min;
		long mid = (max+min)/2;
		long sum = 0;
		for(int i=0;i<N;i++) {
			//if(arr[i] > val) break;
			sum += (mid/arr[i]);
			if(sum >= M) return bin_search(min, mid);			
		}
		return bin_search(mid+1, max);		
		
	}
	
}
