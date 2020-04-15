package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3896 {
	static boolean is_prime[] = new boolean[1299710];
	static int left[] =  new int[1299710], right[] = new int[1299710];
	static int cnt[] = new int[1299710];
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i=4;i<1299710;i+=2) {
			is_prime[i] = true;
		}
		for(int i=3;i*2<=1299710;i+=2) {
			for(int j=2;i*j<1299710;j++) {
				is_prime[i*j] = true;
			}
		}
		int p = 2;
		for(int i=2;i<1299710;i++) {
			if(!is_prime[i]) p = i;
			left[i] = p;
		}
		p = 1299709;
		for(int i=1299709;i>=2;i--) {
			if(!is_prime[i]) p = i;
			right[i] = p;
		}
		
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int tmp = Integer.parseInt(br.readLine());
			if(is_prime[tmp]) {
				System.out.println(right[tmp]-left[tmp]);
			}else {
				System.out.println(0);
			}
		}
	}
}
