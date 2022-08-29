package org.LeetCodeMedium;

/**
 * https://leetcode.com/problems/reverse-integer/solution/
 */
public class ReverseIntegerWithConditions {
    public static void main(String args[]){
        int n = 123;
        System.out.println(reverse(n));
    }
    public static int reverse(int x){
        int rem = 0;
        while(x != 0){
            int pop = x%10;
            x = x/10;
            if(rem > Integer.MAX_VALUE/10 || (rem == Integer.MAX_VALUE/10 && pop >7)) return 0;
            if(rem < Integer.MIN_VALUE/10 || (rem == Integer.MIN_VALUE/10 && pop < -8)) return 0;
        }
        return rem;
    }
}
