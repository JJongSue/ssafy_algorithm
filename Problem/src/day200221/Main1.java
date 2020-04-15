package day200221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int max = Integer.MAX_VALUE;
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.min(max, arr[i]-arr[i-1]);
		}
		System.out.println(max);
	}
}
