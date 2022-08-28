package org.LeetCodeEasy;

import java.util.*;
import java.util.stream.Collectors;

public class MergeAnagrams {
    public static void main(String args[]){
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(input);
        System.out.println(groupAnagrams(input));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        //  String prev = "";
        for(String s: strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String curr = String.valueOf(temp);
            if(!map.containsKey(curr)){
                List<String> mergeList = new ArrayList<>();
                mergeList.add(s);
                map.put(curr, mergeList);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.addAll(map.get(curr));
                tempList.add(s);
                map.put(curr, tempList);
            }
        }
//        for(Map.Entry<String, List<String>> entry: map.entrySet()){
//            //System.out.println(map.get(entry.getKey()));
//            result.add(map.get(entry.getKey()));
//        }
        result = map.entrySet().stream().sorted(Comparator.comparingInt(e->e.getValue().size())).
                map(Map.Entry::getValue).
                collect(Collectors.toList());
        return result;
    }
}
