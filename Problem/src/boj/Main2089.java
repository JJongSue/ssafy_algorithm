package boj;

import java.util.ArrayList;
import java.util.Scanner;
public class Main2089 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Boolean> ans = new ArrayList<>();		
		while(true) {
			if(N == 0) {
				ans.add(false);
				break;
			}
			if(N == 1 ) {
				ans.add(true);
				//ans.add(1);
				break;
			}
			else if(N == -1) {
				ans.add(true);
				ans.add(true);
				break;
			}
			if(N %(-2) < 0) {
				ans.add(true);
				N = N/(-2)+1;
			}else {
				if(N%(-2)==1) ans.add(true);
				else ans.add(false);
				//ans.add(N%(-2));
				N = N/(-2);
			}
			
		}
		for(int i=ans.size()-1;i>=0;i--) {
			if(ans.get(i)) System.out.print(1);
			else System.out.print(0);			
		}
		
		
	}
}
