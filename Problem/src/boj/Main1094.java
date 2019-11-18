package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		pq.add(64);
		int sum = 64;
		while(sum != N) {
			//System.out.println(sum);
			if(sum-pq.peek()/2 >= N) {
				int tmp = pq.poll();
				sum -= (tmp/2);
				pq.add(tmp/2);
			}else {
				int tmp = pq.poll();
				pq.add(tmp/2);
				pq.add(tmp/2);
			}
		}
		System.out.println(pq.size());
		
		
		
	}
}
