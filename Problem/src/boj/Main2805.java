package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int max = -1;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > max) max = arr[i];
		}
		int left = 0, right = max, mid = M;
		int ans = 0;
		while(left <= right) {
			mid = (left+right)/2;
			long sum = 0;
			for(int i=0;i<N;i++) {
				if(mid < arr[i]) {
					sum+=(arr[i]-mid);
				}				
			}
			if(sum==M) {
				left=mid+1;
				if(ans < mid) ans =mid;
				//ans=mid;				
			}else if(sum < M) {
				right = mid-1;
			}else {
				left = mid+1;
				if(ans < mid) ans =mid;
			}
			//System.out.println(left+" "+right);
		}
		System.out.println(ans);
	}
}
