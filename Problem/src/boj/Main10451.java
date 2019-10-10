package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10451 {
	static int []arr;
	static int N;
	static boolean is_visit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			is_visit = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans=0;
			is_visit = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				if(is_visit[i]) continue;
				is_visit[i]=true;
				if(is_circle(i, i)) {	
					//System.out.println(i);
					ans++;
				}
			}
			System.out.println(ans);
			
			
		}
		
	}
	static boolean is_circle(int x, int y) {
		if(arr[y] == x) {
			return true;
		}
		if(!is_visit[arr[y]] ) {
			is_visit[arr[y]]=true;
			return is_circle(x, arr[y]);
		}
		return false;
		
	}
}
