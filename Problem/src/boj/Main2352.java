package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2352 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[40001][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i=1;i<=N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i][0] =tmp;			
			for(int j=0;j<i;j++) {
				if(arr[j][0] < tmp) arr[i][1] = Math.max(arr[i][1], arr[j][1]+1);
				
			}
			ans = Math.max(ans, arr[i][1]);
		}
		System.out.println(ans);
		
	}
}
