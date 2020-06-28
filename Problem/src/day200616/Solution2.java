package day200616;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {	
	static int ans[][];
	static int min = Integer.MAX_VALUE;
	static boolean is_visit[];
	static int[][] solution(int n, int m[][]){		
		ans = new int[n/2][2];
		int voidans[][] = new int[n/2][2];
		is_visit = new boolean[n];
		
		Arrays.sort(m, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		for(int i=0;i<n;i++) System.out.println(m[i][0] + " " + m[i][1]);
		System.out.println();
		find(n, voidans, 0, m, 0);
		
		
		
		return ans;
	}
	
	static void find(int cnt, int voidans[][], int sum, int m[][],int now) {
		System.out.println(cnt);
		if(sum > min) return;
		if(cnt == 0 || cnt == 1) {
			if(sum < min) {
				sum = min;
				for(int i=0;i<voidans.length;i++) {
					ans[i][0] = voidans[i][0];
					ans[i][1] = voidans[i][1];
				}
			}
			return;
		}
		int first = 0;
		for(int i=0;i<voidans.length;i++) {
			if(!is_visit[i]) {
				first = i;
				break;
			}
		}
		int temp[][] = new int[m.length][3];
		int tempcnt = 0;
		int tempmin = Integer.MAX_VALUE;
		System.out.println("first"+first);
		for(int i=first;i<m.length;i++) {
			System.out.println(i+"asdfafdsa");
			if(is_visit[i]) continue;
			for(int j=i+1;j<m.length;j++) {
				if(is_visit[j]) continue;
				temp[tempcnt][0] = i;
				temp[tempcnt][1] = j;
				temp[tempcnt][2] = m[j][1] - m[i][1];
				tempmin = Math.min(tempmin, temp[tempcnt][2]);
				System.out.println(i + " ddd " + j+" "+tempmin);
				tempcnt++;
				i = j-1;
				break;
			}
		}
		System.out.println(tempmin);
		
		for(int i=0;i<tempcnt;i++) {
			if(temp[i][2] == tempmin) {
				voidans[now][0] = m[temp[i][0]][0];
				voidans[now][1] = m[temp[i][1]][0];
				System.out.println(temp[i][0] + " " + temp[i][1]);
				is_visit[temp[i][0]]=true;
				is_visit[temp[i][1]]=true;
				find(cnt-2,voidans, sum+tempmin, m, now+1);
				is_visit[temp[i][0]]=false;
				is_visit[temp[i][1]]=false;
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
//		int n = 5;
//		int m[][] = {{1,342},{2,538},{3,624},{4,984},{5,525}};
		int n = 4;
		int m[][] = {{1,1},{2,3},{3,4},{4,5}};
		int anss[][] = solution(n, m);
		System.out.println();
		for(int i=0;i<anss.length;i++) {
			System.out.println(anss[i][0] + " " + ans[i][1]);
		}
	}
}
