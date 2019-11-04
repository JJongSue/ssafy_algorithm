package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10942 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				if(arr[i] == arr[j]) map[i][j] = true;
				//System.out.print((map[i][j] ? 1 : 0) + " ");
			}
			//System.out.println();
		}
		//System.out.println();
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			//System.out.println(a+" "+b);
			if(a == b) System.out.println(1);
			else if(a>b) {
				boolean is_ok = true;
				int iter = 0;
				while(a-iter >= (a+b)/2){
					is_ok = is_ok&map[b+iter][a-iter];
					iter++;
				}
				System.out.println(is_ok? 1:0);
			}else {
				boolean is_ok = true;
				int iter = 0;
				while(b-iter >= (a+b)/2){
					is_ok = is_ok&map[a+iter][b-iter];
					if(!is_ok) break;
					iter++;
				}
				System.out.println(is_ok? 1:0);
			}
		}
	}
}
