package org.caveman.utils;

import java.util.HashMap;
import java.util.Map;

public class NumberConverter {
    private final Map<String,String> hexValues = new HashMap<String,String>();
    private final Map<String, String> binaryValues = new HashMap<>();

    public NumberConverter(){
        init();
    }
    private void init(){
        hexValues.put("0","0");
        hexValues.put("1","1");
        hexValues.put("10","2");
        hexValues.put("11","3");
        hexValues.put("100","4");
        hexValues.put("101","5");
        hexValues.put("110","6");
        hexValues.put("111","7");
        hexValues.put("1000","8");
        hexValues.put("1001","9");
        hexValues.put("1010","A");
        hexValues.put("1011","B");
        hexValues.put("1100","C");
        hexValues.put("1101","D");
        hexValues.put("1110","E");
        hexValues.put("1111","F");
        // Reverse the map
        for (Map.Entry<String, String> entry : hexValues.entrySet()) {
            binaryValues.put(entry.getValue(), entry.getKey());
        }
    }
    public String hexToBinary(String hex){
        StringBuilder binary = new StringBuilder();
        for (char c : hex.toCharArray()) {
            String s = binaryValues.get(Character.toString(c));
            if (s.length() < 4) {
                int zerosToAdd = 4 - s.length();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < zerosToAdd; j++) {
                    sb.append("0");
                }
                sb.append(s);
                s = sb.toString();
            }
            binary.append(s);
        }
        return binary.toString();
    }
    private String removeZeroFromLeft(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public String binaryToHex(String binary) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 4) {
            int index = binary.length() - i;
            int secIndex = clamp(index-4,0,binary.length());
            String s = binary.substring(secIndex,index);
            s = removeZeroFromLeft(s);
            builder.append(hexValues.get(s));
        }
        return builder.reverse().toString();
    }
    public long binaryToLong(String binary) {
        long result = 0;
        for (int i = 0; i < binary.length(); ++i) {
            char c = binary.charAt(binary.length() - 1 - i);
            switch (c) {
                case '1': result |= (1L << i); break;
                case '0': break;
                default: throw new RuntimeException("bad char " + c);
            }
        }
        return result;
    }
    public long hexToLong(String hex){
        return binaryToLong(hexToBinary(hex));
    }
    public String longToBinary(long n){
        StringBuilder builder = new StringBuilder();
        while (n != 0){
            builder.append(n % 2);
            n = n/2;
        }
        builder.reverse();
        return builder.toString();
    }

    public String longToHex(long number){
        return binaryToHex(longToBinary(number));
    }
}
