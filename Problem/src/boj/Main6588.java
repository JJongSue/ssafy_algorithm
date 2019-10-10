package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main6588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		
		prime.add(3);
		hs.add(3);
		for(int i=5;i<=1000000;i++) {
			boolean is_prime = true;
			for(int j=0;j<prime.size();j++) {
				if(prime.get(j)*prime.get(j) > i) break;
				if(i%prime.get(j) == 0) {
					is_prime= false;
					break;
				}
				
			}
			if(is_prime) {
				prime.add(i);
				hs.add(i);
			}
		}
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			boolean is_ok = false;
			for(int i=1;i<prime.size();i++) {
				if( hs.contains(N-prime.get(i)) ) {
					sb.append(N).append(" = ").append(prime.get(i)).append(" + ").append((N-prime.get(i))).append("\n");
					is_ok = true;
					break;
				}
			}
			if(!is_ok) sb.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(sb);
	}
}
