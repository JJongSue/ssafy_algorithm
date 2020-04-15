package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main1107 {
	static int N, m, size;
	static boolean is_ok[] = new boolean[10];
	static int map[], find[];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=N;i>0;i/=10) {
			size++;
		}
		if(N == 0) size = 1;
		map = new int[size];
		find = new int[size];
		
		int input = N;
		for(int i=size-1;i>=0;i--) {
			find[i] = input%10;
			input = input/10;
		}
		//System.out.println(Arrays.toString(find));
		for(int i=0;i<m;i++) {
			int tmp = sc.nextInt();
			is_ok[tmp] = true;
		}
		
		if(m == 10) {
			System.out.println(Math.abs(N-100));
		}else {
			ans = Math.abs(N-100);
			find_num(0);
			int max_num = 10;
			int min_num = 0;
			for(int i=1;i<10;i++) {
				if(!is_ok[i]) {
					max_num = i;
					break;
				}
			}
			for(int i=0;i<10;i++) {
				if(!is_ok[i]) {
					min_num = i;
					break;
				}
			}
			//max_num = max_num * 10;
			for(int i=0;i<size;i++) max_num = max_num * 10 + min_num;
			//System.out.println(max_num);
			ans = Math.min(ans, size+1+Math.abs(N-max_num));
			System.out.println(ans);
		}
	}
	static void find_num(int now) {
		if(now == size) {
			int find_n = 0;
			for(int i=0;i<size;i++) {
				find_n = find_n * 10 + map[i];
			}
			int cnt = 0;
			if(find_n == 0) {
				if(is_ok[0]) return;
				cnt = 1 + Math.abs(N-find_n);
			}
			else {
				int minus = 0;
				for(int i=0;i<size;i++) {
					if(map[i] != 0) break;
					minus++;
				}
				cnt = size - minus + Math.abs(N-find_n);
			}
//			if(ans > cnt) {
//				System.out.println(cnt);
//				System.out.println(Arrays.toString(map));
//			}
			ans = Math.min(cnt, ans);
			
			return;
		}
		int tmp = map[now];
		if(!is_ok[find[now]]) {
			map[now] = find[now];
			find_num(now+1);
		}
		for(int i=find[now]+1;i<10;i++) {
			if(!is_ok[i]) {
				map[now] = i;
				find_num(now+1);
				break;
			}
		}
		for(int i=find[now]-1;i>=0;i--) {
			if(!is_ok[i]) {
				map[now] = i;
				find_num(now+1);
				break;
			}
		}
		if(now == 0) {
			map[now] = 0;
			find_num(now+1);
		}else if(map[now-1] == 0) {
			map[now] = 0;
			find_num(now+1);
			
		}
		for(int i=9;i>0;i--) {
			if(!is_ok[i]) {
				map[now] = i;
				find_num(now+1);
				break;
			}
		}
		for(int i=0;i<10;i++) {
			if(!is_ok[i]) {
				map[now] = i;
				find_num(now+1);
				break;
			}
		}
		
		
		
		
		
	}
	
}
