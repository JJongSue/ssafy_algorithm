package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7575 {
	static int N, K;
	static int map[][];
	static int vi[];
	static int iv[];
	static boolean answer = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		vi = new int[K];
		iv = new int[K];
		map = new int[N][1000];
		
		for(int i=0;i<N;i++) {
			int size = Integer.parseInt(br.readLine());
			if(size < K) {
				answer = false;
				break;
			}
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<size;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		if(answer) {
			answer = false;
			for(int i=0;i+K-1<1000;i++) {
				if(map[0][i+K-1] == 0 || answer) break;
				for(int j=0;j<K;j++) {
					iv[j] = map[0][i+j];
				}
				for(int j=0;j<K;j++) {
					vi[j] = iv[K-1-j];
				}
				go(0);
			}
			if(answer) System.out.println("YES");
			else System.out.println("NO");
			
		}else {
			System.out.println("NO");
		}
		
	}
	
	static void go(int now) {
//		System.out.println(now);
		if(answer) return;
		if(now == N) {
			answer = true;
			return;
		}
		
		for(int i=0;i+K-1<1000;i++) {
			if(map[now][i+K-1] == 0) return;
			boolean next1 = true;
			boolean next2 = true;
			for(int j=0;j<K;j++) {
				if(!next1 && !next2) break;
				if(next1 && map[now][i+j] != vi[j]) {
					next1=false;
//					break;
				}
				if(next2 && map[now][i+j] != iv[j]) {
					next2=false;
//					break;
				}
			}
			if(next1 || next2) {
				go(now+1);
			}
		}
	}
	
	
	

	
}
