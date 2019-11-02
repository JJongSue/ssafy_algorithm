package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int arr[] = new int [100001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) arr[Short.parseShort(br.readLine())]++;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<10001;i++) {
			for(int j=0;j<arr[i];j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
