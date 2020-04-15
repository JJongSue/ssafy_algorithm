package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main1990 {
	static boolean is_p[];
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static ArrayList<Integer> p = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		is_p = new boolean[M+1];
		
		for(int i=5;i<10;i++) {
			if(i>=N && i<=M) p.add(i);
			//else break;
		}
		//if(11 >= N && 11<= M ) p.add(11);
		
		for(int i=1;i<10000;i++) {
			String tmp = Integer.toString(i);
			StringBuilder tmp2 = new StringBuilder(Integer.toString(i));
			
			tmp2.append('0');
			int size = tmp.length();
			for(int j=size-1;j>=0;j--) {
				tmp+=tmp.charAt(j);
				tmp2.append(tmp.charAt(j));
			}
			int now = Integer.parseInt(tmp);
			if(now >= N && now <= M) p.add(now);
			for(int j=0;j<=9;j++) {
				char ch = (char) ('0' + j);
				tmp2.setCharAt(size, ch);
				
				now = Integer.parseInt(tmp2.toString());
				
				if(now >= N && now <= M) {
					//System.out.println("now : " + now);
					p.add(now);
				}
				
			}
		}
		p.sort(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		al.add(2);
		al.add(3);
		StringBuilder sb = new StringBuilder();
		int sqrtn = ((int)Math.sqrt(M));
		boolean is_first = true;
		for(int i=2;i<sqrtn+1;i++) {
			if(!is_p[i]) {
				for(int j=i*i;j<=M;j += i) {
					if(j<0) break;
					is_p[j] = true;
				}
			}
		}
		
//		for(int i=4;i<=M;i+=2) is_p[i] = true;
//		for(int i=3;i<=M;i+=2) {
//			if(is_p[i]) continue;
//			if(i*i < 0) continue;
//			for(int j=i*i;j<=M;j+=(i*2)) {
//				if(j<0) break;
//				is_p[j] = true;
//			}
//		}
		if(p.size() != 0) if(!is_p[p.get(0)]) sb.append(p.get(0)).append("\n");
		for(int i=1;i<p.size();i++) {
			if(p.get(i) == p.get(i-1)) continue;
			if(!is_p[p.get(i)]) sb.append(p.get(i)).append("\n");
		}
		
		
//		for(int i=2;i<=M;i++) {
//			if(is_p[i]) continue;
//			boolean is_prime = true;
//			for(int j=0;j<al.size();j++) {
//				int tmp = al.get(j);
//				if(tmp*tmp > i) break;
//				if(i%tmp == 0 ) {
//					is_prime = false;
//					break;
//				}
//			}
//			if(is_prime) al.add(i);
//			
//		}
//		for(int i=0;i<p.size();i++) {
//			int pnum = p.get(i);
//			boolean is_prime = true;
//			for(int j=0;j<al.size();j++) {
//				int tmp = al.get(j);
//				if(tmp*tmp > pnum) break;
//				if(pnum % tmp == 0) {
//					is_prime = false;
//					break;
//				}
//				
//			}
//			
//			if(is_prime) sb.append(p.get(i)).append("\n");
//		}
		
		
		
//		for(int i=iter;i<al.size();i++) {
//			String tmp = al.get(i).toString();
//			boolean is_same = true;
//			for(int j=0;j<tmp.length()/2;j++) {
//				if(tmp.charAt(j) != tmp.charAt(tmp.length()-1-j)) {
//					is_same = false;
//					break;
//				}
//			}
//			if(is_same) {
//				sb.append(tmp).append("\n");
//			}
//		}
		sb.append(-1).append("\n");
		System.out.println(sb);
		
	}
}
