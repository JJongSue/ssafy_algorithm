package day200213;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	static int ans = 0;
	static int map[];
	static int solution(int [] arr, int k, int t) {
		int answer = 0;
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		map = new int[arr.length];
		for(int i=0;i<arr.length;i++) map[i] = arr[i];
		find_num(0, 0, 0, t, k);
		
		
		return ans;
	}
	
	static void find_num(int now, int cnt, int sum,int t, int k) {
		//if(cnt >= k ) ans++;
		
		if(now == map.length) return;
		if(sum+map[now] <= t) {
			if(cnt+1 >= k) ans++;
			find_num(now+1, cnt+1, sum+map[now], t, k);
		}
		find_num(now+1, cnt, sum, t, k);
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,2};
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int t = sc.nextInt();
		int answer = solution(arr, k, t);
		System.out.println(answer);
	}
}
