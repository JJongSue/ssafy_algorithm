package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(N == 1) {
			System.out.println(1);
		}else {			
			int dp[] = new int[N];
			dp[0] = Integer.parseInt(st.nextToken());
			int size = 0;
			for(int i=1;i<N;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(dp[size] > tmp) {
					size++;
					dp[size] = tmp;
					continue;
				}
				if(dp[0] < tmp) {
					dp[0] = tmp;
					continue;
				}
				int l = 0, r = size;
				int mid = 0;
				while(l<=r) {
					mid = (l+r)/2;
					if(dp[mid] == tmp) {
						break;
					}else if(dp[mid] > tmp){
						l = mid+1;
					}else {
						r = mid-1;
					}
				}
				if(dp[mid] < tmp ) {
					dp[mid] = tmp;
				}
				
			}
			System.out.println(Arrays.toString(dp));
			System.out.println(size+1);
		}
		
	}
}
