package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2660 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				map[i][j] = 10000;
			}
		}
		while(true) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(a==-1 && b==-1) break;
			map[a-1][b-1] =1;
			map[b-1][a-1] = 1;
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					map[j][i] = map[i][j];
				}
			}
		}
		int min = 10000;
		//for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
		
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<N;i++) {
			int max = -1;
			for(int j=0;j<N;j++) {
				max = Math.max(max, map[i][j]);
			}
			if(min > max) {
				min = max;
				al = new ArrayList<>();
				al.add(i+1);
			}else if(min == max) {
				al.add(i+1);
			}
			
		}
		System.out.println(min+" "+al.size());
		for(int i=0;i<al.size();i++) {
			System.out.print(al.get(i)+" ");
		}
		
		
		
	}
}
