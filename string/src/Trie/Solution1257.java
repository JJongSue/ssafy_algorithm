package Trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution1257 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++)
		{
			int K = sc.nextInt();
			String str = sc.next();
			//System.out.println(str);
			int N = str.length();
			Integer arr[] = new Integer[N];
			for(int i=0;i<N;i++)
			{
				arr[i]=i;
			}
			Arrays.sort(arr, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return str.substring(o1).compareTo(str.substring(o2));
				}
			});
			//System.out.println(Arrays.toString(arr));
			
			int[] LCP = new int[N];
			//LCP를 구해보시오.
			for(int i=1;i<N;i++)
			{
				for(int j=0;j<Math.min(str.substring(arr[i-1]).length(), str.substring(arr[i]).length());j++)
				{
					if(str.substring(arr[i-1]).charAt(j) != str.substring(arr[i]).charAt(j)) break;
					LCP[i]++;
				}
			}
			int k = K;
			boolean none = true;
			//k번째 부분문자열 찾기...
			for(int i=0;i<arr.length;i++) {
				String str1 = str.substring(arr[i]);
				/*System.out.println(i+"번째 접미사에서 나오는 부분문자열의 갯수");
				System.out.println(str.length()-LCP[i]);*/
				if(k- (str1.length()-LCP[i]) > 0 ) k=k-(str1.length()-LCP[i]);
				else {
					//System.out.println(i+"번째 접미사, 여기에 답있다.");
					
					//if(K-1>=N) 
					none=false;
					System.out.println("#"+tc+" "+str1.substring(0,k+LCP[i]));
					break;
				}
			}
			if(none) System.out.println("#"+tc+" none");
			
		}
		
	
	}
}
