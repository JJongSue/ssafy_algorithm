package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		int M = sc.nextInt();
		int N = sc.nextInt();
		for(int i=3;i<=N;i++) {
			boolean is_prime = true;
			for(int j=0;j<prime.size();j++) {
				if(prime.get(j)*prime.get(j) > i) break;
				if(i%prime.get(j) == 0) {
					is_prime= false;
					break;
				}
				
			}
			if(is_prime) prime.add(i);
		}
		//for(int p : prime) System.out.print(p+" ");
		long min = Long.MAX_VALUE, sum = 0;
		for(int i=0;i<prime.size();i++) {
			if(prime.get(i) >= M && prime.get(i)<=N) {
				sum+=prime.get(i);
				if(min > prime.get(i)) min = prime.get(i);
			}
			if(prime.get(i) > N) break;
		}
		if(min == Long.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
			
		}
	}
}
