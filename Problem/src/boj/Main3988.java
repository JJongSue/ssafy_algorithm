package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3988 {
	static int N, K;
	static int arr[];
	static int cha[];
	static int ans = Integer.MAX_VALUE;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		cha = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int nk = N-K;
		for(int i=0;i+nk-1<N;i++) {
			int first = i;
			int last = i+nk-1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<nk-1;j++) {
				min = Math.min(min, arr[i+j+1]-arr[i+j]);
			}
			ans = Math.min(ans, arr[last]-arr[first]+min);
		}
		
		
		System.out.println(ans);
		
	}
	static void set_num(int size, int first, int last) {
		if(size == K) {
			int tmp = arr[last] - arr[first];
			int min = Integer.MAX_VALUE;
			for(int i=first;i<last;i++) {
				min = Math.min(min, arr[i+1]-arr[i]);
			}
			ans = Math.min(ans, tmp+min);
			return;
		}
		int f = arr[first+1] - arr[first];
		int l = arr[last] - arr[last-1];
		if(f > l) {
			set_num(size+1, first+1, last);
		}else if(f<l){
			set_num(size+1, first, last-1);
		}else {
			set_num(size+1, first+1, last);
			set_num(size+1, first, last-1);
		}
	}
	
}
