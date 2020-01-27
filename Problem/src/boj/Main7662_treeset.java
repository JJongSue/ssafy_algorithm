package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main7662_treeset {
	static TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			tm = new TreeMap<Integer, Integer>();
			int N = Integer.parseInt(br.readLine());
			for(int c=0;c<N;c++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int input = Integer.parseInt(st.nextToken());
				if(cmd.charAt(0) == 'I') {
					if(tm.containsKey(input)) {
						tm.replace(input, tm.get(input)+1);
					}else {
						tm.put(input, 1);
					}
				}else{
					if(tm.isEmpty()) continue;
					if(input == 1) {
						int tmp = tm.lastKey();
						if( tm.get(tmp) == 1 ) {
							tm.remove(tmp);
						}else {
							tm.replace(tmp, tm.get(tmp)-1);
						}
					}else {
						int tmp = tm.firstKey();
						if( tm.get(tmp) == 1 ) {
							tm.remove(tmp);
						}else {
							tm.replace(tmp, tm.get(tmp)-1);
						}
					}
				}
			}
			if(tm.isEmpty()) System.out.println("EMPTY");
			else {
				System.out.println(tm.lastKey() + " " + tm.firstKey());
			}
			
			
		}
	}
}
