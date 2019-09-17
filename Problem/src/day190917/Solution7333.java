package day190917;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution7333 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			int cnt=0;
			for(int i=0;i<N;i++)
			{
				int tmp = sc.nextInt();
				if(tmp>=50) cnt++;
				else {
					arr.add(tmp);
				}
			}
			arr.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			while(arr.size()>0)
			{
				int max = arr.get(0);
				arr.remove(0);
				int num = 50/max;
				if(50%max != 0) num++;
				num--;
				boolean ccc=true;
				for(int i=0;i<num;i++)
				{
					if(arr.size()==0) {
						ccc=false;
						break;
					}
					arr.remove(arr.size()-1);
				}
				if(ccc)	cnt++;
				
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
