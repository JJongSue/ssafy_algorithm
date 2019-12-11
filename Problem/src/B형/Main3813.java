package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3813 {
	static int mem[], arr[];
	static int N, K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			//N,K 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());			
			arr = new int[N];
			mem = new int[K];
			
			//arr 입력받음
			st = new StringTokenizer(br.readLine());
			int min = 200000;
			int max = -1;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());	
				if(arr[i] < min) min = arr[i];
				if(arr[i] > max) max = arr[i];
			}
			
			//mem 입력받음
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<K;i++) {
				mem[i] = Integer.parseInt(st.nextToken());				
				
			}
			long start = System.currentTimeMillis();
			int ans = -1;
			while(min <= max) {
				int mid = (max+min)/2;				
				boolean is_ok = true;
				int cur = 0;
				end: for(int i=0;i<N;i++) {
					if(cur == K) break;
					for(int j=0;j<mem[cur];j++) {
						if(i+j>=N) {
							is_ok = false;
							break end;
						}
						if(arr[i+j] <= mid) {
							if(j == mem[cur]-1) {
								cur++;
								i+=j;
								break;								
							}
						}else {
							i+=j;
							break;
						}
						
						
					}
				}
				
				if(K == cur) {
					ans = mid;
					max = mid-1;
				}else {
					min = mid+1;
				}
				
				
				
					
					
				
			}
			long end = System.currentTimeMillis();
			System.out.println("#"+tc+" "+ans);
			System.out.println("time : " + (end-start)/1000.0);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
