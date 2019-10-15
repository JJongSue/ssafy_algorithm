package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17143 {
	static final int dx[] = {0,0,0,1,-1};
	static final int dy[] = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		if(S == 0) System.out.println(0);
		else {
			int map[][][] = new int[N][M][3];						
			for(int i=0;i<S;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				map[y][x][0] = Integer.parseInt(st.nextToken());
				map[y][x][1] = Integer.parseInt(st.nextToken());
				map[y][x][2] = Integer.parseInt(st.nextToken());				
			}
			int answer = 0;
			for(int s=0;s<M;s++) {
				for(int i=0;i<N;i++) {
					if(map[i][s][2] != 0) {
						answer += map[i][s][2];
						map[i][s][0] = 0;
						map[i][s][1] = 0;
						map[i][s][2] = 0;
						
						break;
					}
				}
				int tmpmap[][][] = new int[N][M][3];
				System.out.println();
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						//System.out.println(map[3][4][2]);
						if(map[i][j][2] != 0) {
							System.out.println(i+" "+ j);
							if(map[i][j][1] == 1) {
								if(map[i][j][0] > N) {
									int tmps = map[i][j][0]%N;
									int tmpd = 1;
									if((map[i][j][0]/N)%2 == 1 ) {									
										tmpd=2;
										if(tmps+i >= N ) {
											tmpd=1;
											if(tmpmap[2*(N-1)-tmps-i][j][2] > map[i][j][2]) {
												tmpmap[2*(N-1)-tmps-i][j][0] = map[i][j][0];
												tmpmap[2*(N-1)-tmps-i][j][1] = 1;
												tmpmap[2*(N-1)-tmps-i][j][2] = map[i][j][2];
											}
											
										}else {
											if(tmpmap[tmps+i][j][2] > map[i][j][2]) {
												tmpmap[tmps+i][j][0] = map[i][j][0];
												tmpmap[tmps+i][j][1] = 2;
												tmpmap[tmps+i][j][2] = map[i][j][2];
											}
										}
									}else {
										tmpd=2;
										if(i-tmps < 0 ) {
											tmpd=2;
											if(tmpmap[tmps-i][j][2] > map[i][j][2]) {
												tmpmap[tmps-i][j][0] = map[i][j][0];
												tmpmap[tmps-i][j][1] = 2;
												tmpmap[tmps-i][j][2] = map[i][j][2];
											}										
										}else {
											if(tmpmap[i-tmps][j][2] > map[i][j][2]) {
												tmpmap[i-tmps][j][0] = map[i][j][0];
												tmpmap[i-tmps][j][1] = 1;
												tmpmap[i-tmps][j][2] = map[i][j][2];
											}
										}
									}
								}else {
									int tmps = map[i][j][0];
									if(i-tmps < 0 ) {
										
										if(tmpmap[tmps-i][j][2] > map[i][j][2]) {
											tmpmap[tmps-i][j][0] = map[i][j][0];
											tmpmap[tmps-i][j][1] = 2;
											tmpmap[tmps-i][j][2] = map[i][j][2];
										}										
									}else {
										if(tmpmap[i-tmps][j][2] > map[i][j][2]) {
											tmpmap[i-tmps][j][0] = map[i][j][0];
											tmpmap[i-tmps][j][1] = 1;
											tmpmap[i-tmps][j][2] = map[i][j][2];
										}
									}
								}
								
								
								
								
								
							}else if(map[i][j][1] == 2) {
								int tmps = map[i][j][0]%N;
								int tmpd = 2;
								if((map[i][j][0]/N)%2 == 1 ) {
									if(i-tmps < 0 ) {
										tmpd=2;
										if(tmpmap[tmps-i][j][2] > map[i][j][2]) {
											tmpmap[tmps-i][j][0] = map[i][j][0];
											tmpmap[tmps-i][j][1] = 2;
											tmpmap[tmps-i][j][2] = map[i][j][2];
										}										
									}else {
										if(tmpmap[i-tmps][j][2] > map[i][j][2]) {
											tmpmap[i-tmps][j][0] = map[i][j][0];
											tmpmap[i-tmps][j][1] = 1;
											tmpmap[i-tmps][j][2] = map[i][j][2];
										}
									}
									
									tmpd=1;
									
									
								}else {
									if(tmps+i >= N ) {
										tmpd=1;
										if(tmpmap[2*(N-1)-tmps-i][j][2] > map[i][j][2]) {
											tmpmap[2*(N-1)-tmps-i][j][0] = map[i][j][0];
											tmpmap[2*(N-1)-tmps-i][j][1] = 1;
											tmpmap[2*(N-1)-tmps-i][j][2] = map[i][j][2];
										}
										
									}else {
										if(tmpmap[tmps+i][j][2] > map[i][j][2]) {
											tmpmap[tmps+i][j][0] = map[i][j][0];
											tmpmap[tmps+i][j][1] = 2;
											tmpmap[tmps+i][j][2] = map[i][j][2];
										}
									}
								
									
								}
								
							}else if(map[i][j][1] == 3) {
								int tmps = map[i][j][0]%M;
								int tmpd = 3;
								if((map[i][j][0]/M)%2 == 1 ) {									
									tmpd=4;
									if(j-tmpd < 0 ) {
										tmpd=1;
										if(tmpmap[i][tmps-j][2] > map[i][j][2]) {
											tmpmap[i][tmps-j][0] = map[i][j][0];
											tmpmap[i][tmps-j][1] = 3;
											tmpmap[i][tmps-j][2] = map[i][j][2];
										}
										
									}else {
										if(tmpmap[i][j-tmps][2] > map[i][j][2]) {
											tmpmap[i][j-tmps][0] = map[i][j][0];
											tmpmap[i][j-tmps][1] = 4;
											tmpmap[i][j-tmps][2] = map[i][j][2];
										}
									}
								}else {
									tmpd=2;
									if(j+tmps >= M ) {
										tmpd=2;
										if(tmpmap[i][2*(M-1)-j-tmps][2] > map[i][j][2]) {
											tmpmap[i][2*(M-1)-j-tmps][0] = map[i][j][0];
											tmpmap[i][2*(M-1)-j-tmps][1] = 4;
											tmpmap[i][2*(M-1)-j-tmps][2] = map[i][j][2];
										}										
									}else {
										if(tmpmap[i][j+tmps][2] > map[i][j][2]) {
											tmpmap[i][j+tmps][0] = map[i][j][0];
											tmpmap[i][j+tmps][1] = 3;
											tmpmap[i][j+tmps][2] = map[i][j][2];
										}
									}
								}
								
							}else if(map[i][j][1] == 4) {
								int tmps = map[i][j][0]%M;
								int tmpd = 4;
								if((map[i][j][0]/M)%2 == 1 ) {									
									tmpd=4;
									if(j+tmps >= M ) {
										tmpd=2;
										if(tmpmap[i][2*(M-1)-j-tmps][2] > map[i][j][2]) {
											tmpmap[i][2*(M-1)-j-tmps][0] = map[i][j][0];
											tmpmap[i][2*(M-1)-j-tmps][1] = 4;
											tmpmap[i][2*(M-1)-j-tmps][2] = map[i][j][2];
										}										
									}else {
										if(tmpmap[i][j+tmps][2] > map[i][j][2]) {
											tmpmap[i][j+tmps][0] = map[i][j][0];
											tmpmap[i][j+tmps][1] = 3;
											tmpmap[i][j+tmps][2] = map[i][j][2];
										}
									}
									
								}else {
									tmpd=2;
									if(j-tmpd < 0 ) {
										tmpd=1;
										if(tmpmap[i][tmps-j][2] > map[i][j][2]) {
											tmpmap[i][tmps-j][0] = map[i][j][0];
											tmpmap[i][tmps-j][1] = 3;
											tmpmap[i][tmps-j][2] = map[i][j][2];
										}
										
									}else {
										if(tmpmap[i][j-tmps][2] > map[i][j][2]) {
											tmpmap[i][j-tmps][0] = map[i][j][0];
											tmpmap[i][j-tmps][1] = 4;
											tmpmap[i][j-tmps][2] = map[i][j][2];
										}
									}
									
									
								}
							}
							
							
							
						}
						
						
						
						
						
						
					}
				}
				map = new int[N][M][3];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						for(int k=0;k<3;k++) map[i][j][k]=tmpmap[i][j][k]; 
					}
				}
				
			}
			System.out.println(answer);
		}
	}
	
}