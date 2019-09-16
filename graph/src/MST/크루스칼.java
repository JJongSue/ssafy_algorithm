package MST;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

//크루스칼
//간선중심의 최소신장트리 생성 알고리즘(탐욕)
//가중치가 가장 작은 간선을 찾는다
//:아이디어 : 각 정점을 상호 배타 집합으로 생각하고 간선을 ㅗ연결되는 경우
//두집합을 유니온한다. 모든 집합이 하나로 유니온 되면 최소 신장트리 완성
//1. 가중치가 가장 작은 간선을 찾는다.
//2. 해당 간선으로 연결되는 두 정점이 다른 집합에 속해있다면 간선을 선택, 아니라면 다시 작은 간선을 찾아 반복
//3. 1-2의 작업을 정점이 N개일때, N-1번 수행하면 최소신장트리 완성

public class 크루스칼 {
	static class line implements Comparable<line>{
		int x;
		int y;
		int level;
		public line(int x, int y, int level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}
		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return this.level-o.level;
		}
		
		
	}
	static int find_set(int x)
	{
		if(arr[x] == x) return x;
		else {
			return x=find_set(arr[x]);
		}
	}
	static void union(int x, int y)
	{
		int px = find_set(x);
		int py = find_set(y);
		if(px != py)
		{
			arr[py]=px;
		}
		find_set(y);
	}
	static int []arr;
	static PriorityQueue<line> pq;
	public static void main(String[] args) {
		 Scanner sc = new Scanner("7 11\n" +
	                "0 1 31\r\n" + 
	                "0 2 31\r\n" + 
	                "0 6 31\r\n" + 
	                "0 5 60\r\n" +
	                "1 2 21\r\n" + 
	                "2 4 46\r\n" + 
	                "2 6 25\r\n" + 
	                "3 4 34\r\n" + 
	                "4 6 51\r\n" + 
	                "5 3 18\r\n" + 
	                "5 4 40\r\n" );
		 int cnt =0;
		 int N = sc.nextInt();
		 int M = sc.nextInt();
		 arr = new int[N];
		 for(int i=0;i<N;i++) arr[i]=i;
		 pq = new PriorityQueue<>();
		 for(int i=0;i<M;i++)
		 {
			 pq.add(new line(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		 }
		 while(!pq.isEmpty())
		 {
			 line tmp = pq.poll();
			 if(find_set(tmp.x) != find_set(tmp.y))
			 {
				 union(tmp.x, tmp.y);
				 cnt+=tmp.level;
			 }
		 }
		 System.out.println(cnt);
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
