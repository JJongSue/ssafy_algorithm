import java.util.*;
import java.io.*;

public class Main
{
	public static class Edges implements Comparable<Edges> {
		int des;
		int c;
		public Edges(int des, int c) {
			this.des = des;
			this.c = c;
		}
		@Override
		public int compareTo(Edges o)
		{
			// TODO Auto-generated method stub
			return this.c-o.c;
		}
		
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1];
		ArrayList<Edges>[] list = new ArrayList[V+1];
		
		for(int i=0; i<V+1; i++)
			list[i]= new ArrayList<>();
		
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
			list[a].add(new Edges(b, c));
		}
		
		for(int i=0; i<list[start].size(); i++)
		{
			dist[list[start].get(i).des]=list[start].get(i).c;
		}
		
		for(int i=1; i<=V; i++)
		{
			if(dist[i]==0)
			dist[i]=Integer.MAX_VALUE;
		}
		visited[start] = true;
		dist[start] =0;
		
//		System.out.println(Arrays.toString(dist));
		for(int i=0; i<V-1; i++)
		{
			int minDist=Integer.MAX_VALUE;
			int minIdx =0 ;
			for(int j=1; j<=V; j++)
			{
				if(!visited[j] && minDist > dist[j] && list[j].size()>0)
				{
					minDist = dist[j];
					minIdx= j;
				}
				
			}
			for(int j=0; j<list[minIdx].size(); j++)
			{
				int n_des= list[minIdx].get(j).des;
				if(!visited[n_des] && dist[n_des] > dist[minIdx] + list[minIdx].get(j).c)
				{
					dist[n_des] = dist[minIdx] + list[minIdx].get(j).c;
				}
			}
			visited[minIdx]= true;
		}
		for(int i=1; i<=V; i++)
		{
			if(dist[i]==Integer.MAX_VALUE)
				sb.append("INF").append('\n');
			else {
				sb.append(dist[i]).append('\n');				
			}
		}
		System.out.print(sb.toString());
	}
	
}