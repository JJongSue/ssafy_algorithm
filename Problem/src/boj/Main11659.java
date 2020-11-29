package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int size = 1;
		for(size=1;size<N;size=size<<1);
		int max = size * 2 + 1;
		int arr[] = new int[max];
		for(int i=0;i<N;i++) {
			arr[i+size] = Integer.parseInt(st.nextToken());
		}
		int tmp = size >> 1;
		while(tmp != 1) {
			for(int i=tmp;i<tmp*2;i++) {
				arr[i] = arr[((i)<<1)] + arr[(i<<1)+1]; 
			}
			tmp = (tmp >> 1);
		}
		arr[1] = arr[2]+arr[3];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1 + size;
			int b = Integer.parseInt(st.nextToken()) - 1 + size;
//			System.out.println(a+" " + b);
			if(b<a) {
				int tt = b;
				b = a;
				a = tt;
			}
			int sum = 0;
			while(a<b) {
				if(a % 2 == 1) sum += arr[a];
				a = ((a+1)>>1);
				
				if(b%2 == 0) sum += arr[b];
				b = ((b-1)>>1);
			}
			if (a == b) sum += arr[a];
//			System.out.println(sum);
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
}
