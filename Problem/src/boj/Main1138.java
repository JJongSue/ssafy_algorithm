package boj;

import java.util.Scanner;

public class Main1138 {
	static int map[], ans[];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		ans = new int[N];
		for(int i=0;i<N;i++) {
			map[i] = sc.nextInt();
			if(i == 0) {
				ans[map[0]] = 1;
				continue;
			}
			int j=0, cnt = 0;
			for(j=0;j<N;j++) {
				if(cnt == map[i]) break;
				if(ans[j] == 0) cnt++;
			}
			//j++;
			while(j<N && ans[j] != 0) {
				j++;
			}
			
			ans[j] = i+1;
			
		}
		for(int i=0;i<N;i++) {
			System.out.print(ans[i]+ " ");
		}
	}
}
