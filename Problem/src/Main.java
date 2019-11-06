import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M = sc.nextInt();
		String str = "";
        boolean t = false;        
		char ch = ' ';
		//int num = 0;
		int cnt = 1;
		int len = 10;
		int temp = 0;
		for (int i = 1; i <= T; i++) {
			if (i == len) {
				len *= 10;
				cnt++;
			}
			//num++;
			temp += cnt;
			if (M <= temp ) {
			str = Integer.toString(i);
			ch=str.charAt(cnt-1-(temp-M));
             t=true;
             break;
			}
		}
		if(t) System.out.println(ch);
		else System.out.println(-1);
	}
	
}
