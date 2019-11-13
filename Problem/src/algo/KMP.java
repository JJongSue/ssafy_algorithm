package algo;

import java.util.ArrayList;
import java.util.List;

public class KMP {
	public static void main(String[] args) {
		final String pattern = "ogle";
		final String str = "Gooooooooogleooooooooogle";
		KMP kmp = new KMP(str, pattern);
		List<Integer> L = kmp.search();
		for(int i=0;i<L.size();i++) {
			System.out.print(L.get(i) + " ");
		}
	}
	
	private String string;
	private String pattern;
	
	public KMP(String string, String pattern) {
		this.string = string;
		this.pattern = pattern;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public List<Integer> search(){
		List<Integer> searchIndex = new ArrayList<Integer>();
		
		char[] s = string.toCharArray();
		char[] p = pattern.toCharArray();
		int[] pi = getPI();
		int n = string.length();
		int m = pattern.length();
		int j = 0;
		
		for(int i=0;i<n;i++) {
			while(j>0 && s[i] != p[j]) {
				j = pi[j-1];
			}
			if(s[i] == p[j]) {
				if(j== m-1) {
					searchIndex.add(i-m+1);
					
					j=pi[j];
				}else {
					j++;
				}
			}
		}
		return searchIndex;
	}
	
	

	public int[] getPI(){
		int m = pattern.length();
		int j = 0;
		char[] p = pattern.toCharArray();
		int[] pi = new int[m];
		
		for(int i=1;i<m;i++) {
			while(j>0 && p[i] != p[j]) {
				j=pi[j-1];
			}
			if(p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

}
