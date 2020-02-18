package day200213;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
	static PriorityQueue<pair> gpq = new PriorityQueue<pair>();
	static PriorityQueue<pair> cpq = new PriorityQueue<pair>();
	static int solution(int[][] goods, int[][] coupons) {
        int answer = 0;
        for(int i=0;i<goods.length;i++) {
        	gpq.add(new pair(goods[i][0], goods[i][1]));
        }
        for(int i=0;i<coupons.length;i++) {
        	cpq.add(new pair(coupons[i][0], coupons[i][1]));
        }

        
        while(!cpq.isEmpty()) {
        	if(gpq.isEmpty()) break;
        	int per = 100-cpq.peek().first;
        	int cnt = cpq.poll().second;
        	
        	while(cnt != 0) {
        		pair tmp = gpq.poll();
        		if(cnt - tmp.second >= 0) {
        			answer += (((tmp.first * per)/100)*tmp.second );
        			cnt -= tmp.second;
        		}else {
        			answer += (((tmp.first * per)/100)*(tmp.second-cnt) );
        			gpq.add(new pair(tmp.first, tmp.second-cnt));
        			cnt = 0;
        		}
        	}
        }
        

        while(!gpq.isEmpty()) {
        	answer += (gpq.peek().first*gpq.poll().second);
        }

        return answer;
	}
	
	static class pair implements Comparable<pair>{
		int first;
		int second;
		public pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int compareTo(pair o) {
			if(this.first == o.first) {
				return o.second - this.second;
			}
			return o.first - this.first;
		}
	}
	public static void main(String[] args) {
//		int goods[][] = {{25400,2},{10000,1},{31600,1}};
//		int coupons[][] = {{5,3},{23,2},{11,2},{9,5}};
		int goods[][] = {{3100,2},{7700,1},{3100,2}};
		int coupons[][] = {{33,4}};
		int s = solution(goods, coupons);
		System.out.println(s);
	}
}
