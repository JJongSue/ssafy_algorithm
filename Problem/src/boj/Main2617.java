package boj;
import java.util.Scanner;

public class Main2617 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [][] map = new int[N+1][N+1];
		for(int tc=0;tc<M;tc++)
		{
			int B = sc.nextInt();
			int S = sc.nextInt();
			//if(map[B][S]==1) continue;
			map[B][S]=1;
			for(int i=1;i<=N;i++)
			{
				if(map[B][i] == -1)
				{
					map[i][S]=1;
					map[S][i]=-1;
				}
			}
			map[S][B]=-1;
			for(int i=1;i<=N;i++)
			{
				if(map[S][i]==1)
				{
					map[i][B]=-1;
					map[B][i]=1;
				}
			}
		}
		int max = (N+1)/2;
		int ans = 0;
		boolean is_one = false;
		for(int i=1;i<=N;i++)
		{
			int heavy=0, g=0;//heavy무겁 1, g가볍-1
			for(int j=1;j<=N;j++)
			{
				if(map[i][j]==1) heavy++;
				if(map[i][j]==-1) g++;
			}
			if( g == max-1 && heavy== max-1)
			{
				is_one = true;
				break;
			}
			if(heavy>=max) {
				ans++;
				continue;
			}
			if(g>=max) {
				ans++;
				continue;
			}
			if(g+heavy == max) {
				ans++;
			}
			
			
		}
		if(is_one) System.out.println(N-1);
		else System.out.println(ans);
	}
}
