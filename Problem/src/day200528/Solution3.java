package day200528;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution3 {
	/*
	 * 규격 여부 확인
	 * 차단 여부확인
	 * IP주소 확인
	 * 
	 */
	static HashSet<String> ban, reg;
	
	
	static public int[] solution(String[] ip_addresses, String[] registered_list, String[] banned_list) {
		int[] answer = new int[ip_addresses.length];
		
		ban = new HashSet<>();
		reg = new HashSet<>();
		
		for(int i=0;i<registered_list.length;i++) {
			reg.add(registered_list[i]);
		}
		
		for(int i=0;i<banned_list.length;i++) {
			ban.add(banned_list[i]);
		}
		
		for(int i=0;i<ip_addresses.length;i++) {
			String IP = ip_addresses[i];
			if(is_ip(IP)) {
				answer[i] = 1;
				continue;
			}
			if(is_block(IP)) {
				answer[i] = 3;
				continue;
			}
			if(!is_in(IP)) {
				answer[i] = 2;
			}
			
		}
		
		return answer;
	}
	
	static boolean is_ip(String IP) {

		StringTokenizer st = new StringTokenizer(IP, "..");
//		System.out.println(IP);

		if(IP.contains("..")) {
//			System.out.println(IP);
//			System.out.println("not");
			return true;
		}
		st = new StringTokenizer(IP, ".");
		int cnt = st.countTokens();
//		System.out.println(IP);
//		System.out.println(st.countTokens());
		if(cnt != 4) return true;
		for(int i=0;i<4;i++) {
			try {
				String tmp = st.nextToken();
				int num = Integer.parseInt(tmp);
				if(num < 0 || num > 255) return true;
				if(num == 0 && tmp.length() == 1) continue;
				int tmpcnt = 0;
				while(num != 0) {
					tmpcnt++;
					num = num/10;
				}
//				System.out.println(" "+tmp+" "+tmpcnt);
				
				if(tmp.length() != tmpcnt) {
					return true;
				}
			}catch (Exception e) {
				return true;
			}
		}
		if(IP.charAt(IP.length()-1) == '.') return true;
		return false;
	}
	
	static boolean is_block(String IP) {
		if(ban.contains(IP)) return true;
		return false;
	}
	
	static boolean is_in(String IP) {
		if(reg.contains(IP)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		int arr[];
//		String ip[] = {"1..1","1.1.1","1,1,1,1","","1.1.1.1"};
//		String ip[] = {"123.023.123.123", "1.1.1.12", "119.123.45.39", "127.0.0.1"};
		String ip[] = {"115.86.56.15", "123.12.2.1.", "...", "255.255.1.256", "5*6.123.123.123"};
//		String reg1[] = {"119.123.45.39"};
		String reg1[] = {"115.86.56.15"};
//		String ban1[] = {"1.1.1.12"};
		String ban1[] = {"123.12.2.1"};
		
		arr = solution(ip, reg1, ban1);
		System.out.println();
		for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
		
	}
	
}
