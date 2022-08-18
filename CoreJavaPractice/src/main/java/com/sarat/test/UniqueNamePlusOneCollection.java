package com.sarat.test;

import java.util.*;

/**
 * This problem, i could not finished in Altimetrik.
 */
public class UniqueNamePlusOneCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("sarat", "lipi", "sumit", "sarat", "lipi", "sarat","lipi","sumit");

        System.out.println(getUniqueNames(names));
    }

    private static List<String> getUniqueNames(List<String> names) {

        List<String> nameUniqueList = new ArrayList<>();
        Map<String, Integer> namesMap = new HashMap<>();
        int count = 1;
        for (String name : names) {
            if (namesMap.isEmpty()) {
                namesMap.put(name, count);
                nameUniqueList.add(name);
            } else{
                Set<String> nameKeySet = namesMap.keySet();

                if(nameKeySet.contains(name)){
                    namesMap.put(name, namesMap.get(name)+count);
                    nameUniqueList.add(name+(namesMap.get(name)-1));
                }else{
                    namesMap.put(name,count);
                    nameUniqueList.add(name);
                }

            }

        }
        System.out.println(namesMap);


        return nameUniqueList;
    }
}
