package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3190 {
	static final int dx[] = 
	static int N;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		ArrayList<pair> apple = new ArrayList<>();
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			apple.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));			
		}
		int L = Integer.parseInt(br.readLine());
		int mt[] = new int[L];
		char mr[] = new char[L];
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			mt[i] = Integer.parseInt(st.nextToken());
			mr[i] = st.nextToken().charAt(0);
		}
		boolean is_end = false;
		ArrayList<pair> snack = new ArrayList<>();
		snack.add(new pair(0, 0));
		int rotate = 0;
		while(!is_end) {
			
		}
	}
	
	static boolean is_over(int x, int y) {
		if(x < 0 || y < 0 || x>=N || y>=N) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
