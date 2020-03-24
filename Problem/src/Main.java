import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int A[]; 
	static int B[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(B);
			Arrays.sort(A);
			int L=0;
			long sum = 0;
			for(int i=0;i<N;i++) {
				
				int l = L, r=M-1;
				
				if(A[i] == B[l] || A[i] == B[r]) {
//					System.out.println("same");
					sum += A[i];
					L = i;
					continue;
				}
				if(B[r] < A[i]) {
//					System.out.println(B[r]);
//					System.out.println("big");
					sum += B[r];
					L = r;
					continue;
				}
				if(A[i]<B[l]) {
//					System.out.println(B[l]);
//					System.out.println("small");
					sum += B[l];
					L = l;
					continue;
				}
				while(l<=r) {
					int mid = (l+r)/2;
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
					L = l-1;
					//System.out.println(B[l-1]);
				}else {
					sum += B[l];
					L = l;
					//System.out.println(B[l]);
				}
				
			}
			System.out.println(sum);
			
		}
	}
}
