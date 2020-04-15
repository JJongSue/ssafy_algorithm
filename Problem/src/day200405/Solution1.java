package day200405;

public class Solution1 {
	static public int solution(String inputString) {
        int answer = 0;
        int arr[] = new int[4];
        for(int i=0;i<inputString.length();i++) {
        	if(inputString.charAt(i) == '(') {
        		arr[0]++;
        		answer++;
        	}else if(inputString.charAt(i) == '{') {
        		arr[1]++;
        		answer++;
        	}else if(inputString.charAt(i) == '[') {
        		arr[2]++;
        		answer++;
        	}else if(inputString.charAt(i) == '<') {
        		arr[3]++;
        		answer++;
        	}else if(inputString.charAt(i) == ')') {
        		arr[0]--;
        	}else if(inputString.charAt(i) == '}') {
        		arr[1]--;
        	}else if(inputString.charAt(i) == ']') {
        		arr[2]--;
        	}else if(inputString.charAt(i) == '>') {
        		arr[3]--;
        	}
        	if(arr[0] < 0 && arr[1] < 0 && arr[2] < 0 && arr[3] < 0) return -1;
        }
        
        if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0) return answer;
        
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(solution("Hello, world!"));
	}
}
