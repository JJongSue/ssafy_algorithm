package boj;

import java.util.Random;

public class Main10212 {
	public static void main(String[] args) {
		int cnt = (int)(Math.random()*10)%2;
		if(cnt == 0) {
			System.out.println("Korea");
		}else {
			System.out.println("Yonsei");
		}
	}
}
