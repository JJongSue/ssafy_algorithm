package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main1052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(N<=K) System.out.println(0);
		else {
			int map[] = new int[25];
			int cnt = 0;
			int tmp = N;
			int iter = 0;
			int ans = 0;
			while(tmp>=1) {
				map[iter]=tmp%2;
				tmp/=2;
				iter++;
				//if(cnt+map[iter]+tmp<=K) break;
				
			}
			for(int i=0;i<25;i++) {
				map[i+1]+=map[i]/2;
				map[i] = map[i]%2;
				cnt = 0;
				for(int c=0;c<25;c++) cnt+=map[c];
				if(cnt<=K) break;
				if(map[i] == 1) {
					map[i]=0;
					map[i+1]++;
					ans += (1<<i);
				}
			}
			cnt = 0;
			for(int c=0;c<25;c++) cnt+=map[c];
			if(cnt<=K) System.out.println(ans);
			else System.out.println(-1);
			
			//System.out.println(Arrays.toString(map));
		}
	}
}
