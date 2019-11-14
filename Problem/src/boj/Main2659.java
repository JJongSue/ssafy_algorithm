package boj;

import java.util.Scanner;

public class Main2659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[4];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		int min = 10000;
		for(int i=0;i<4;i++) {
			int tmp = 1000*arr[0]+100*arr[1]+10*arr[2]+arr[3];
			min = Math.min(tmp, min);
			tmp = arr[3];
			for(int s=1;s<4;s++) {
				arr[s]=arr[s-1];
			}
			arr[3]=tmp;
		}
		for(int i=1000;i<10000;i++) {
			int j = 1000;
			while(j>=5) {
				
			}
		}
	}
}
