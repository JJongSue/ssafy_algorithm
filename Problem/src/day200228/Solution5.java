package day200228;

import java.util.HashMap;

public class Solution5 {
	static HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
	static HashMap<Double, Integer> hmm = new HashMap<Double, Integer>();
	
	static public int solution(int[][] monsters, int[][] bullets) {
		//x = 0 y +
		int x0yp = 0;
		//x = 0 y -
		int x0ym = 0;
		//x + y=0
		int xpy0 = 0;
		//x - y=0
		int xmy0 = 0;
		
		for(int i=0;i<monsters.length;i++) {
			if(monsters[i][1] == 0) {
				if(monsters[i][0] > 0) xpy0++;
				else xmy0++;
				continue;
			}
			if(monsters[i][0] == 0) {
				if(monsters[i][1] > 0) x0yp++;
				else x0ym++;
				continue;
			}
			double dot = ((double)monsters[i][1])/((double)monsters[i][0]);
			if(monsters[i][1] > 0) {
				if(hm.containsKey(dot)) {
					hm.replace(dot, hm.get(dot)+1);
				}else {
					hm.put(dot, 1);
				}				
			}else {
				if(hmm.containsKey(dot)) {
					hmm.replace(dot, hmm.get(dot)+1);
				}else {
					hmm.put(dot, 1);
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<bullets.length;i++) {
			if(bullets[i][1] == 0) {
				if(bullets[i][0] > 0 && xpy0>0) {
					xpy0--;
					answer++;
//					System.out.println(bullets[i][0] + " "+ bullets[i][1]);
				}
				else if(bullets[i][0] < 0 && xmy0 > 0) {
//					System.out.println(bullets[i][0] + " "+ bullets[i][1]);
					xmy0--;
					answer++;
				}
				continue;
			}
			if(bullets[i][0] == 0) {
				if(bullets[i][1] > 0 && x0yp > 0) {
//					System.out.println(bullets[i][0] + " "+ bullets[i][1]);
					x0yp--;
					answer++;
				}
				else if(bullets[i][1] < 0 && x0ym > 0) {
//					System.out.println(bullets[i][0] + " "+ bullets[i][1]);
					x0ym--;
					answer++;
				}
				continue;
			}
			double dot = ((double)bullets[i][1])/((double)bullets[i][0]);
			if(bullets[i][1] > 0) {
				if(hm.containsKey(dot) && hm.get(dot) > 0) {
//				System.out.println(bullets[i][0] + " "+ bullets[i][1]);
					hm.replace(dot, hm.get(dot)-1);
					answer++;
				}
				
			}else {
				if(hmm.containsKey(dot) && hmm.get(dot) > 0) {
//					System.out.println(bullets[i][0] + " "+ bullets[i][1]);
						hmm.replace(dot, hmm.get(dot)-1);
						answer++;
					}
			}
			
		}
		if(answer == 0) return -1;
		
        return answer;
    }
	
	public static void main(String[] args) {
//		int monsters[][] = {{2,3},{4,5},{3,-3},{2,-4},{3,-6},{-3,-3},{-5,0},{-4,4} };
//		int bullets[][] = {{4,1},{4,6},{1,-2},{-4,-4},{-3,0} };
		int monsters[][] = {{-4,4},{-2,2},{6,2},{0,-2} };
		int bullets[][] = {{3,1},{-1,1},{-1,1},{0,-4},{2,-3} };
//		int monsters[][] = { {1,2},{-2,-1},{1,-2},{3,-1} };
//		int bullets[][] = {{1,0},{2,1} };
		
		System.out.println(solution(monsters, bullets));
	}
}
