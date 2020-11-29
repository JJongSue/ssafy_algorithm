package day200913;

public class Solution4 {
	
	static int map[][], size;
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static class man{
		public man(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		int x;
		int y;
		int r;
		
		int start() {
			int ans = 0;
			while(x != size || y != size) {
				if(leftwall() ) {
					//앞 벽 있음 => 오른쪽 회전
					if(frontwall()) {
//						System.out.println("오회");
						r = (r+1)%4;																		
					}
					//앞벽 없음 => 전진
					else {
//						System.out.println("전진");
						go();
						ans++;
					}
				}
				// 왼쪽 벽 없음 => 왼쪽 회전후 앞으로
				else {
//					System.out.println("r : "+r);
					r = (3+r)%4;
//					System.out.println("회전");
					go();
					ans++;
					
				}
				
//				System.out.println("x : " + x + " y : " + y+ " r : " + r + " ans : " + ans);
			}
			return ans;
		}
		boolean leftwall() {
			if( is_wall( x+dx[ (r+3)%4 ],  y+(dy[(r+3)%4]  ))) return true;
			return false;
		}
		boolean frontwall() {
			if(is_wall(x+dx[r], y+dy[r])) return true;
			return false;
		}
		
		
		boolean is_wall(int x1, int y1) {
//			System.out.println("x y " + x1 + " " + y1+" "+r);
//			if(map[y+dy[r]][x+dx[r]] == 1) return true;
			if(map[y1][x1] == 1) return true;
			return false;
		}
		void go() {
			x += dx[r];
			y += dy[r];
		}
		
	}
	static int solution(int[][] maze) {
		size = maze.length;
		map = new int[size+2][size+2];
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i+1][j+1] = maze[i][j];
				
			}
		}
//		System.out.println(map[3][2]);
		for(int i=0;i<=size+1;i++) {
			map[i][0] = 1;
			map[0][i] = 1;
			map[i][size+1] = 1;
			map[size+1][i] = 1;
			
		}
		
		man m = new man(1,1,1);
		
		
		
		
		return m.start();
	}
	public static void main(String[] args) {
//		int maze[][] = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
//		int maze[][] ={{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
//		int maze[][] = {{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}};
//		int maze[][] = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};
		int maze[][] = {{0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		
		System.out.println(solution(maze));
	}
}
