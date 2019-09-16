package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7465 {
	static int []arr;
	static void make_Set(int x)
	{
		arr[x]=x;
	}
	static int find_Set(int x)
	{
		if(x==arr[x]) return x;
		else return arr[x]=find_Set(arr[x]);
	}
	static void union_Set(int x, int y)
	{
		int px = find_Set(x);
		int py = find_Set(y);
		if(px != py)
		{
			arr[py] = px;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1;tc<=T;tc++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			for(int i=1;i<=N;i++)
			{
				make_Set(i);
			}
			for(int i=0;i<M;i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union_Set(x, y);
				System.out.println(Arrays.toString(arr));
			}
			int ans =0;
			for(int i=1;i<=N;i++)
			{
				if(i==arr[i]) ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
