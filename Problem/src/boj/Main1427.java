package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1427 {
	static PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {

		@Override
		public int compare(Character o1, Character o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
		
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		for(int i=0;i<tmp.length();i++) {
			pq.add(tmp.charAt(i));
		}
		while(!pq.isEmpty()) {
			System.out.print(pq.poll());			
		}
	}
}
