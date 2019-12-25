package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main3080_3 {
	static PriorityQueue<String> pq = new PriorityQueue<String>();
	static int arr[] = new int[3001];
	static long ans = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) pq.add(br.readLine());
		for(int i=0;i<3001;i++) arr[i] = 1;
		
		String first = "";//pq.poll();
		String second = pq.poll();
		int post = 3000;
		//System.out.println(second);
		while(!pq.isEmpty()) {
			first = second;
			second = pq.poll();
			//System.out.println(first);
			//System.out.println(second);
			//System.out.println();
			int min = Math.min(first.length(), second.length());
			boolean is_end = false;
			for(int j=0;j<min;j++) {
				if(first.charAt(j) != second.charAt(j)) {
					if(post>j) {
						for(int i=j+1;i<=post;i++) arr[i] = 1;
						//arr[post] = 1;
					}
					arr[j]++;
					post = j;
					//System.out.println(j);
					ans = (ans*arr[j])% 1_000_000_007;
					is_end = true;
					break;
				}
			}
			if(!is_end) {
				if(post > min) {
					for(int i=min+1;i<=post;i++) arr[i] = 1;
					//arr[post] = 1;
				}
				arr[min]++;
				post = min;
				//System.out.println(min);
				ans = (ans*arr[min])% 1_000_000_007;
			}
		}
		//System.out.println(second);
		
		System.out.println(( ans%1_000_000_007));
	}
}
