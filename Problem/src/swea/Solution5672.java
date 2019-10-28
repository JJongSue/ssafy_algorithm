package swea;

import java.util.Scanner;

public class Solution5672 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			char arr[] = new char[N];
			for(int i=0;i<N;i++) arr[i] = sc.next().charAt(0);
			
			int down = 0;
			int up = N-1;
			
			while(true) {
				if(up == down) {
					sb.append(arr[up]);
					break;
				}
				if(arr[up] > arr[down]) {
					sb.append(arr[down]);
					down++;				
				}else if(arr[up] < arr[down]) {
					sb.append(arr[up]);
					up--;
					
				}else {
					int tmpup = up-1;
					int tmpdown = down+1;
					while(true) {
						if(tmpup <= tmpdown) {
							sb.append(arr[up]);
							up--;							
							break;
						}
						if(arr[tmpup] > arr[tmpdown]) {
							sb.append(arr[down]);
							down++;
							break;
						}else if(arr[tmpup] < arr[tmpdown]) {
							sb.append(arr[up]);
							up--;
							break;							
						}else {
							tmpup--;
							tmpdown++;
						}
						
					}
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
