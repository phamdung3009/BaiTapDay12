package org.example.ontap.baitapvenha.day12.lamlaibaitap;

import java.util.HashMap;
import java.util.Map;

public class Bai2_1 {
    public static void findSubstrings(String input, int length) {
        int inputLength = input.length();
        for (int i = 0; i <= inputLength - length; i++) {
            String substring = input.substring(i, i + length);
            System.out.println(substring);
        }
    }

    public static Map<String, Integer> countSubstrings(String input, int length) {
        Map<String, Integer> substringCountMap = new HashMap<>();
        int inputLength = input.length();

        for (int i = 0; i <= inputLength - length; i++) {
            String substring = input.substring(i, i + length);
            substringCountMap.put(substring, substringCountMap.getOrDefault(substring, 0) + 1);
        }

        return substringCountMap;
    }
    public static void main(String[] args) {
        String input = "abcabc";
        int length = 2;

        System.out.println("cac chuoi co do dai " + length + ":");
        findSubstrings(input, length);
        Map<String, Integer> result = countSubstrings(input, length);
        System.out.println("so lan chuoi:");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

}
