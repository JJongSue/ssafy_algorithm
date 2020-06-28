package day200616;

import java.util.Random;

public class Solution1 {
	static int[] solution(int n, int m[][]){
		int ans[] = new int[10];
		int map[] = new int[100];
		Random random = new Random();
		for(int i=0;i<m[0][1];i++) map[i] = m[0][0];
		
		for(int i=1;i<n;i++) {
			m[i][1] = m[i][1]+m[i-1][1];
			for(int j=m[i-1][1];j<m[i][1];j++) {
				map[j] = m[i][0];
			}
			
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(map[i*10+j]);
				
			}System.out.println();
		}
		
		for(int i=0;i<10;i++) {
			ans[i] = map[random.nextInt(100)];
		}
		
//		int ran = random.nextInt(100);
		return ans;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int m[][] = {{1,10},{2,30},{3,60}};
		int ans[] = solution(n, m);
		for(int i=0;i<10;i++) {
			System.out.println(ans[i]);
		}
//		System.out.println(solution(n, m).toString());
	}
}
