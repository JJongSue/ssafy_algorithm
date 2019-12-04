package programers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTest2_Solution2 {
	static class truck{
		int weight;
		int time;
		public truck(int weight, int time) {
			super();
			this.weight = weight;
			this.time = time;
		}
		
	}
	static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Arrays.sort(truck_weights);
        int first = 0;
        int last = truck_weights.length-1;
        int queweight = 0;
        Queue<truck> q = new LinkedList<truck>();
        int time = 0;
        while(first <= last ) {
        	if(!q.isEmpty()) {
        		if( q.peek().time == time ) {
        			queweight -= q.peek().weight;
        			q.poll(); 
        		}
        	}
        	if(queweight+truck_weights[last]<= weight) {
        		queweight += truck_weights[last];
        		q.add(new truck(truck_weights[last], time+bridge_length));
        		last--;        		
        	}
        	else if(queweight+truck_weights[first]<= weight) {
        		queweight += truck_weights[first];
        		q.add(new truck(truck_weights[first], time+bridge_length));
        		first++;
        	} 
        	time++;
        	
        }
        while(!q.isEmpty()) {
        	if( q.peek().time == time ) {
    			queweight -= q.peek().weight;
    			q.poll(); 
    		}
        	time++;
        }
        return time;
    }
	
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int []truck_weights = {7,4,5,6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}
