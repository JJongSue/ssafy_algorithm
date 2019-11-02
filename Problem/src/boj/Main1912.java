package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sumarr[] = new int[N];
		int arr[] = new int[N];
		arr[0] = Integer.parseInt(st.nextToken());
		sumarr[0] = arr[0];
		int max = arr[0];
		int maxi = 0;
		int min = Math.min(0, arr[0]);
		int sum = arr[0];
		for(int i=1;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumarr[i] = sumarr[i-1]+arr[i];
			sum = Math.max(sum, sumarr[i]-min);
			min = Math.min(min, sumarr[i]);

		}

		System.out.println(sum);
	}
}
