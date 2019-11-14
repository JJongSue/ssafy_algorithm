package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17245{
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("test.dat"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long map[][] = new long[N][N];
		long max = 0;
		long sum = 0;
		//System.out.println(N);
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				map[i][j] = Long.parseLong(st.nextToken());
				//System.out.println(map[i][j]);
				max = Math.max(map[i][j], max);
				sum += map[i][j];
			}
		}
		long ans = max;
		/*long a = 1000;//(1000*1000*10_000_000);
		a = a*a;
		a = a*10000000;
		a = a/2;
		System.out.println(a);
		System.out.println(ans);*/
		long left=0, right = max;
		//long lastmid = -1;
		while(left<=right) {
			long mid = (right-left)/2+left;
			//if(lastmid == mid) break;
			//System.out.println(mid);
			long find=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(mid > map[i][j]) find+=map[i][j];
					else find+=mid;
					
				}
			}
			//lastmid = mid;
			if(find*2>=sum) {
				ans = mid;
				right = mid-1;
			}else {
				left=mid+1;
			}
			
		}
		System.out.println(ans);
		
		
		
	}
}
