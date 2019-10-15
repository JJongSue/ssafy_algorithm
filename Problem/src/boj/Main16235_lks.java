package boj;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main16235_lks {
	
	
	static final int[] dx = {-1,-1,0,1,1,1,0,-1};
	static final int[] dy = {0,-1,-1,-1,0,1,1,1};
	static class info{
		int rem_food;		
		int start;
		int before_dead;
		//PriorityQueue<Integer> pq;				
		ArrayList<Integer> alive;
		Queue<Integer> make;
		info()
		{			
			rem_food = 5;
			//pq = new PriorityQueue<>();
			alive = new ArrayList<>();
			start = 0;
			before_dead = 0;			
			
		}
		
		void push(int age)
		{
			alive.add(age);
		}
		
		void breeding(int start_x,int start_y)
		{				
			for(int i=0;i<make.size();i++) {
				for(int k = 0 ; k < 8; k++)
				{
					int nx = start_x + dx[k];
					int ny = start_y + dy[k];
					if(nx >=0 && nx < N && ny >=0 && ny <N)
					{
						tree[ny][nx].push(1);
						
					}
				}
			}/*
			for(int i = alive.size()-1 ; i >= start; i--)
			{
				int age = alive.get(i);				
				if(age %5 ==0)
				{
					for(int k = 0 ; k < 8; k++)
					{
						int nx = start_x + dx[k];
						int ny = start_y + dy[k];
						if(nx >=0 && nx < N && ny >=0 && ny <N)
						{
							tree[ny][nx].push(1);
							
						}
					}
				}
			}*/			
		}
		
		void feed()
		{	
			make = new LinkedList<Integer>();
			for(int i = alive.size()-1; i >= start; i--)
			{
				int age = alive.get(i);
				if(rem_food-age >=0)
				{
					rem_food -= age;
					alive.set(i, age+1);
					if((age+1)%5 == 0) make.add(1);
				}
				else {
					start = i+1;
					break;
				}
			}			
		}
		
		void dead()
		{
			for(int i = before_dead; i < start; i++)
			{
				rem_food += alive.get(i)/2;				
			}
			before_dead = start;
		}				
	}
	
	
	static int N,M,K;
	
	static int[][] food;
	static info[][] tree;
	
//	static void print(int N)
//	{
//		System.out.println("======food========");
//		for(int i = 0 ; i < N; i++)
//		{
//			for(int j = 0 ; j < N; j++)
//			{
//				System.out.print(tree[i][j].rem_food+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("=======tree=======");
//		for(int i = 0 ; i < N; i++)
//		{
//			for(int j = 0 ; j < N; j++)
//			{
//				System.out.print(tree[i][j].pq.size()+" ");
//			}
//			System.out.println();
//		}
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();		
		food = new int[N][N];
		tree = new info[N][N];
	
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				tree[i][j] = new info();
		}
		for(int i = 0 ; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				food[i][j] = sc.nextInt();
			}
		}
		for(int i = 0 ; i < M; i++)
		{
			int x = sc.nextInt(),y = sc.nextInt(),age = sc.nextInt();
			tree[x-1][y-1].push(age);
		}				
		int year = 0;
		while(year !=K)
		{
			//봄
						
			for(int i = 0 ; i < N; i++)
			{
				for(int j = 0 ; j < N; j++)
				{
					tree[i][j].feed();
				}
			}			
			
			//여름
			for(int i = 0 ; i < N; i++)
			{
				for(int j = 0 ; j < N; j++)
				{
					tree[i][j].dead();
				}
			}			
			//가을
			for(int i = 0 ; i < N; i++)
			{
				for(int j = 0 ; j < N; j++)
				{
					tree[i][j].breeding(j, i);
				}
			}		
			
			//겨울
			
			for(int i = 0 ; i < N; i++)
			{
				for(int j = 0; j <N; j++)
				{
					tree[i][j].rem_food += food[i][j];
				}
			}			
			year++;
		}
		//살아남은거 카운팅
		int answer = 0;
		for(int i = 0 ; i < N; i++)
		{
			for(int j = 0 ; j <N; j++)
			{
				answer += tree[i][j].alive.size()-tree[i][j].start;
			}
		}
		System.out.println(answer);
		
	}

}
