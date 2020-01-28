package day200128;

import java.util.Scanner;

public class Solution2 {
	//합계를 저장할 map, max==N일
	//ans는 return 개수,
	// MM 목표 물건 개수
	// TT 연속 몇일?
	// KK 개 이하
	static int map[], max, ans=0, MM, TT, KK;
	
	static void cnt(int now, int first, int sum) {
		if(now == max) {
			if(sum == MM) ans++;
			return;
		}
		if(sum == MM) {
			ans++;
			return;
		}
		for(int i=KK;i>=0;i--) {
			boolean is_ok = true;
			for(int j=0;j<TT;j++) {
				if(now+j == max) break;
				map[now+j] += i;
				if(map[now+j] > KK) {
					for(int k=0;k<=j;k++) {
						map[now+j] -= i;
					}
					is_ok = false;
					break;
				}
			}
			if(is_ok) {
				//System.out.println(now+ " i:" + i);
				cnt(now+1, first,sum+i);
				for(int j=0;j<TT;j++) {
					if(now+j == max) break;
					map[now+j] -= i;
				}
			}
		}
	}
	
	public static int solution(int N, int M, int T, int K) {
		ans = 0;
		map = new int[N];
		max = N;
		MM = M;
		TT = T;
		KK = K;
		cnt(0, 0, 0);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0;i<tc;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int tmp = solution(a, b, c, d);
			System.out.println(tmp);
		}
	}
}
