package com.sarat.test;

import java.util.Arrays;
import java.util.List;

public class FindMaxCommonCharactersFromAList {
    public static void main(String[] args) {
        //List<String> names = Arrays.asList("Rama", "rame", "ramananda", "Ramesh", "raman");

        String[] names = {"Rama", "rame", "ramananda", "Ramesh", "raman"};
        for(int i = 0; i < names.length; i++){
            names[i] = names[i].toLowerCase();
        }
        System.out.println(Arrays.asList(names));
        //System.out.println(getMaxRepeatedChars(names));
        System.out.println(findstem(names));
    }

    // function to find the stem (longest common
    // substring) from the string  array
    public static String findstem(String arr[])
    {
        // Determine size of the array
        int n = arr.length;

        // Take first word from array as reference
        String s = arr[0];
        int len = s.length();

        String res = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {

                // generating all possible substrings
                // of our reference string arr[0] i.e s
                String stem = s.substring(i, j);
                int k = 1;
                for (k = 1; k < n; k++)

                    // Check if the generated stem is
                    // common to all words
                    if (!arr[k].contains(stem))
                        break;

                // If current substring is present in
                // all strings and its length is greater
                // than current result
                if (k == n && res.length() < stem.length())
                    res = stem;
            }
        }

        return res;
    }

    private static String getMaxRepeatedChars(List<String> names) {

        String maxRepeatedChars = "";
        String tempName = names.get(0);

        for ( String name : names) {
            if(tempName.length() >= name.length()){
                tempName = name;
            }
        }

        boolean allMatched = false;
        for (String name : names){
            if (name.startsWith(tempName)){
                allMatched = true;
            }else{
                allMatched = false;
            }
        }

        /*if (allMatched){
            return tempName;
        }*/

        System.out.println(tempName);


        int count = 0;
        char[] firstNameChars = names.get(0).toCharArray();
        int len = firstNameChars.length;

        maxRepeatedChars = String.valueOf(firstNameChars[0]);

        for (String name : names) {

            for (int index = 0; index < len; index++ ){
                if(name.startsWith(String.valueOf(firstNameChars[index]))){
                    maxRepeatedChars = maxRepeatedChars + String.valueOf(firstNameChars[index]);
                }
            }
        }

        return maxRepeatedChars;
    }
}