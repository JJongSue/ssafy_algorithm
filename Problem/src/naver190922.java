import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class naver190922 {
	static class dot{
		int num;
		int price;
		public dot(int num, int price) {
			super();
			this.num = num;
			this.price = price;
		}
		
	}
	static int[] Solution(int cook_times[], int order[][], int K) {
		int result[] = new int[2];
		ArrayList<dot> al = new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> dis_map = new ArrayList<>();
		for(int i=0;i<cook_times.length;i++) {
			al.add(new dot(0,cook_times[i]));
			dis_map.add(new ArrayList<>());
			
		}
		ArrayList<Integer> ansal = new ArrayList<>();
		for(int i=0;i<order.length;i++) {
			al.get(order[i][1]-1).num++;
			if(order[i][1] == K) ansal.add(order[i][0]-1);
			dis_map.get(order[i][0]-1).add(order[i][1]-1);
		}
		for(int i=0;i<ansal.size();i++) {
			result[1]+= al.get(ansal.get(i)).num;
		}result[1]++;
		//result[1]=al.get(K-1).num;
		System.out.println(result[1]);
		Queue<dot> q = new LinkedList<dot>();
		for(int i=0;i<al.size();i++) {
			dot tmp = al.get(i);
			if(tmp.num==0) {
				/*al.remove(i);
				i--;*/
				q.add(new dot(i, cook_times[i]));
				//q.add(tmp);
			}
		}
		while(!al.isEmpty()) {
			while(!q.isEmpty()) {
				dot tmp = q.poll();
				for(int i=0;i<dis_map.get(tmp.num).size();i++) {
					int x = dis_map.get(tmp.num).get(i);
					al.get(x).price = Math.max(al.get(x).price, tmp.price+cook_times[x] );
					al.get(x).num--;
					if(al.get(x).num == 0) {
						q.add(new dot(x, al.get(x).price));
						//al.remove(x);
					}
				}
				if(tmp.num == K-1) {
					result[0] = tmp.price;
					return result;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int cook_times[] = {5,30,15,30,35,20,4};
		int order[][] = { {2,4}, {2,5}, {3,4},{3,5},{1,6},{4,6},{5,6},{6,7}};
		
		System.out.println(Arrays.toString(Solution(cook_times, order, 6)));
//		int cook_times[] = {5,30,15,30,35,20,4,50,40};
//		int order[][] = { {2,4}, {2,5}, {3,4},{3,5},{1,6},{4,6},{5,6},{6,7},{8,9}};
//		
//		System.out.println(Arrays.toString(Solution(cook_times, order, 9)));
//		int cook_times[] = {5,3,2};
//		int order[][] = { {1,2},{2,3},{1,3}};
//		
//		System.out.println(Arrays.toString(Solution(cook_times, order, 3)));
		
	}
	
}
