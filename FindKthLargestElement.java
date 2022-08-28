import java.io.*;
import java.security.PublicKey;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindKthLargestElement {
    public static void main(String args[]) {
       int[] arr = new int[]{6, 10, 5, 3, 9, 2, 1};
       int k = 4;
       System.out.println("kth largest Element = "+ getKthLargestNumber(arr, k)); // using the comparator.reverseorder to create maxheap
       System.out.println("kth largest Element = "+ getKthLargestNumberUsingLambda(arr, k)); // using the lambda expression (a,b) -> b-a for creating max heap
       populateAndPrintPriorityQueueDescendingOrder(arr); // for descendinmg order
       populateAndPrintPriorityQueueAscendingOrder(arr); // for ascending order
       populateAndPrintPriorityQueueTest(arr);
    }

    public static void populateAndPrintPriorityQueueDescendingOrder(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int n: arr){
            heap.add(n);
        }
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
    public static void populateAndPrintPriorityQueueAscendingOrder(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        for(int n: arr){
            heap.add(n);
        }
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
        System.out.println(heap);
    }
    public static int getKthLargestNumber(int[] arr, int k){
        PriorityQueue maxHeap = new PriorityQueue(Comparator.reverseOrder());
        for(int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
         }
        for(int i=0; i<k-1; i++){
            maxHeap.poll();
        }
        return (int)maxHeap.peek();
    }
    public static int getKthLargestNumberUsingLambda(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
       for(int n: arr){
           maxHeap.add(n);
           if(maxHeap.size() > k) {
               maxHeap.poll();
           }
       }
       return maxHeap.poll();
    }

    public static void populateAndPrintPriorityQueueTest(int[] arr){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for(int n: arr){
            maxHeap.add(n);
        }
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }
}