package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int arr2[] = new int[N];
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = arr[i];
		}
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int post = arr[0];
		int index = 1;
		hm.put(post, 0);
		for(int i=1;i<N;i++) {
			if(arr[i] != arr[i-1]) {
				hm.put(arr[i], index);
				index++;
				post = arr[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(hm.get(arr2[i])).append(" ");
		}
		System.out.println(sb);
	}
}
