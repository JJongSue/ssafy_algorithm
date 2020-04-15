package day200405;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution5 {
	public static String[] solution(String[][] dataSource, String[] tags) {
		HashMap<String, Integer> map = new HashMap<>();

		//j => i, j2=>j i=>k
		for (int i=0;i<dataSource.length;i++) {
			for (int j=1;j<dataSource[i].length;j++) {
				for (int k=0;k<tags.length;k++) {
					if(dataSource[i][j].equals(tags[k])) {
						if(!map.containsKey(dataSource[i][0]))
							map.put(dataSource[i][0], 0);
						map.put(dataSource[i][0], map.get(dataSource[i][0]) + 1);
					}
					
				}
			}
		}
		String[][] tmp = new String[map.size()][2];
		int idx =0; 
		for (String key : map.keySet()) {
			tmp[idx][0]=key; 
			tmp[idx++][1]=map.get(key)+"";
		}
		Arrays.sort(tmp, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) {
					return o1[0].compareTo(o2[0]);
				}
				return  o2[1].compareTo(o1[1]);
			}
		});
		
		int size =10; 
		if(map.size()<10) {
			size =map.size();
		}
		String[] answer = new String[size];
		for (int i = 0; i < answer.length; i++) {
			answer[i]=tmp[i][0];
		}
		return answer;
	}
}
