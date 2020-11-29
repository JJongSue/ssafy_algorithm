package day200913;

public class Solution1 {
	static int solution(int[][] boxes) {
		int size = boxes.length;
		int cnt[] = new int[size];
		
		for(int i=0;i<size;i++) {
			int a = boxes[i][0];
			int b = boxes[i][1];
			if(a-1 < size) {
				cnt[a-1]++;
			}
			if(b-1 < size) {
				cnt[b-1]++;
			}
		}
		int answer = 0;
		for(int i=0;i<size;i++) {
			if(cnt[i] < 2) {
				answer += (2-cnt[i]);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
//		int boxes[][] = {{1,2}, {2,1}, {3,3},{4,5},{5,6},{7,8} };
//		int boxes[][] = {{1,2}, {3,4}, {5,6} };
		int boxes[][] = {{1,2}, {2,3}, {3,1} };
		System.out.println(solution(boxes));
	}
}
