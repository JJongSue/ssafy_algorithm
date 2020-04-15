package day200228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
	static public String solution(String s1, String s2) {
		int max_length = Math.min(s1.length(), s2.length());
		long hash1 = 0, hash2 = 0;
		
		int ans_size1 = -1;
		
		long mul = 1;
		for(int i=0;i<max_length;i++) {
			hash1 = hash1 * 5381 + s1.charAt(i) - 'A';
			hash2 = hash2 + (s2.charAt(s2.length()-1-i) - 'A')*mul ;
			mul *= 5381;
			if(hash1 == hash2) {
				ans_size1 = i;
			}
		}
		hash1 = 0;
		hash2 = 0;
		mul = 1;
		int ans_size2 = -1;
		for(int i=0;i<max_length;i++) {
			hash2 = hash2 * 5381 + s1.charAt(s1.length()-1-i) - 'A';
			hash1 = hash1 + (s2.charAt(i) - 'A')*mul ;
			mul *= 5381;
			if(hash1 == hash2) {
				ans_size2 = i;
			}
		}
		//System.out.println(ans_size1 + " " + ans_size2);
		String answer = "";
		if(ans_size1 == -1 && ans_size2 == -1 ) {
			int cmp = s1.compareTo(s2);
			if(cmp > 0) {
				answer = s2+s1;
			}else {
				answer = s1+s2;
			}
			return answer;
		}
		if(ans_size1 == ans_size2) {
			int cmp = s1.compareTo(s2);
			if(cmp > 0) {
				answer = s2;
				for(int i = ans_size1+1;i<s1.length();i++) {
					answer += s1.charAt(i);
				}
			}else {
				answer = s1;
				for(int i = ans_size1+1;i<s2.length();i++) {
					answer += s2.charAt(i);
				}
			}
			return answer;
		}
		
		if(ans_size1 < ans_size2) {
			answer = s1;
			for(int i=ans_size2+1;i<s2.length();i++) answer += s2.charAt(i);
			return answer;
		}
		answer = s2;
		for(int i=ans_size1+1;i<s1.length();i++) answer += s1.charAt(i);
		return answer;
		
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println(solution(s1, s2));
		
	}
}
