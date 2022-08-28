import java.io.*;
import java.util.*;


public class CoinChange {
    public static void main(String args[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 6249;
        int[] coins = {186,419,83,408};
        int result = minimumCoinChange(total, coins, map);
        System.out.println(result);
    }

    public static int minimumCoinChange(int total, int[] coins, Map<Integer, Integer> map){
        if(total == 0) {
            return 0;
        }
        if(map.containsKey(total)) {
            return map.get(total);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i< coins.length; i++){
            if(coins[i] > total) {
                continue;
            }
            int val = minimumCoinChange(total-coins[i], coins, map);

            if(val < min && val >=0){
                min = val;
            }
        }
        min =  (min == Integer.MAX_VALUE ? -1 : min + 1);
        map.put(total, min);
        return min;
    }
}