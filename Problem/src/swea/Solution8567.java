package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution8567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int arr[][] = new int[3][1000001];
		Arrays.fill(arr[1], 1);
		Arrays.fill(arr[2], -1);
		arr[2][1] = 1;
		arr[2][2] = 2;
		
		int max = 2, idx=2;
		for(int i=1;i<=100000;i++) arr[0][i] = i;
		for(int i=2;i<=100000;i++) {
			int tmp = arr[0][i];
			//if(tmp == 1) continue;
			for(int j=1;j*i<=100000;j++) {
				//arr[0][j*i]/=tmp;
				arr[1][j*i]++;
			}
			if(max<=arr[1][i]) {
				max = arr[1][i];
				idx = i;
				arr[2][i] = i;
			}else {
				arr[2][i] = arr[2][i-1];
			}
			
		}
		System.out.println(arr[1][95000]);
		//System.out.println(arr[2][5]);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ").append(arr[2][N]).append("\n");
		}
		System.out.println(sb);
	}
}
