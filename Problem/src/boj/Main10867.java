package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10867 {
	static int arr[] = new int[2001]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken()) + 1000;
			arr[tmp]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<=2000;i++) {
			if(arr[i] > 0) sb.append((i-1000)).append(" ");
		}
		System.out.println(sb);
	}
}
