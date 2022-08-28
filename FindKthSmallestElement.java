import java.io.*;
import java.security.PublicKey;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindKthSmallestElement {
    public static void main(String args[]) {
       int[] arr = new int[]{6, 10, 5, 3, 9, 2, 1};
       int k = 4;
       System.out.println("kth smallest Element = "+ getKthSmallestNumber(arr, k)); // using the comparator.reverseorder to create maxheap
       System.out.println("kth smallest Element = "+ getKthSmallestNumberUsingLambda(arr, k)); // using the lambda expression (a,b) -> b-a for creating max heap
    }

    public static int getKthSmallestNumber(int[] arr, int k){
        PriorityQueue minHeap = new PriorityQueue(Comparator.naturalOrder());
        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
         }
        for(int i=0; i<k-1; i++){
            minHeap.poll();
        }
        return (int)minHeap.peek();
    }
    public static int getKthSmallestNumberUsingLambda(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b-a);
       for(int n: arr){
           minHeap.add(n);
           if(minHeap.size() > k) {
               minHeap.poll();
           }
       }
       return minHeap.poll();
    }
}