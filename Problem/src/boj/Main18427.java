package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main18427 {
	static long ans = 0;
	static final int div_num = 10_007;
	static ArrayList<Integer> al[];
	static int N, M, H;
	static int min=1000, max=1;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][N];
		
		al = new ArrayList[N];
		for(int i=0;i<N;i++) {
			al[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			for(int j=0;j<size;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				al[i].add(tmp);
//				if(tmp <= H) {
//					
//				}else if(tmp == H) {
//					ans++;
//				}
			}
//			al[i].sort(new Comparator<Integer>() {
//
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					// TODO Auto-generated method stub
//					return o1-o2;
//				}
//			});
		}
		for(int i=0;i<al[0].size();i++) {
//			System.out.println(i);
			int tmp = al[0].get(i);
			map[tmp][0] = 1;
		}
		map[0][0] = 1;
		for(int i=1;i<N;i++) {
			for(int j=0;j<=H;j++) {
				if(map[j][i-1] == 0) continue;
				map[j][i] = (map[j][i] + map[j][i-1]) % div_num;
				for(int k=0;k<al[i].size();k++) {
					if(j+al[i].get(k)<=H) map[j+al[i].get(k)][i] = (map[j][i-1] + map[j+al[i].get(k)][i]) % div_num;
				}
			}
		}
//		for(int i=0;i<=H;i++) System.out.println(Arrays.toString(map[i]));
		System.out.println(map[H][N-1]);
		
		
//		get_num(0, 0);
//		System.out.println(ans);
		
		
		
	}
	static void get_num(int now_i, int sum) {
		if(sum == H) {
			ans = (ans+1)% div_num;
			return;
		}
		if(now_i == N) return;
		for(int i=al[now_i].size()-1;i>=0;i--) {
			if(sum+al[now_i].get(i) <= H ) {
				get_num(now_i+1, sum+al[now_i].get(i));
			}
		}
		get_num(now_i+1, sum);
	}
	
}
