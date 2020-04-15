package day200405;

import java.util.ArrayList;

public class Solution3 {
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static int min = 0;
	public int solution(String road, int n) {
		
		//boolean is_plus = true;
		//if(road.charAt(0) == '0') is_plus=false;
		int cnt = 0;
		if(road.charAt(0) == '0') cnt--;
		else cnt++;
		
		for(int i=1;i<road.length();i++) {
			if(cnt>0 && road.charAt(i) == '1') {
				cnt++;
			}else if(cnt>0 && road.charAt(i) == '0') {
				al.add(cnt);
				cnt = -1;
			}else if(cnt<0 && road.charAt(i) == '1') {
				al.add(cnt);
				cnt = 1;
			}else if(cnt<0 && road.charAt(i) == '0') {
				cnt--;
			}
		}
		if(cnt != 0) al.add(cnt);
		min = n;
		find_length(0, 0, false, n);
		
        return min;
    }
	public void find_length(int now, int ans, boolean is_start, int n) {
		if(now == al.size()) {
			min = Math.max(min, ans);
			return;
		}
		if(is_start) {
			if(al.get(now) > 0) {
				find_length(now+1, ans+al.get(now), is_start, n);
				return;
			}
			if(n==0 && al.get(now) < 0) {
				min = Math.max(min, ans);
				return;
			}
			if( (al.get(now) * -1) > n ) {
				min = Math.max(min, ans+n);
				return;
			}else {
				find_length(now+1, ans+(al.get(now)*(-1)), is_start, n+al.get(now));
				return;
			}
			
		}else {
			if(al.get(now)>0) {
				find_length(now+1, ans+al.get(now), true, n);
				find_length(now+1, ans, is_start, n);
				return;
			}else {
				if( (al.get(now)*(-1) > n ) ) {
					return;
				}else {
					find_length(now+1, al.get(now)*(-1), true, n+al.get(now));
					find_length(now+1, ans, is_start, n);
				}
			}
			
		}
		
		
		
	}
	
}
