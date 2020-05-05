package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main11652_2 {
	static HashMap<Long, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(get_hash(2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int anscnt = 0;
		long ans = Long.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			long input = Long.parseLong(br.readLine());
			if(hm.containsKey(input)) {
				hm.put(input, hm.get(input)+1);
			}else {
				hm.put(input, 1);
			}
			if(anscnt < hm.get(input)) {
				anscnt = hm.get(input);
				ans = input;
			}else if(anscnt == hm.get(input) && input < ans) {
				ans = input;
			}
		}
		System.out.println(ans);
		
		
	}
}
