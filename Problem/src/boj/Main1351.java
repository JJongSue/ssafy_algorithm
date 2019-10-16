package boj;

import java.util.HashMap;
import java.util.Scanner;

public class Main1351 {
	static HashMap<Long, Long> hm;
	static long P, Q;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		hm = new HashMap<>();
		hm.put((long) 0, (long) 1);
		hm.put((long) 1, (long) 2);
		long N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		long ans = find_num(N);
		
		System.out.println(ans);
	}
	static long find_num(long x) {
		if(hm.containsKey(x)) {
			return hm.get(x);
		}
		long ans1 = find_num(x/P);
		long ans2= find_num(x/Q);
		hm.put(x, ans1+ans2);
		return ans1+ans2;
	}
}
