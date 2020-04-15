package day200405;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6 {
	static class folder{
		String name;
		folder under = null;
		folder next = null;
		public folder(String name, folder under, folder next) {
			super();
			this.name = name;
			this.under = under;
			this.next = next;
		}
		public folder(String name) {
			super();
			this.name = name;
		}
		
		
	}
	static public String[] solution(String[] directory, String[] command) {
        String[] answer = {};
        
        
        
        ArrayList<String> al = new ArrayList<String>();
        for(int i=0;i<directory.length;i++) {
        	al.add(directory[i]);
        }
        for(int i=0;i<command.length;i++) {
        	StringTokenizer st = new StringTokenizer(command[i]);
        	String cmd = st.nextToken();
        	if(cmd.charAt(0) == 'm') {
        		
        		al.add(st.nextToken());
        	}else if(cmd.charAt(0) == 'r') {
        		String str = st.nextToken();
        		for(int j=0;j<al.size();j++) {
        			if(al.get(j).length() >= str.length()) {
        				String cmp = al.get(j);
        				boolean is_rm = true;
        				for(int k=0;k<str.length();k++) {
        					if(cmp.charAt(k) != str.charAt(k)) {
        						is_rm = false;
        						break;
        					}
        				}
        				if(is_rm) {
        					al.remove(j);
        					j--;
        				}
        			}
        		}
        	}else if(cmd.charAt(0) == 'c') {
        		String str = st.nextToken();
        		String to = st.nextToken();
        		if(to.equals("/")) continue;
        		int size = al.size();
        		for(int j=0;j<size;j++) {
        			if(al.get(j).length() >= str.length()) {
        				String cmp = al.get(j);
        				boolean is_rm = true;
        				for(int k=0;k<str.length();k++) {
        					if(cmp.charAt(k) != str.charAt(k)) {
        						is_rm = false;
        						break;
        					}
        				}
        				if(is_rm) {
        					if(to.equals("/")) al.add(al.get(j));
        					else al.add(to+al.get(j));
        					//al.add((to+al.get(j);
        					//al.remove(j);
        					//j--;
        				}
        			}
        		}
        	}
        	
        }
        answer = new String[al.size()];
        for(int i=0;i<al.size();i++) answer[i] = al.get(i);
        Arrays.sort(answer);
        
        return answer;
    }
	
	public static void main(String[] args) {
		String dir[] = {"/"};
		String cmd[] = {
				"mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c"
//				"mkdir /root",
//				"mkdir /a",
//				"mkdir /a/aa",
//				"cp /a /root"
//				//"rm /a"
		};
		
		String str[] = new String[solution(dir, cmd).length];
		str = solution(dir, cmd);
		for(int i=0;i<solution(dir, cmd).length;i++) {
			System.out.println(str[i]);
		}
	}
}
