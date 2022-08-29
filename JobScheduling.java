package org.LeetCodeMedium;

import java.util.Arrays;
import java.util.TreeMap;

public class JobScheduling {
    public static void main(String args[]){
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        System.out.println(getMaxProfitForJobScheduling(startTime, endTime, profit));
    }
    public static int getMaxProfitForJobScheduling(int[] startTime, int[] endTime, int[]profit){
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs,(a,b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0,0);
        for(int[]job: jobs){
            int curr = dp.floorEntry(job[0]).getValue() + job[2];
            if(curr > dp.lastEntry().getValue()){
                dp.put(job[1], curr);
            }
        }
        return dp.lastEntry().getValue();
    }
}
