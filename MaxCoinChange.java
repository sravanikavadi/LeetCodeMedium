import java.io.*;
import java.util.*;


public class MaxCoinChange {
    public static void main(String args[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 5;
        int[] coins = {2, 10};
        int result = maximumCoinChange(total, coins, map);
        System.out.println(result);
    }

    public static int maximumCoinChange(int total, int[] coins, Map<Integer, Integer> map){
      if(total == 0) return 0;
      if(total <0) return -1;
      int max = Integer.MIN_VALUE;
      for(int i=0; i<coins.length; i++){
        if(coins[i] > total) {
            continue;
        }
        int val = maximumCoinChange(total-coins[i], coins, map);
        if(val > max) {
            max = val;
        }
      }
      max = (max == Integer.MIN_VALUE || max <= 0 ? -1 : max + 1);
      map.put(total, max);
      return max;
    }
}