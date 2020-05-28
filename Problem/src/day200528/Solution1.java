package day200528;

public class Solution1 {
	static public int solution(int[] user_times, int T) {
		int answer = 0;
		for(int i=0;i<user_times.length;i++) {
			if(user_times[i]%T != 0) {
				answer = Math.max(answer, T-T%user_times[i]);
			}
		}
		return answer;
		
	}

	public static void main(String[] args) {
		
	}
}
