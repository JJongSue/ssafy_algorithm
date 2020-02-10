package day200208;

public class Solution3 {
	static int ans = 1;
	static int map[][] = new int[4][4];
	static boolean is_visit[][] = new boolean[4][4];
	static public int solution(int[][] board) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map[i][j] = board[i][j];
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				is_visit[i][j] = true;
				dfs(j,i,map[i][j], 1);
				is_visit[i][j] = false;
			}
		}
        
		if(ans == 1) return -1;
        return ans;
    }
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static void dfs(int x, int y, int num,int cnt) {
		//System.out.println(x+" "+y+" "+cnt);
		ans = Math.max(ans, cnt);
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(is_map(xx, yy) && map[yy][xx]==num && !is_visit[yy][xx]) {
				is_visit[yy][xx] = true;
				dfs(xx,yy, num, cnt+1);
				is_visit[yy][xx] = false;
			}
		}	
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=4 || y>=4) return false;
		return true;
	}
	public static void main(String[] args) {
		int map1[][] = {{3,2,3,2},{2,1,1,2},{1,1,2,1},{4,1,1,1}};
		//int map1[][] = {{4,2,3,2},{2,1,2,4},{1,2,3,1},{4,1,4,3}};
		//int map1[][] = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		System.out.println(solution(map1));
	}

}
