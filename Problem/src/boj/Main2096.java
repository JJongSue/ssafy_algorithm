package boj;

import java.util.Scanner;

public class Main2096 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max[][] = new int[N][3];
		int min[][] = new int[N][3];
		max[0][0] = sc.nextInt();
		max[0][1] = sc.nextInt();
		max[0][2] = sc.nextInt();
		min[0][0] = sc.nextInt();
		min[0][1] = sc.nextInt();
		min[0][2] = sc.nextInt();
		for(int i=1;i<N;i++) {
			int a =sc.nextInt();
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]);
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]);
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][2]), max[i-1][1])+;
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]);
			min[i][2] = Math.min(max[i-1][1], min[i-1][2]);
			min[i][1] = Math.min(max[i][0], min[i][2]);
		}
		int ans_max = Math.max(max[N-1][0], max[N-1][1]);
		ans_max = Math.max(ans_max, max[N-1][2]);
		int ans_min = Math.min(min[N-1][0], min[N-1][1]);
		ans_min = Math.min(ans_min, min[N-1][2]);
		System.out.println(ans_max+" "+ans_min);
	}
}
