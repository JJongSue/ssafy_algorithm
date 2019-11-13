package swea;

import java.util.Scanner;

public class Solution4013 {
	static int mag[][];
	static boolean is_visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int ans=0;
			int comands = sc.nextInt();
			mag = new int[4][8];
			is_visit = new boolean[4];
			for(int i=0;i<4;i++) {
				for(int j=0;j<8;j++) {
					mag[i][j] = sc.nextInt();
				}
			}
			for(int c=0;c<comands;c++) {
				int str = sc.nextInt()-1;
				int r = sc.nextInt();
				is_visit = new boolean[4];
				is_visit[str] = true;
				rotate(str, r);
			}
			ans = mag[0][0]+mag[1][0]*2+mag[2][0]*4+mag[3][0]*8;
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void rotate(int x, int r) {
		if(x>0) {
			if(!is_visit[x-1]) {
				if(mag[x][6] != mag[x-1][2]) {
					is_visit[x-1]= true;
					rotate(x-1,r*(-1));
				}
			}
		}
		
		if(x<3) {
			if(!is_visit[x+1]) {
				if(mag[x][2] != mag[x+1][6]) {
					is_visit[x+1]= true;
					rotate(x+1,r*(-1));
				}
			}
		}
		
		if(r == 1) {
			int tmp = mag[x][7];
			for(int i=7;i>0;i--) {
				mag[x][i] = mag[x][i-1];
			}
			mag[x][0]=tmp;
		}else {
			int tmp = mag[x][0];
			for(int i=0;i<7;i++) {
				mag[x][i] = mag[x][i+1];
			}
			mag[x][7]=tmp;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
