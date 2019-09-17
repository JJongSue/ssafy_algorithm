package Trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution1256 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++)
		{
			int K = sc.nextInt();
			String str = sc.next();
			//System.out.println(str);
			int N = str.length();
			Integer arr[] = new Integer[N];
			for(int i=0;i<N;i++)
			{
				arr[i]=i;
			}
			Arrays.sort(arr, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return str.substring(o1).compareTo(str.substring(o2));
				}
			});
			//System.out.println(Arrays.toString(arr));
			if(K-1>=N) System.out.println("#"+" none");
			else System.out.println("#"+tc+" "+str.substring(arr[K-1]));
		}
	}
}
