package boj;

import java.util.Scanner;

public class Main1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 0) N=1;
		int map[] = new int[9];
		int max = 0;
		while(N != 0) {
			int tmp = N%10;
			if(tmp == 9 || tmp == 6) {
				map[6]++;
				max = Math.max(max, (map[6]/2) + (map[6]%2));
			}else {
				map[tmp]++;
				max = Math.max(max, map[tmp]);
			}
			N = N/10;
			
		}
		System.out.println(max);
	}
}
