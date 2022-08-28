import java.io.*;
import java.util.*;

public class MergeIntervals {
    public static void main(String args[]) {
       int[][] intervals = new int[][]{{8,18},{1,3}, {2,6}, {8,20} };
        //mergeIntervals(intervals);
       int[][] result = mergeIntervals(intervals);
       for(int[] interval: result) {
           System.out.println(interval[0] + "__" + interval[1]);
       }
        // using the comparator.reverseorder to create maxheap
    }

    public static int[][] mergeIntervals(int[][] intervals){
       int[][] result;
       Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
       LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
           if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
               merged.add(interval);
           } else {
               merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
           }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}