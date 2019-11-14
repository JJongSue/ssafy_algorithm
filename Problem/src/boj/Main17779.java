package boj;

import java.util.Scanner;

public class Main17779 {
	static int N;
	static int map[][];
	static boolean is_visit[][];
	static int ans = 987654321;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		setcnt();
		System.out.println(ans);
		//count(3,1,2,2);
	}
	
	static void setcnt() {
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<N-1;j++) {
				for(int k=1;k<N-1;k++) {
					for(int l=1;l<N-1;l++) {
						if(j-k<0 || i+k>=N || i+l>=N || j+l>=N || j-k+l>=N || i+k+l>=N) continue;
						count(j,i,k,l);
					}
				}
			}
		}
	}
	static void count(int x, int y, int d1, int d2) {
		is_visit = new boolean[N][N];
		int max = 0, min=987654321;
		int tmp = 0;
		
		
		for(int i=0;i<y-1;i++) {
			for(int j=0;j<=x;j++) {
				tmp+=map[i][j];
				is_visit[i][j]=true;
			}
		}
		for(int i=0;i+y-1<y+d1;i++) {
			for(int j=0;j<=x-i;j++) {
				tmp+=map[y-1+i][j];
				is_visit[y-1+i][j]=true;
			}
		}
		max = Math.max(max, tmp);
		min = Math.min(min, tmp);
		//System.out.println(tmp);
		
		//3
		tmp = 0;
		for(int i=0;i+y+d1<N;i++) {
			
			for(int j=0;j<=x-d1-1+i;j++) {
				
				if(j>= x-d1+d2) break;
				tmp+=map[y+d1+i][j];
				is_visit[y+d1+i][j]=true;
			}
		}
		max = Math.max(max, tmp);
		min = Math.min(min, tmp);
		//System.out.println(tmp);
		//2
		tmp = 0;
		for(int i=0;y+d2-i>=0;i++) {
			for(int j=x+d2+1-i;j<N;j++) {				
				if(j<= x) continue;
				tmp+=map[y+d2-i][j];
				is_visit[y+d2-i][j]=true;
			}
		}
		max = Math.max(max, tmp);
		min = Math.min(min, tmp);
		//System.out.println(tmp);
		//4
		tmp = 0;
		for(int i=0;y+d2+1+i<N;i++) {			
			for(int j=x+d2-i;j<N;j++) {		
				if(j<x-d1+d2) continue;
				//if(j<x-d1+d2)
				tmp+=map[y+d2+1+i][j];
				is_visit[y+d2+1+i][j]=true;
			}
		}
		max = Math.max(max, tmp);
		min = Math.min(min, tmp);
		//System.out.println(tmp);
		tmp = 0;
		for(int i=y;i<=y+d1+d2;i++) {
			for(int j=x-d1;j<=x+d2;j++) {
				if(!is_visit[i][j]) tmp+=map[i][j];
			}
		}
		max = Math.max(max, tmp);
		min = Math.min(min, tmp);
		//System.out.println(tmp);
		
		ans = Math.min(ans, max-min);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
