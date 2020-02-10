package day200208;

public class Solution1 {
	static int max = 0;
	static int max_size;
	static int map[];
	
	static public int solution(int[] prices) {
		max_size = prices.length;
		map = new int[prices.length];
		for(int i=0;i<prices.length;i++) {
			map[i] = prices[i];
		}
        for(int i=0;i<prices.length;i++) {
        	trade(0,0,0,0,0);
        }
        return max;
    }
	static void trade(int now, int bcnt, int scnt, int bsum, int ssum) {
		
		if(bcnt == 2 && scnt == 2 || now == max_size) {
			max = Math.max(ssum-bsum, max);
			return;
		}
		trade(now+1, bcnt, scnt, bsum, ssum);
		if(bcnt < 2) trade(now+1, bcnt+1, scnt, bsum+map[now], ssum);
		if(bcnt > scnt) trade(now+1, bcnt, scnt+1, bsum, ssum+map[now]);
	}
	
	public static void main(String[] args) {
		//int map1[] = {1,2,3,4};
		//int map1[] = {1,2,4,1,2,3};
		//int map1[] = {4,3,2,1,4};
		//int map1[] = {4,3,2,1};
		int map1[] = {1,10,5,11,7};
		System.out.println(solution(map1));
	}
}
