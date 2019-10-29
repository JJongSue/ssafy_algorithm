package boj;

import java.util.Scanner;

public class Main17293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int first = N;
		while(N >= 0) {
			if(N == 0) {
				System.out.print("No more bottles of beer on the wall, no more bottles of beer.\n" + 
						"Go to the store and buy some more, ");
				if(first == 1) {
					System.out.println(first+" bottle of beer on the wall.");
				}else {
					System.out.println(first+" bottles of beer on the wall.");
				}
				
			}else if(N == 1) {
				System.out.println("1 bottle of beer on the wall, 1 bottle of beer.\n" + 
						"Take one down and pass it around, no more bottles of beer on the wall.");
				System.out.println();
			}else {
				System.out.print(N+" bottles of beer on the wall, "+N+" bottles of beer.\n" + 
						"Take one down and pass it around, ");
				if(N-1 == 1) System.out.print("1 bottle ");
				else System.out.print((N-1)+" bottles ");
				System.out.println("of beer on the wall.");		
				System.out.println();
			}
			N--;
		}
	}
}
