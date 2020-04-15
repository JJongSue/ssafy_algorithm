package day200405;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {
	
	public String[][] solution(String[][] snapshots, String[][] transactions) {
		boolean is_use[] = new boolean[100_001];
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i=0;i<snapshots.length;i++) {
			hm.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		for(int i=0;i<transactions.length;i++) {
			int id = Integer.parseInt(transactions[i][0]);
			if(is_use[id]) {
				continue;
			}
			is_use[id] = true;
			if(transactions[i][1].charAt(0) == 'S') {
				//SAVE
				if(!hm.containsKey(transactions[i][2])) {
					hm.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
					continue;
				}
				hm.put(transactions[i][2], hm.get(transactions[i][2])+Integer.parseInt(transactions[i][3]));
			}else {
				//WITHDRAW
				if(!hm.containsKey(transactions[i][2])) {
					hm.put(transactions[i][2], (-1)*Integer.parseInt(transactions[i][3]));
					continue;
				}
				hm.put(transactions[i][2], hm.get(transactions[i][2])-Integer.parseInt(transactions[i][3]));
			}
			
		}
		
        String[][] answer = new String[hm.size()][2];
        int now = 0;
        for( Map.Entry<String, Integer> entry : hm.entrySet() ) {
        	answer[now][0] = entry.getKey();
        	answer[now][1] = entry.getValue().toString();
        	now++;
        }
        Arrays.sort(answer, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		});
        return answer;
    }
}
