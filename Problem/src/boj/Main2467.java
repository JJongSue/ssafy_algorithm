package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2467 {
	static int N, ans;
	static int arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		int l = 0, r = N-1;
		int ans_l = 0, ans_r = N-1;
		ans = arr[l]+arr[r];
		int min = Math.abs(ans);
		while(true) {
			if(r-l == 1 ) break;
			if(ans == 0 ) {
				ans_l = l;
				ans_r = r;
			}
			if(ans > 0) r--;
			else l++;
			ans = arr[l]+arr[r]; 
			if( Math.abs(ans) < min) {
				min = Math.abs(ans);
				ans_l = l;
				ans_r = r;
			}
		}
		System.out.println(arr[ans_l] + " " + arr[ans_r]);
		
	}
	
}
