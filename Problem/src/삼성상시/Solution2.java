package day200509;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


public class Solution2 {
	static public long solution(String expression) {
        long answer = 0;
        Deque<String> q1 = new LinkedList<String>();
        Deque<String> q2 = new LinkedList<String>();
        ArrayList<String> al = new ArrayList<>();
        int now = 0;
        for(int i=0;i<expression.length();i++) {
        	char ch = expression.charAt(i);
        	if(ch == '+' || ch == '-' || ch == '*') {
        		String input = Integer.toString(now); 
//        		q1.add(input);
        		al.add(input);
        		input = Character.toString(ch);
//        		q2.add(input);
        		al.add(input);
        		

        		now = 0;
        	}else {
        		now = now*10 + (ch - '0');
        	}
        }
//        q1.add(Integer.toString(now));
        al.add(Integer.toString(now));
        char dots[] = {'+', '-', '*'};
        boolean is_visit[] = new boolean[3];
        for(int i=0;i<3;i++) {
        	is_visit[i] = true;
        	q1 = new LinkedList<String>();
            q2 = new LinkedList<String>();
        	if(al.get(1).charAt(0) == dots[i]) {
        		q2.add(calc(al.get(0), al.get(2), dots[i]));
        	}else {
        		q2.add(al.get(0));
        		q2.add(al.get(1));
        		q2.add(al.get(2));
        	}
        	for(int tmp=1;tmp*2+1<al.size();tmp++) {
        		if(al.get(tmp*2+1).charAt(0) == dots[i]) {
        			String num = q2.pollLast();
        			q2.add(calc(num,al.get(tmp*2), dots[i]));
        		}else {
        			q2.add(al.get(tmp*2+1));
        			q2.add(al.get(tmp*2+2));
        		}
        	}
        	
        	
        	for(int j=0;j<3;j++) {
        		if(is_visit[j]) continue;
        		if(q2.size() == 1) {
        			answer = Math.max(answer, Math.abs(Long.getLong(q2.poll())));
        			continue;
        		}
        		is_visit[j] = true;
        		
        		q1.add(q2.pollFirst());
        		while(!q2.isEmpty()) {
        			String cmd = q2.pollFirst();
        			if(cmd.charAt(0) == dots[j]) {
        				String num = q1.pollLast();
        				q1.add(calc(num, q2.pollFirst(), dots[j]));
        			}else {
        				q1.add(cmd);
        				q1.add(q2.pollFirst());
        			}
        		}
        		while(!q1.isEmpty()) {
        			q2.addLast(q1.pollFirst());	
        		}
        		
        		
        		for(int k=0;k<3;k++) {
        			if(is_visit[k]) continue;
        			if(q2.size() == 1) {
        				answer = Math.max(answer, Math.abs(Long.getLong(q2.poll())));
        				continue;
        			}
        			is_visit[k] = true;
        			
        			
        			is_visit[k] = false;
        		}
        		q1.add(q2.pollFirst());
        		while(!q2.isEmpty()) {
        			String cmd = q2.pollFirst();
        			if(cmd.charAt(0) == dots[j]) {
        				String num = q1.pollLast();
        				q1.add(calc(num, q2.pollFirst(), dots[j]));
        			}else {
        				q1.add(cmd);
        				q1.add(q2.pollFirst());
        			}
        		}
        		answer = Math.max(answer, Math.abs(Long.getLong(q1.poll())));
        		
        		is_visit[j] = false;
        	}
        	is_visit[i] = false;
//        	answer = Math.max(answer, Math.abs(Long.getLong(q2.poll())));
        }
        
        
        return answer;
    }
	static String calc(String num1, String num2, char ch) {
		long num11 = Long.getLong(num1);
		long num22 = Long.getLong(num2);
		if(ch == '+') return Long.toString(num11+num22);
		if(ch == '-') return Long.toString(num11-num22);
		return Long.toString(num11*num22);
	}
	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
	}

}
