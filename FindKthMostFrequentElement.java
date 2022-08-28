import java.io.*;
import java.security.PublicKey;
import java.util.Comparator;
import java.util.*;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindKthMostFrequentElement {
    public static void main(String args[]) {
       int[] arr = new int[]{2, 2, 3, 4, 1, 1, 1};
       int k = 2;
       Map<Integer, Integer> map = new HashMap<>();
       for(int n: arr){
         if(!map.containsKey(n)) {
             map.put(n, 1);
         } else {
             map.put(n, map.get(n)+1);
         }
       }
       //Output should be {1, 2}
      // System.out.println("kth smallest Element = "+ getKthMostFrequentElement(arr, k)); // using the comparator.reverseorder to create maxheap
        int[] result = getKthMostFrequentElementUsingLambda(map, k);
       System.out.println("kth most frquent Elements = "+ Arrays.toString(result)); // using the lambda expression (a,b) -> b-a for creating max heap
    }

//    public static int getKthMostFrequentElement(int[] arr, int k){
//        PriorityQueue minHeap = new PriorityQueue(Comparator.naturalOrder());
//        for(int i=0; i<arr.length; i++){
//            minHeap.add(arr[i]);
//         }
//        for(int i=0; i<k-1; i++){
//            minHeap.poll();
//        }
//        return (int)minHeap.peek();
//    }
    public static int[] getKthMostFrequentElementUsingLambda(Map<Integer, Integer> map, int k){
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
       map.entrySet().forEach(e-> maxHeap.add(e));
           while(maxHeap.size() < k) {
               maxHeap.poll();

           }
       for(int i=0; i<k; i++){
           result[i] = maxHeap.poll().getKey();
       }
       return result;
    }
}