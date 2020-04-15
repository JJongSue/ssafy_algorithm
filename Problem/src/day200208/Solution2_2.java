package day200208;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution2_2 {
	static PriorityQueue<String> pq = new PriorityQueue<String>();
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static Set<String> ts[] = new HashSet[200_001];
	static int max = 0;
	static int cntmap[] = new int[200_001];
	static int now = 0;
	static boolean is_max[] = new boolean[200_001];
	
	
	static String[] solution(String[] orders) {
        
        for(int s=0;s<orders.length;s++) {
        	System.out.println(orders[s]);
        	StringTokenizer st = new StringTokenizer(orders[s]);
        	String name = st.nextToken();
        	//System.out.println(name);
        	if(!hm.containsKey(name)) {
        		hm.put(name, now);
        		ts[now] = new HashSet<String>();
        		now++;
        	}
        	int tmpnow = hm.get(name);
        	System.out.println(tmpnow);
        	int counttoken = st.countTokens();
        	for(int c=0;c<counttoken;c++) {
        		String food = st.nextToken();
        		if(!ts[tmpnow].contains(food)) {
        			cntmap[tmpnow]++;
        			ts[tmpnow].add(food);
        		}
        		
        	}
        	if(cntmap[tmpnow] == max && !is_max[tmpnow]) {
        		System.out.println("되는겨");
        		pq.add(name);
        	}else if(cntmap[tmpnow] > max) {
        		is_max = new boolean[200_001];
        		is_max[tmpnow] = true;
        		max = cntmap[tmpnow];
        		System.out.println(max);
        		pq = new PriorityQueue<String>();
        		pq.add(name);
        	}
        	
        	
        	
        }
        String[] answer = new String[pq.size()];
        int tmpcount = 0;
        while(!pq.isEmpty()) {
        	answer[tmpcount] = pq.poll();
        	tmpcount++;
        }
        
        
        
        return answer;
    }
	public static void main(String[] args) {
		String strs[] = {"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"};
		String ans[] = solution(strs);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
	
}
