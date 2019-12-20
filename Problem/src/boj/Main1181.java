package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1181 {
	static PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if(o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length()-o2.length();
		}
	});

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			pq.add(tmp);
		}
		String last = "";
		while(!pq.isEmpty()) {
			String tmp = pq.poll();
			if(!last.equals(tmp)) {				
				System.out.println(tmp);
				last = tmp;
			}
		}
		
	}
}

