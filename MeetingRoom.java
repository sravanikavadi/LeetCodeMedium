package org.LeetCodeMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * https://leetcode.com/submissions/detail/719112839/
 *
 */
public class MeetingRoom {
    public static void main(String args[]){
        int[][] intervals ={{7,10}, {2,4}};
                //{{0,30}, {5,10}, {15,20}};
        System.out.println(jobSchedule(intervals));
    }
    public static int jobSchedule(int[][] intervals){
        if(intervals.length == 0){
            return 0;
        }
        PriorityQueue allocator = new PriorityQueue<Integer>(intervals.length, (a,b) -> a-b);

       Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(final int[]a, final int[]b){
               return a[0]-b[0];
           }
        });
        allocator.add(intervals[0][1]);
        for(int i=1; i<intervals.length; i++){
            if (intervals[i][0] >= (int)allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}
