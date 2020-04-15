package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Main1605_3 {
	static String str;
	static int ans = -1, N;
	static ArrayList<pair> al;
	static class pair{
		long hash;
		int where;
		public pair(long hash, int where) {
			super();
			this.hash = hash;
			this.where = where;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N = Integer.parseInt(br.readLine());
		str = br.readLine();
		N = str.length();
		int l = 1, r=N-1;
		while(l<=r) {
			int mid = (l+r)/2;
			//System.out.println(mid);
			boolean is = find(mid);
			if(is) {
				l = mid+1;
			}else {
				r = mid-1;
			}
		}
		System.out.println(ans);
	}
	
	static boolean find(int size) {
		//System.out.println(size);
		long hash = 0, mul=1;
		for(int i=0;i<size;i++) {
			hash = hash *5381 + (str.charAt(i)-'a'+1);
			mul *= 5381;
		}
		al = new ArrayList<pair>();
		al.add(new pair(hash, 0));
		//hs.add(hash);
		for(int i=size;i<N;i++) {
			hash = (hash)*5381 - (str.charAt(i-size) -'a' + 1) * mul  + str.charAt(i)-'a'+1;
			al.add(new pair(hash, i-size+1));
			
			
//			if(hs.contains(hash)) {
//				ans = size;
//				return true;
//			}
//			hs.add(hash);
		}
		al.sort(new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1.hash, o2.hash);
			}
		});
		//System.out.println(al.get(0).hash);
		//System.out.println(al.get(al.size()-1).hash);
		for(int i=0;i<al.size()-1;i++) {
			int j = i+1;
			if(al.get(i).hash != al.get(i+1).hash) continue;
			
			for(j=i+1;j<al.size();j++) {
				if(al.get(i).hash != al.get(j).hash) break;
			}
			
			for(int k=i;k<j;k++) {
				for(int l=k+1;l<j;l++) {
					if(is_same(al.get(k).where, al.get(l).where, size)) {
						ans = size;
						return true;
					}
				}
			}
			i = j-1;
			
		}
		
		return false;
		
	}
	
	static boolean is_same(int left, int right, int size) {
		for(int i=0;i<size;i++) {
			if(str.charAt(left+i) != str.charAt(right+i)) return false;
		}
		
		return true;
	}
	
}
