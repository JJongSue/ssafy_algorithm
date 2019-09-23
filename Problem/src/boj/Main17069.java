package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main17069 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N+1][N];
		long summap[][][] = new long[N+1][N][3];
		/*for(int i=0;i<N+1;i++) {
			map[i][N]=1;
			map[N][i]=1;
		}*/
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		if(map[1][2] == 1) System.out.println(0);
		else {
			summap[1][1][0]=1;
			//summap[1][1][1]=1;
			for(int i=1;i<=N;i++) {
				for(int j=2;j<N;j++) {
					if(map[i][j]==1 ) continue;
					//System.out.println(i+" "+j+" "+map[i][j]);
					
					if(map[i][j-1] != 1 && map[i-1][j] != 1 && map[i-1][j-1] != 1) summap[i][j][1] += (summap[i-1][j-1][1]+summap[i-1][j-1][0])+summap[i-1][j-1][2];
					if(map[i][j-1] != 1) summap[i][j][0] += (summap[i][j-1][1]+summap[i][j-1][0]);
					if(map[i-1][j] != 1) summap[i][j][2] += (summap[i-1][j][1]+summap[i-1][j][2]);
					/*for(int k=0;k<3;k++) {
						summap[i][j][k]+=summap[i-1][j-1][1]; 
						if(k!=2) summap[i][j][k]+=summap[i-1][j][0];
						if(k!=0) summap[i][j][k]+=summap[i][j-1][2];
						System.out.println(i+" "+j+" "+k+summap[i][j][k]);
					}*/
					
					
				}
				
			}
			//System.out.println(summap[1][2][0]);
			System.out.println(summap[N][N-1][0]+summap[N][N-1][1]+summap[N][N-1][2]);
		}
		
		
	}
}
