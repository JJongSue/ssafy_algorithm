package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17124 {
	static int N, M;
	static int A[] = new int[1_000_001]; 
	static int B[] = new int[1_000_001];;
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//A = new int[N];
			//B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());
			for(int i=M;i<1_000_001;i++) B[i] = Integer.MAX_VALUE;
			
			Arrays.sort(B);
			long sum = 0;
			for(int i=0;i<N;i++) {
				
				int l = 0, r=M-1;
				
				if(A[i] == B[l] || A[i] == B[r]) {
//					System.out.println("same");
					sum += A[i];
					continue;
				}
				if(B[r] < A[i]) {
//					System.out.println(B[r]);
//					System.out.println("big");
					sum += B[r];
					continue;
				}
				if(A[i]<B[l]) {
//					System.out.println(B[l]);
//					System.out.println("small");
					sum += B[l];
					continue;
				}
				while(l<=r) {
					int mid = l+r;
					if(B[mid] == A[i]) {
						l = mid;
						break;
					}else if(B[mid] < A[i]) {
						l = mid+1;
					}else {
						r = mid-1;
					}	
				}
				//System.out.println(A[i] + " " + l + " " + B[l]);

				if( 0<=l-1 && Math.abs(A[i]-B[l-1]) <= Math.abs(A[i]-B[l]) ) {
					sum += B[l-1];
					//System.out.println(B[l-1]);
				}else {
					sum += B[l];
					//System.out.println(B[l]);
				}
				
			}
			System.out.println(sum);
			
		}
	}
}
