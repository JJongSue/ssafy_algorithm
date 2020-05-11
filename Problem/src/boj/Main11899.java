package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11899 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		short left = 0;
		short right = 0;
		for(short i=0;i<str.length;i++) {
			if(str[i] == '(') {
				left++;
			}else {
				if(left == 0) right++;
				else left--;
			}
		}
		System.out.println(left+right);
	}
}
