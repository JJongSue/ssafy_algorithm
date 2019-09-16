package Disjoint;

import java.util.Arrays;

//배열을 통해서 자신의 부모를 저장함으로써 트리를 표현.

//makeSet은 자신의 부모를 자신으로 정해주는 것
//findSet은 자신의 부모가 자신이면 자신이 대표자. 아니면. 부모에 대해서 재귀호출.
//unionSet(a,b)은 b의 대표자의 부모를 a의 대표자로 지정.


public class 상호베타집합 {
	static int []arr = new int[6];
	public static void main(String[] args) {
		for(int i=0;i<6;i++) make_Set(i);
		System.out.println(Arrays.toString(arr));
		Union(4, 5);
		Union(2, 3);
		System.out.println(Arrays.toString(arr));
		Union(3, 5);
		System.out.println(Arrays.toString(arr));
		
		
	}
	static void make_Set(int x)
	{
		arr[x]=x;
	}
	static int find_Set(int x)
	{
		if(x == arr[x]) return x;
		else {
			return arr[x]=find_Set(arr[x]);
		}
	}
	static void Union(int x, int y)
	{
		int px=find_Set(x);
		int py=find_Set(y);
		if(px != py) arr[py]=px;
	}
}

