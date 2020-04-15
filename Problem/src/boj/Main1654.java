package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1654 {
	static int K, N;
	static long arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long ans = 1;
		long min = 1;//arr[0];
		long max = arr[K-1];
		//System.out.println(min + " " + max);
		while(min <= max) {
			long mid = (min+max)/2;
			int cnt = 0;
			for(int i=0;i<K;i++) {
				if(cnt >= N) break;
				cnt += (arr[i]/mid);
			}
			if(cnt >= N) {
				ans = mid;
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		System.out.println(ans);
	}
}
