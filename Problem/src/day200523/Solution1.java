package day200523;

public class Solution1 {
	static public String solution(String[] strs) {
		String answer = "";
		int min = 1000;
		for(int i=0;i<strs.length;i++) min = Math.min(strs[i].length(), min);
		for(int i=0;i<min;i++) {
			char ch = strs[0].charAt(i);
			boolean ok = true;
			for(int j=1;j<strs.length;j++) {
				if(ch != strs[j].charAt(i)) {
					ok = false;
					break;
				}
			}
			if(ok) answer += ch;
			else break;
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
//		String strs[] = {"abcaefg", "abcdefg", "abcdhfg"};
		String strs[] = {"a","b","c"};
		System.out.println(solution(strs));
	}
}
