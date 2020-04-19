package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		map[0][0] = Integer.parseInt(br.readLine());
		//int max = map[0];
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = map[i-1][j] + tmp;
				if(j-1>=0) map[i][j] = Math.max(map[i][j], tmp+map[i-1][j-1]);
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(max, map[N-1][i]);
		}
		System.out.println(max);
	}
}
