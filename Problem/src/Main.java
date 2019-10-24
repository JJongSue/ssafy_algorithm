import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int sum = 0;
		sum = sum-sc.nextInt()+sc.nextInt();
		max = sum;
		sum = sum-sc.nextInt()+sc.nextInt();
		if(max < sum) max =sum;
		sum = sum-sc.nextInt()+sc.nextInt();
		if(max < sum) max =sum;
		sum = sum-sc.nextInt()+sc.nextInt();
		if(max < sum) max =sum;
		System.out.println(max);
		
	}
}
