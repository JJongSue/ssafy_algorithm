package day200128;

public class Solution1 {
	static public int[] solution(int n, int min_position, int max_position, int[] positions){
		int cnt = (max_position - min_position) / (n-1);
		//System.out.println(cnt);
		boolean is_visit[] = new boolean[n];
		//System.out.println(n);
		for(int i=0;i<positions.length;i++) {
			//System.out.println((positions[i] - min_position)/cnt);
			is_visit[(positions[i] - min_position)/cnt] = true;
		}
		int arr[] = new int[n-positions.length];
		int tmp = 0;
		for(int i=0;i<n;i++) {
			//System.out.println(min_position + (cnt*i));
			if(tmp == n-positions.length) break;
			if(!is_visit[i]) {
				arr[tmp] = min_position + (cnt*i);
				tmp++;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {-1,-3,3};
		int ans[] = new int[solution(5, -5, 3, arr).length];
		ans = solution(5, -5, 3, arr);
		for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
//		int arr[] = {6,-10,2, -6};
//		int ans[] = new int[solution(6, -10, 10, arr).length];
//		ans = solution(6, -10, 10, arr);
//		for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
	}
}
