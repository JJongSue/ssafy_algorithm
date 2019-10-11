package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main1153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N < 8)
			System.out.println(-1);
		else if (N == 8)
			System.out.println("2 2 2 2");
		else {
			if (N % 2 == 1) {
				System.out.print("2 3 ");
				N -= 5;
			} else {
				System.out.print("2 2 ");
				N -= 4;
			}
			HashSet<Integer> hs = new HashSet<>();
			ArrayList<Integer> prime = new ArrayList<>();
			prime.add(2);

			prime.add(3);
			hs.add(2);
			hs.add(3);
			for (int i = 5; i <= 1000000; i++) {
				boolean is_prime = true;
				for (int j = 0; j < prime.size(); j++) {
					if (prime.get(j) * prime.get(j) > i)
						break;
					if (i % prime.get(j) == 0) {
						is_prime = false;
						break;
					}

				}
				if (is_prime) {
					prime.add(i);
					hs.add(i);
				}
			}

			boolean is_ok = false;
			for (int i = 0; i < prime.size(); i++) {
				if (hs.contains(N - prime.get(i))) {
					System.out.println(prime.get(i) + " " + (N - prime.get(i)));
					// sb.append(N).append(" = ").append(prime.get(i)).append(" +
					// ").append((N-prime.get(i))).append("\n");
					// is_ok = true;
					break;
				}
			}

		}
	}
}
