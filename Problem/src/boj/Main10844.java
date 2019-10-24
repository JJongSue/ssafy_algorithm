package boj;

import java.util.Scanner;

public class Main10844 {
	static final int divnum = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Long arr[][] = new Long[N][10];
		arr[0][0] = (long) 0;
		for(int i=1;i<10;i++) arr[0][i]=(long) 1;
		for(int i=1;i<N;i++) {
			for(int j=0;j<10;j++) {
				arr[i][j] = (long)0;//(arr[i-1][j]%divnum);
				if(j != 0) arr[i][j]+=arr[i-1][j-1];
				if(j != 9) arr[i][j]+=arr[i-1][j+1];
				arr[i][j] = arr[i][j] %divnum;
			}
		}
		Long ans = (long) 0;
		for(int i=0;i<10;i++) {
			ans += arr[N-1][i];
			ans = ans % divnum;
		}
		System.out.println(ans);
	}
}
