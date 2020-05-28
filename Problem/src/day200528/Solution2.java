package day200528;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
	static public long[] solution(long n) {
        long[] answer = {-1,-1};
        boolean is_pirme[] = new boolean[(int) (n+1)];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=2;i<=n;i++) {
        	if(!is_pirme[i]) {
        		al.add(i);
        		for(int j=2;j*i<=n;j++) {
        			is_pirme[i*j] = true;
        		}
        	}
        }
        for(int i=0;i<al.size();i++) {
        	int tmp1 = al.get(i);
        	for(int j=i;j<al.size();j++) {
        		int tmp2 = al.get(j);
        		if(tmp1 * tmp2 > n) break;
        		if(tmp1 * tmp2 == n) {
        			answer[0] = tmp1;
        			answer[1] = tmp2;
        			return answer;
        		}
        	}
        }
        
        return answer;
        }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		long arr[] = new long [2];
		while(i != -1) {
			arr = solution(i);
			System.out.println(arr[0]+ " "+arr[1]);
			i = sc.nextInt();
		}
	}
}
