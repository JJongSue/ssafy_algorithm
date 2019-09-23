
public class ColorStick {	
	static long Memo(int n) {
		if(n==1) return 2;
		if(n==2) return 5;		
		long memo[] = new long[n+1];
		memo[1]=2;
		memo[2]=5;
		for(int i=3;i<=n;i++) memo[i]=memo[i-1]*2+memo[i-2];
		return memo[n];
	}
	static long dpmemo[] = new long[10000];
	static {
		dpmemo[1]= 2;
		dpmemo[2]=5;
	}
	static long DP(int n) {		
		if(dpmemo[n]!=0)  return dpmemo[n];
		return (dpmemo[n]=DP(n-1)*2+DP(n-2));
		
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		//long result = fibo(45);
		long result=DP(8);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(result);
	}
}
