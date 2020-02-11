package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		}
		Arrays.sort(map);
		if(N%2 == 0) {
			int sum1=0, sum2=0;
			int mid = N/2-1;
			int mid2 = N/2;
			for(int i=0;i<N;i++) {
				sum1 += Math.abs(map[i] - map[mid]);
				sum2 += Math.abs(map[i] - map[mid2]);
			}
			if(sum1 <= sum2) System.out.println(map[mid]);
			else System.out.println(map[mid2]);
		}else {
			System.out.println(map[N/2]);
		}
		
		
	}
	
	
	
}
