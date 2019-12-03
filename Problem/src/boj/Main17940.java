package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17940 {
	static int[] company;
	static int[][] map;
	static ArrayList<subway> dis[];
	
	static class subway implements Comparable<subway>{
		int now;
		int c;
		int dis;
		public subway(int now, int c, int dis) {
			super();
			this.now = now;
			this.c = c;
			this.dis = dis;
		}
		@Override
		public int compareTo(subway o) {
			if(this.c == o.c) return this.dis-o.dis;
			return this.c-o.c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		company = new int[N];
		map = new int[N][2];
		dis = new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			company[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
			}
		}
		
	}
}
