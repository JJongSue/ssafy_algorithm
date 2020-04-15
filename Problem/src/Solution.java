
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class pair implements Comparable<pair>{
		int s;
		int e;
		public pair(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if(o.e == this.e){
				return o.s-this.s;
			}
			return this.e - o.e;
		}
		
	}
	
	static public int solution(int[][] routes) {
        int answer = 0;
        pair pm[] = new pair[routes.length];
        for(int i=0;i<routes.length;i++) {
        	pm[i] = new pair(routes[i][0], routes[i][1]);
        }
        Arrays.sort(pm);
        answer++;
        int max = pm[0].e;
        
        for(int i=1;i<routes.length;i++) {
        	//System.out.println(pm[i].s + " " + pm[i].e+" "+max);
        	if( pm[i].s <= max && pm[i].e >= max) continue;
        	answer++;
        	max = pm[i].e;
        }
        
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		//int puddles[][] = {{2,2}};
		int routes[][] = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println(solution(routes));
	}
	
	
	

}
