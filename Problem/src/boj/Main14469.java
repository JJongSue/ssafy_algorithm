package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14469 {
	static class pair implements Comparable<pair>{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		pair arr[] = new pair[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		Arrays.sort(arr);
		int now = arr[0].y + arr[0].x;
		for(int i=1;i<N;i++) {
			if(now <= arr[i].x) now = arr[i].x + arr[i].y;
			else now += (arr[i].y ); 
		}
		System.out.println(now);
		
	}
}
