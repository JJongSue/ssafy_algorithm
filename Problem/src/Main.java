
import java.util.Scanner;

public class Solution {
	static Character []color = {'W', 'B', 'R'};
	static int N, M;
	static int ans;
	static int first;
	static Character [][]map;//, copy_map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_i=1;test_i<=T;test_i++)
		{
			N=sc.nextInt();
			M=sc.nextInt();
			map = new Character[N][M];
			for(int i=0;i<N;i++)
			{
				String tmp = sc.next();
				for(int j=0;j<M;j++)
				{
					map[i][j] = tmp.charAt(j);
				}
			}
			ans = 2500;
			first=0;
			for(int i=0;i<M;i++)
			{
				if(map[0][i] != 'W') first++;
				if(map[N-1][i] != 'R') first++;
			}
			pain(1,0,first);
			pain(1,1,first);
			System.out.println("#"+test_i+" "+ans);
			//copy_map = map;
			
		}
	}
	static void pain(int y, int color_num, int cnt) {
		if(y==N-2 && color_num==0) {
			int tmp=0;
			for(int i=0;i<M;i++)
			{
				if(map[y][i] != 'B') tmp++;
			}
			pain(y+1,1,cnt+tmp);
			return;
		}
		if(cnt >= ans) return;
		if(y==N-1) {
			ans = cnt;
			return;
		}
		
		int tmp=0;
		for(int i=0;i<M;i++)
		{
			if(map[y][i] != color[color_num]) tmp++;
		}
		if(color_num==0) {
			for(int i=color_num;i<2;i++)
				pain(y+1, i, cnt+tmp);
			return;
		}
		else  {
				for(int i=color_num;i<3;i++)
					pain(y+1, i, cnt+tmp);
			
		}
		
	}
}
