import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Find top n frequent elements from Array
 * 
 * Ex : [1,2,3,1,2,4] and n = 2, result =  [1,2].
 * 
 *  @author Sbhutada
 *  
 */
public abstract class TopFrequentElements {

	 public static List<Integer> topnFrequentElements(int[] nums, int n) 
	 {	
		 Map<Integer, Integer> map = new HashMap<>();
		
		 for (int i = 0; i < nums.length; i++) 
		 {
			 if(map.containsKey(nums[i]))
			 {
				 map.put(nums[i], map.get(nums[i])+1);
			 }
			 else
			 {
				 map.put(nums[i], 1);
			 }
		 }
		 
		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}	
		});
		 
		for(Map.Entry<Integer, Integer> m : map.entrySet())		 
		{
			queue.add(new int[] {m.getKey(), m.getValue()});
		}

		List<Integer> list = new ArrayList<>();
		 
		 while(list.size()<n)
		 {
			 int[] arr = queue.poll();
			 list.add(arr[0]);
		 }
		 
		 return list;  
	 }
	 
	 public static void main(String[] args) {
			
			int[] arr = {1,2,3,1,2,4};
			int n = 2;
			List<Integer> result = topnFrequentElements(arr,n);
			System.out.println("Top N Elements "+result);

		}
}
