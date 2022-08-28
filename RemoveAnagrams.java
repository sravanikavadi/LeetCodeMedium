package org.LeetCodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAnagrams {
    public static void main(String args[]){
        String[] strings = {"god", "dog", "ogd", "ab", "ba", "cat"};
        removeAnagrams(strings);
        System.out.println(removeAnagrams(strings));
    }
    public static List<String> removeAnagrams(String[] strings){
        String prev = "";
        List<String> results = new ArrayList<>();
        for(String s1: strings){
            char[] temp = s1.toCharArray();
            Arrays.sort(temp);
            String curr = String.valueOf(temp);
            if(!curr.equals(prev)){
                results.add(s1);
                prev = curr;
            }
        }
        return results;
    }
}
