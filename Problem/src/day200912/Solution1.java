package day200912;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1 {
	static String solution(String new_id) {
		recommandId rid = new recommandId(new_id);
//		System.out.println(rid.getId());
		return rid.getId();
	}
	
	static class recommandId{
		String id;

		public recommandId(String id) {
			super();
			this.id = id;
			recId();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public void recId() {
			step1();
//			System.out.println("step1 : id : " + id);
			step2();
//			System.out.println("step2 : id : " + id);
			step3();
//			System.out.println("step3 : id : " + id);
			step4();
//			System.out.println("step4 : id : " + id);
			step5();
//			System.out.println("step5 : id : " + id);
			step6();
//			System.out.println("step6 : id : " + id);
		}
		
		//1
		public void step1() {
			id = id.toLowerCase();
		}
		//2, 3
		public void step2() {			
			Deque<Character> dq = new LinkedList<Character>();
			for(int i=0;i<id.length();i++) {
				if( (id.charAt(i) >= 'a' && id.charAt(i) <= 'z') || 
						(id.charAt(i) >= '0' && id.charAt(i) <= '9') ||
						(id.charAt(i) == '-') || 
						(id.charAt(i) == '_') || 
						(id.charAt(i) =='.')) {
					dq.add(id.charAt(i));
				}
			}
			if(dq.isEmpty()) {
				id = "";
				return;
			}
			
			id = new String();
			StringBuilder sb = new StringBuilder();
			char ch = dq.pollFirst();
			boolean is_dot = false;
			if(ch == '.') is_dot = true;
			sb.append(ch);
			while(!dq.isEmpty()) {
				ch = dq.pollFirst();
				if(ch == '.' && is_dot == true) {
					continue;
				}
				
				sb.append(ch);
				
				if(ch == '.') is_dot = true;
				else is_dot = false;
			}
			id = sb.toString();
		}
		//4
		public void step3() {
			if(id.equals("")) return;
			if(id.equals(".")) {
				id = "";
				return;
			}
			int start = 0;
			int end = id.length()-1;
			for(int i=0;i<end;i++) {
				if(id.charAt(i) != '.') {
					start = i;
					break;
				}
			}
			for(int i=end;i>=0;i--) {
				if(id.charAt(i) != '.') {
					end = i;
					break;
				}
			}
			if(start > end) {
				id = "";
				return;
			}
			StringBuilder sb = new StringBuilder();
			for(int i=start;i<=end;i++) {
				sb.append(id.charAt(i));
			}
			id = sb.toString();
			
		}
		
		//5
		public void step4() {
			if(id.equals("")) id = "a";
		}
		
		//6
		public void step5() {			
			if(id.length() >= 16) {
				int end = 15;
				if(id.charAt(14) == '.') {
					end = 14;
				}
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<end;i++) {
					sb.append(id.charAt(i));
				}
				id = sb.toString();
			}
		}
		
		//7
		public void step6() {
			if(id.length() <= 2) {
				while(id.length() != 3) {
					id += id.charAt(id.length()-1);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
//		String i = "1";
//		System.out.println(i.length());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(br.readLine()));
	}
}
