package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt()-1;
		int B = sc.nextInt()-1;
		int arr[] = new int[1000];
		int now = 1;
		int cnt = 0;
		for(int i=0;i<1000;i++) {
			arr[i] = now;
			cnt++;
			if(cnt == now) {
				cnt = 0;
				now++;
			}
			
		}
		long ans = 0;
		for(int i=A;i<=B;i++) {
			ans += arr[i];
		}
		System.out.println(ans);
		
	}
}
