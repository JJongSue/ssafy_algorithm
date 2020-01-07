package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int block[] = new int[N];
		int maxh[] = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=0;i<N;i++) {
			block[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, block[i]);
			maxh[i] = max;
		}
		max = block[N-1];
		int sum = 0;
		for(int i=N-2;i>0;i--) {
			max = Math.max(max, block[i]);
			maxh[i] = Math.min(max, maxh[i]);
			sum += (maxh[i]-block[i]);
		}
		System.out.println(sum);
		
	}
}
