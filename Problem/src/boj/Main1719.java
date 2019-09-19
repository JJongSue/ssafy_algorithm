package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1719 {
	static class dot implements Comparable<dot>{
		int x;
		int dis;
		public dot(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return o.dis-this.dis;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
	}
	
}
