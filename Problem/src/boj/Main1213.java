package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int arr[] = new int[26];
		for(int i=0;i<tmp.length();i++) {
			int ch = tmp.charAt(i) - 'A';
			arr[ch]++;
		}
		if(tmp.length() % 2 == 1) {
			int one = 0;
			int where = -1;
			for(int i=0;i<26;i++) {
				if(arr[i]%2 == 1) {
					one++;
					where = i;
					if(one > 1) break;
					
				}
			}
			if(one > 1) {
				System.out.println("I'm Sorry Hansoo");
			}else{
				
				String ans = "";
				for(int i=0;i<26;i++) {
					char in= (char) (i + 'A');
					for(int j=0;j<arr[i]/2;j++) ans += in; 
				}
				if(one == 1) {
					ans += (char)(where + 'A');
				}
				for(int i=25;i>=0;i--) {
					char in= (char) (i + 'A');
					for(int j=0;j<arr[i]/2;j++) ans += in; 
				}
				
				System.out.println(ans);
			}
		}else {
			int one = 0;
			int where = -1;
			for(int i=0;i<26;i++) {
				if(arr[i]%2 == 1) {
					one++;
					where = i;
					if(one >= 1) break;
					
				}
			}
			if(one >= 1) {
				System.out.println("I'm Sorry Hansoo");
			}else{
				
				String ans = "";
				for(int i=0;i<26;i++) {
					char in= (char) (i + 'A');
					for(int j=0;j<arr[i]/2;j++) ans += in; 
				}
				
				for(int i=25;i>=0;i--) {
					char in= (char) (i + 'A');
					for(int j=0;j<arr[i]/2;j++) ans += in; 
				}
				
				System.out.println(ans);
			}
		}
	}
}
