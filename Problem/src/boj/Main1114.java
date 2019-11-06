package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1114 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Integer cut[] = new Integer[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) cut[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(cut);
		
		
		int l = 0;
		
	}
}
