package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main1599 {
	static class sn{
		String s;
		int i;
		public sn(String s, int i) {
			super();
			this.s = s;
			this.i = i;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("a", "a");
		hm.put("b", "b");
		hm.put("k", "c");
		hm.put("d", "d");
		hm.put("e", "e");
		hm.put("g", "f");
		hm.put("h", "g");
		hm.put("i", "h");
		hm.put("l", "i");
		hm.put("m", "j");
		hm.put("n", "k");
		hm.put("ng", "l");
		hm.put("o", "m");
		hm.put("p", "n");
		hm.put("r", "o");
		hm.put("s", "p");
		hm.put("t", "q");
		hm.put("u", "r");
		hm.put("w", "s");
		hm.put("y", "t");		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> al = new ArrayList<>();
		ArrayList<sn> al2 = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			String input = "";
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j) == 'n') {
					if(j+1<=tmp.length()) {
						if(tmp.charAt(j+1) == 'g') {
							j++;
							input+="l";
						}else {
							input += hm.get(tmp.charAt(j)+"");
						}
						
					}else {
						input += hm.get(tmp.charAt(j)+"");
					}
				}else {
					input += hm.get(tmp.charAt(j)+"");
				}
			}
			al2.add(new sn(input, i));
			al.add(tmp);
		}
		al2.sort(new Comparator<sn>() {

			@Override
			public int compare(sn o1, sn o2) {
				// TODO Auto-generated method stub
				return o1.s.compareTo(o2.s);
			}
		});
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(al2.get(i).i));
		}
		
	}
}
