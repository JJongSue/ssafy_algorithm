package swea;

import java.util.Scanner;

public class Solution4796 {
	public static void main(String[] args) {
		//한줄이 너무 길어서 bufferedreader를 쓸 수없어서
		//scanner를 사용
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][3];
			arr[0][0] = sc.nextInt();
			for(int i=1;i<N;i++) {
				arr[i][0] = sc.nextInt();
				if(arr[i][0] > arr[i-1][0]) arr[i][1] = arr[i-1][1]+1;
			}
			long ans = 0;
			for(int i=N-2;i>=0;i--) {			
				if(arr[i][0] > arr[i+1][0]) arr[i][2] = arr[i+1][2]+1;
				ans += (arr[i][1]*arr[i][2]);
			}
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}
}
