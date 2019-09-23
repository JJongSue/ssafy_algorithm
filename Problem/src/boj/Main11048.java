package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N+1][M+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
		for(int i=N-1;i>=0;i--) {
			for(int j=M-1;j>=0;j--) {
				map[i][j]+=Math.max(map[i+1][j], map[i][j+1]);
			}
		}
		System.out.println(map[0][0]);
	}
}
