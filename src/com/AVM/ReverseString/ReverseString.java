package com.AVM.ReverseString;

import java.util.Stack;

/**
 * Created by AVM on 20.07.2016.
 */
public class ReverseString {

    public static void main(String[] args) {
        String candidate = "Строка для разворота.";
        System.out.println(reverseByArray(candidate));
        System.out.println(reverseByStack(candidate));
        System.out.println(reverseByStringBuilder(candidate));
        System.out.println(Reverse(candidate));

    }

        public static String Reverse(String str) {
            String result = "";
            char[] ch = str.toCharArray();
            for (int i = str.length() - 1; i >= 0; i--) {
                result = result + ch[i];
            }
            return result;
        }


    public static String reverseByArray(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(a.length - 1) - i] = a[i];
        }
        return new String(b);
    }


    public static String reverseByStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseByStack(String s) {
        Stack<Character> st = new Stack<Character>();
        for (Character character : s.toCharArray()) {
            st.add(character);
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

}