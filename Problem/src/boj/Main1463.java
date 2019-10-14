package boj;

import java.util.Scanner;

public class Main1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		if(N == 1) System.out.println(0);
		else if(N == 2) System.out.println(1);
		else
		{
			arr[2] = 1;
			arr[3] = 1;
			for(int i=4;i<=N;i++) {
				int min = arr[i-1];
				if(i%2 == 0) min = Math.min(min, arr[i/2]);
				if(i%3 == 0) min = Math.min(min, arr[i/3]);
				arr[i] = min+1;
			}
			System.out.println(arr[N]);
		}
		
	}
}
