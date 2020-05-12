package day200510;

public class Solution3 {
	static int N = 4;
	static int[] br = { -1, 1, 0, 0 };
	static int[] bc = { 0, 0, -1, 1 };
	static int answer = 0;
	static int solution(int[][] board) {
	      left(0, 0, board);
	      right(0,0,board);
	      up(0,0,board);
	      down(0,0,board);
	      
	      return answer;
	   }
	public static void left(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
//			System.out.println(answer);
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =0; 
			int j =0;
			int next =1; 
			while(j<N) {
				if(next>=N) {
					tmp[i][idx]=arr[i][j];
					break;
				}
				if(arr[i][j]==0) {
					j++; 
					next = j+1; 
					continue;
				}
				else if(arr[i][j]==arr[i][next]) {
					tmp[i][idx]=arr[i][j]+arr[i][next];
					idx++;
					j=next+1; 
					next = j+1; 
				}else if(arr[i][next]==0) {
					next++; 
				}else {// 다를 때  
					tmp[i][idx]=arr[i][j];
					idx++;
					j++; 
					next= j+1; 
				}
			}
		}
//		System.out.println("left "+cnt);
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	public static void right(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =N-1; 
			int j = N-1; 
			int next = j-1; 
			while(j>=0) {
				if(next<0) {
					tmp[i][idx]=arr[i][j];
					break;
				}
				if(arr[i][j]==0) {
					j--;
					next = j-1; 
					continue; 
				}
				if(arr[i][j]==arr[i][next]) {
					tmp[i][idx]=arr[i][j]+arr[i][next];
					idx--;
					j=next-1; 
					next = j-1; 
				}else if(arr[i][next]==0) {
					next--; 
				}else { 
					tmp[i][idx]=arr[i][j];
					idx--;
					j--; 
					next= j-1;  
				}
			}
		}
//		System.out.println("right "+cnt);
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	public static void up(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
			
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =0; 
			int j = 0; 
			int next = 1; 
			while(j<N) {
				if(next>=N) {
					tmp[idx][i]= arr[j][i];
					break;
				}
				if(arr[j][i]==0) {
					j++; 
					next = j+1; 
					continue;
				}
				 if(arr[j][i]==arr[next][i]) {
					tmp[idx][i]= arr[j][i]+arr[next][i];
					idx++; 
					j=next+1; 
					next = j+1; 
				}
				else if(arr[next][i]==0) {
					next++; 
				}else { 
					tmp[idx][i]=arr[j][i];
					idx++;
					j++; 
					next= j+1; 
				}
				
			}
		}
//		System.out.println("up "+cnt);
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	
	public static void down(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
			return; 
		}
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			int idx =N-1; 
			int j = N-1; 
			int next = j-1; 
			while(j>=0) {
				if(next<0) {
					tmp[idx][i]=arr[j][i];
					break;
				}
				if(arr[j][i]==0) {
					j--; 
					next = j-1; 
					continue; 
				}
				else if(arr[j][i]==arr[next][i]) {
					tmp[idx][i]=arr[j][i]+arr[next][i];
					idx--;
					j=next-1; 
					next = j-1; 
				}else if(arr[next][i]==0) {
					next--; 
				}else { 
					tmp[idx][i]=arr[j][i];
					idx--;
					j--; 
					next= j-1; 
				}
			}
		}
//		System.out.println("down "+cnt);
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	public static void main(String[] args) {
		int board[][] = {{2,4,8,2},{2,2,2,2},{0,4,2,4},{2,2,2,4}};
		System.out.println(solution(board));
	}
	
}
