package day200523;

public class Solution2 {
	static int solution(int x, int y, int r, int d, int[][] target) {
        int answer = 0;
        
        double degree = Math.toDegrees(Math.atan2(y, x));
        
        for(int i=0;i<target.length;i++) {
        	int xx = target[i][0];
        	int yy = target[i][1];
        	
        	if((xx * xx) + (yy * yy) > r*r) continue;
        	if(d == 180) {
        		answer++;
        		continue;
        	}
        	boolean is_ans = false;
        	double dd = Math.toDegrees(Math.atan2(yy, xx));
        	if(degree + d > 180) {
        		if( (d <= dd && dd <= 180) || (-180<= dd && dd<=degree+d-360)  ) {
        			is_ans = true;
        		}
        	}else {
        		if(degree <= dd && dd<= degree + d) is_ans = true;
        	}
        	
        	if(degree - d < -180) {
        		if( (-180 <= dd && dd <= d) || (degree-d+360<= dd && dd<=180)  ) {
        			is_ans = true;
        		}
        	}else {
        		if(degree-d <= dd && dd<= degree) is_ans = true;
        	}
        	
        	if(is_ans) answer++;
        	
        	
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
//        System.out.println("Hello Java");

        return answer;
    }
	
	public static void main(String[] args) {
		int x = -1;
		int y = 2;
		int r = 2;
		int d = 60;
		int target[][] = {{0,1},{-1,1},{1,0},{-2,2}};
		
		System.out.println(solution(x, y, r, d, target));
	}
}
