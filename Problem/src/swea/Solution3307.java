package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3307 {
	static class pair{
		int first;
		int second;
		public pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++) {
			int N = sc.nextInt();
			int arr[][] = new int[N+1][2];
			ArrayList<Integer> al = new ArrayList<>();
			al.add(0);
			for(int i=1;i<=N;i++) arr[i][0]= sc.nextInt();
			int ans = 0;
			for(int i=1;i<=N;i++) {
				//int max = 0;
				arr[i][1]=1;
				for(int j=0;j<al.size();j++) {
					if(al.get(j)>=arr[i][0]) break;
					arr[i][1]=j+2;
				}
				/*for(int j=0;j<i;j++) {
					if(arr[i][0] > arr[j][0] && max < arr[j][1]+1) {
						max = arr[j][1]+1;
					}
				}*/
				
				//arr[i][1]=max;
				if(al.size() == arr[i][1]) {
					if(al.get(arr[i][1]-1) > arr[i][0]) al.set(arr[i][1]-1, arr[i][0]);						
					
				}else if(al.size() < arr[i][1]){
					al.add(arr[i][0]);
				}
				//ans = Math.max(arr[i][1], ans);
			}
			//System.out.println("#"+tc+" "+ans);
			System.out.println("#"+tc+" "+(al.size()-1));
			//System.out.println(al.get(al.size()-1));
		}
	}
}
