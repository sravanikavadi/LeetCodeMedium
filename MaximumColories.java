import java.io.*;
import java.util.*;


public class MaximumColories {
    public static void main(String args[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 20;
        int[] itemPrices = {1, 2, 5, 10, 25};
        int[] calories = {100, 300, 200, 600, 100};
        int result = maximumCalories(total, itemPrices, 0, calories, "", map);
        System.out.println(result);
    }

    public static int maximumCalories(int total, int[] itemPrices, int cal, int[] calories, String path, Map<Integer, Integer> map){
      //if(total <0) return -1;
       // if(total == 0) return 0;
       if(map.containsKey(total)) return map.get(total);
        int max = Integer.MIN_VALUE;
      for(int i=0; i<itemPrices.length; i++){
        if(itemPrices[i] > total) {
            continue;
        }
        int val = maximumCalories(total-itemPrices[i], itemPrices, cal , calories, path+" "+itemPrices[i], map) + calories[i];
          if(val > max) {
              max = val;
          }
      }
       max = (max == Integer.MIN_VALUE ? 0 : max);
        map.put(total, max);

        System.out.println(map);
        System.out.println(path);

        return max;
    }
}