package day200523;

public class Solution3 {
	static public int solution(int[][] board) {
		int s = board.length; 
		int cboard[][] = new int[s][s];
		for(int ci=0;ci<s;ci++) for(int cj=0;cj<s;cj++) cboard[ci][cj] = board[ci][cj];
		
		int answer = 0;  
		for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++) {
				if(board[i][j] == 0) continue;
				int tmp = 0;
				for(int ci=0;ci<s;ci++) for(int cj=0;cj<s;cj++) cboard[ci][cj] = board[ci][cj];
				
				cboard[i][j] = 0;
				down(cboard);
				int cnt = distory(cboard);
//				if(cnt == 0) continue;
				tmp = cnt + 1;
				while(cnt != 0) {
					down(cboard);
					cnt = distory(cboard);
					tmp+= cnt;
				}
				answer = Math.max(tmp, answer);
			}
		}
		
		return answer;
	   }
	
	
	static void down(int[][] board) {
		int s = board.length;
		
		for(int j=0;j<s;j++) {
			
			for(int i=s-1;i>=0;i--) {
				boolean nothing = false;
				if(board[i][j] == 0) {
					nothing = true;
					for(int k=i-1;k>=0;k--) {
						if(board[k][j] != 0) {
							nothing = false;
							board[i][j] = board[k][j];
							board[k][j] = 0;
							i = k+1;
							break;
						}
					}
					
				}
				if (nothing) {
					break;
				}
			}
		}
	}
	
	
	static int distory(int board[][]) {
		int s = board.length;
		
		for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++) {
				if(board[i][j] == 0) continue;
				int now = board[i][j];
				int cnt = 1;
				for(int k=j+1;k<s;k++) {
					if(Math.abs(board[i][k]) == Math.abs(now)) {
						cnt++;
						if(k == s-1 && cnt >= 3) {
							for(int l=j;l<s;l++) {
								board[i][l] = Math.abs(board[i][k]) * -1;
							}
						}
					}else {
						if(cnt >= 3) {
							for(int l=j;l<k;l++) {
								board[i][l] = Math.abs(board[i][k]) * -1;
							}
						}
						j = k-1;
						break;
					}
				}
				
			}
		}
		
		for(int j=0;j<s;j++) {
			for(int i=0;i<s;i++) {
				if(board[i][j] == 0) continue;
				int now = board[i][j];
				int cnt = 1;
				for(int k=i+1;k<s;k++) {
					if(Math.abs(board[k][j]) == Math.abs(now)) {
						cnt++;
						if(k == s-1 && cnt >=3 ) {
							for(int l=i;l<s;l++) {
								board[l][j] = Math.abs(board[k][j]) * -1;
							}
						}
					}else {
						if(cnt >= 3) {
							for(int l=i;l<k;l++) {
								board[l][j] = Math.abs(board[k][j]) * -1;
							}
						}
						i = k-1;
						break;
					}
				}
				
			}
			
		}
		int dis = 0;
		for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++) {
				if(board[i][j]< 0) {
					board[i][j] = 0;
					dis++;
				}
			}
		}
		return dis;
		
		
		
	}
	static void printb(int board[][]) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
//		int board[][] = {{1,1,3,3},{4,1,3,4},{1,2,1,1},{2,1,3,2}};
//		int board[][] = {{1,1,3,3},{4,1,3,4},{1,2,1,1},{0,0,0,0}};
		int board[][] = {{1,1,3,3},{4,1,3,4},{1,2,1,1},{2,1,3,2}};
		System.out.println(solution(board));
//		down(board);
//		printb(board);
//		System.out.println();
//		distory(board);
//		printb(board);
//		System.out.println();
//		down(board);
//		printb(board);
	}
}
