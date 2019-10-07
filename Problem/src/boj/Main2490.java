package boj;

import java.util.Scanner;

public class Main2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<3;i++) {
			int a = 0;
			for(int j=0;j<4;j++) {
				int tmp = sc.nextInt();
				if(tmp == 0) a++;
			}
			if(a == 1) sb.append("A").append("\n");
			if(a == 2) sb.append("B").append("\n");
			if(a == 3) sb.append("C").append("\n");
			if(a == 4) sb.append("D").append("\n");
			if(a == 0) sb.append("E").append("\n");
			
		}
		System.out.println(sb);
	}
}

