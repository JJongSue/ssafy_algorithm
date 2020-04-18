package boj;

import java.util.Scanner;

public class Main2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[6];
		int sum = 0;
		arr[0] = sc.nextInt();
		arr[0] = sc.nextInt();
		for(int i=1;i<6;i++) {
			arr[i] = sc.nextInt();
			arr[i] = sc.nextInt();
			sum += (arr[i-1]*arr[i]);
		}
		sum += (arr[0]*arr[5]);
		int x = 0, y = 0;
		for(int i=0;i<3;i++) {
			x = Math.max(x, arr[i*2]);
			y = Math.max(y, arr[i*2+1]);
		}
//		System.out.println(sum);
//		System.out.println(x*y);
		System.out.println((sum-(y*x)*2)*N);
	}
}
