import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println((int) Math.pow(2, N) - 1);
		if (N <= 20) {
			hanoi(N, 1, 2, 3);
		}
		
	}

	static void hanoi(int n, int from, int by, int to) {
		if (n == 1) {
			System.out.println(from+" "+to);
//			return;
		} else {
			hanoi(n - 1, from, to, by);
			System.out.println(from+" "+to);
			hanoi(n - 1, by, from, to);
		}
	}

}
