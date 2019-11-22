package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int min = 987654321;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(i+7<N && j+7<M) {
					int cnt = 0;
					int cnt2 = 0;
					for(int ii=0;ii<8;ii++) {
						for(int jj=0;jj<8;jj++) {
							if((ii+jj)%2 == 0) {
								if(map[ii+i][jj+j] == 'B') {
									cnt++;
								}else {
									cnt2++;
								}
							}else {
								if(map[ii+i][jj+j] == 'B') {
									cnt2++;
								}else {
									cnt++;
								}
							}
						}
					}
					min = Math.min(min, cnt);
					min = Math.min(min, cnt2);
					
				}
				
			}
		}
		System.out.println(min);
		
		
		
	}
}
