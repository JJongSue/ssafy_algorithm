
public class Fibo {
	//중복을 제거하지 않은 Fibo재귀함수를 구현하시오.
	//상향식(DP). 하향식(메모이제이션). 으로 각 각 구현해보시오.
	static long []DP = new long[101];
	static long fibo(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		return fibo(n-1)+fibo(n-2);
	}
	static long DP(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		if(DP[n] != 0) return DP[n];
		return DP[n]=DP(n-1)+DP(n-2);
	}
	static long Memoization(int n) {
		long []dp=new long[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		//long result = fibo(45);
		long result=Memoization(1000);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(result);
		//System.out.println(DP(100));
	}
}
