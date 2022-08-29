package org.LeetCodeMedium;

import java.io.*;
import java.util.*;


public class StringCompression {
    public static void main(String args[]) {
        char[] chars = {'a', 'b', 'b'};
                //{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
                //{'a','b','b','b'};
                //{'a','a','a','b','b','b','c','c','c','c','c'};
       char[] result = stringCompression(chars);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static char[] stringCompression(char[] chars){
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        for(int i=0; i<n; i++) {
            int count = 1;
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append(chars[i]);
            if (count != 1) {
                sb.append(count);
            }
        }
            for(int i=0; i<sb.length(); i++){
                chars[i] = sb.charAt(i);
            }
        return chars;
    }
}