package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main1035 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static char map[][] = new char[5][5];
	static HashSet<Integer> hs = new HashSet<>();
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static ArrayList<pair> al = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<5;j++) {
				if(map[i][j] == '*') {
					al.add(new pair(j,i));
				}
			}
		}
		
		
	}
}
