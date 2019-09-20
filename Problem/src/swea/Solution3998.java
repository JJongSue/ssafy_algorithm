package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3998 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int [][]arr = new int[N][3];
			for(int i=0;i<N;i++) {
				arr[i][0]=Integer.parseInt(st.nextToken());
			}
			arr[N-1][2]=N;
			int sum = 0;
			for(int i=N-2;i>=0;i--) {
				for(int j=i+1;j<N;j++) {
					if(arr[i][0] > arr[j][0]) {
						arr[i][1] += (arr[j][1]+1);	
						if(arr[j][2] == N) break;
						j=arr[j][2]-1;
					}else{
						arr[i][2]=j;						
					}
					
				}
				if(arr[i][2]==0) arr[i][2]=N-1;
				sum+=arr[i][1];
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
