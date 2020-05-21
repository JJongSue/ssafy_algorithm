package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2624 {
	static class coin {
		int p;
		int c;
		public coin(int p, int c) {
			super();
			this.p = p;
			this.c = c;
		}

	}
	static int N, M;
	static long ans = 0;
	static int dp[];
	static ArrayList<coin> al = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		dp = new int[M+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c  = Integer.parseInt(st.nextToken());
			al.add(new coin(p, c));
		}
		
		al.sort(new Comparator<coin>() {

			@Override
			public int compare(coin o1, coin o2) {
				// TODO Auto-generated method stub
				return o1.c - o2.c;
			}
		});
		
		for(int i=0;i<al.size();i++) {
			
		}
		
		System.out.println(ans);
		
	}

}
