import java.io.*;
import java.util.*;


public class StringCompression {
    public static void main(String args[]) {
        char[] chars = {'a','a','a','b','b','b','c','c','c','c','c'};
       char[] result = stringCompression(chars);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static char[] stringCompression(char[] chars){
        char temp = chars[0];
        int count = 0;
        for(int i=0, j=0; i<chars.length-1 && j<chars.length-1; j++){
           if(chars[j] != temp) {
               chars[i+1] = Integer.toString(count).charAt(0);
               temp = chars[j];
               chars[i+2] = temp;
               count =0;
            } else {
               count++;
           }
        }
        return chars;
    }
}