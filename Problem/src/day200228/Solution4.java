package day200228;

public class Solution4 {
	static public int solution(int[] bricks) {
		int larr[] = new int[bricks.length];
		int rarr[] = new int[bricks.length];
		int max = 0;
		for(int i=0;i<bricks.length;i++) {
			larr[i] = max;
			max = Math.max(max, bricks[i]);
		}
		int answer = 0;
		max = 0;
		for(int i=bricks.length-1;i>=0;i--) {
			larr[i] = Math.min(larr[i], max);
			//rarr[i] = max;
			max = Math.max(max, bricks[i]);
		}
		
		for(int i=0;i<bricks.length;i++) {
			if(larr[i] > bricks[i]) answer += (larr[i]-bricks[i]);
		}
		
		
        return answer;
    }
	
	public static void main(String[] args) {
		int bricks[] = {0,2,0,1,3,1,2,0,1,0,2,0};
		//int bricks[] = {1,2,3,4,5,6,7};
		//int bricks[] = {1};
		//int bricks[] = {0,0,0,0,0};
		System.out.println(solution(bricks));
	}
}
