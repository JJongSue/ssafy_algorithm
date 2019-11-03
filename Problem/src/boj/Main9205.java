package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main9205 {
	static class pair{
		int x;
		int y;
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<pair> al = new ArrayList<pair>();
			for(int i=0;i<N+2;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				al.add(new pair(x, y));
			}
			int map[][] = new int[N+2][N+2];
			for(int i=0;i<al.size();i++) {
				for(int j=i+1;j<al.size();j++) {
					map[i][j] = Math.abs(al.get(i).x-al.get(j).x)+Math.abs(al.get(i).y-al.get(j).y);
					map[j][i] = map[i][j];
				}
			}
			Stack<Integer> stack = new Stack<Integer>();
			stack.add(0);
			boolean is_visit[] = new boolean[N+2];
			is_visit[0] = true;
			while(!stack.isEmpty()) {
				int tmp = stack.pop();
				if(map[tmp][N+1] <= 1000) {
					is_visit[N+1] = true;
					break;
				}
				for(int i=1;i<N+2;i++) {
					if(!is_visit[i] && map[tmp][i]<=1000) {
						stack.add(i);
						is_visit[i] = true;
					}
				}
			}
			if(is_visit[N+1]) System.out.println("happy");
			else System.out.println("sad");
			
			
		}
	}
}
