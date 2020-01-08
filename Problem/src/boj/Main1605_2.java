package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1605_2 {
	static PriorityQueue<Long> pq = new PriorityQueue<>(); 
	static String str;
	static int ans = 0;
	static int N;
	static boolean chekc(int L) {
		long hash = 0;
		long D = 5381, DN = 1;
		
		for(int i=0;i<L;i++) {
			int ch = str.charAt(i) - 'a';
			hash = hash * D + ch;
			DN *= D;
		}
		pq.add(hash);
		
		for(int i =L;i<str.length();i++) {
			int ch1 = str.charAt(i)-'a';
			int ch2 = str.charAt(i-L)-'a';
			hash = hash * D + (ch1) - (ch2 * DN);
			pq.add(hash);
		}
		hash = pq.poll();
		while(!pq.isEmpty()) {
			long tmp = pq.poll();
			if(tmp == hash) {
				pq.clear();
				return true;
			}
			hash = tmp;
		}
		return false;
	}
	static void binary_search() {
		int left = 0;
		int right = N;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			boolean sh = chekc(mid);
			if(!sh) {
				right = mid -1;
			}else {
				ans = mid;
				left = mid+1;
			}
		
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		binary_search();
		System.out.println(ans);
	}
}
