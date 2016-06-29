package com.AVM.lab37;


import static java.lang.Math.abs;

/**
 *
 *
 * Реализовать функцию, которая делает циклический сдвиг букв вправо, то есть
 * rightShift("ABCDE", 1) = "EABCD"
 * rightShift("ABCDE", 2) = "DEABC"
 * rightShift("ABCDE", 3) = "CDEAB"
 * rightShift("ABCDE", 4) = "BCDEA"
 *
 * Допустимо сдвигать на расстояние больше длины строки
 * rightShift("ABCDE", 5) = "ABCDE"
 * rightShift("ABCDE", 6) = "EABCD"
 * rightShift("ABCDE", 7) = "DEABC"
 *
 * Допустимо сдвигать на отрицательное расстояние (выходит сдвиг влево)
 * rightShift("ABCDE", -1) = "BCDEA"
 * rightShift("ABCDE", -2) = "CDEAB"
 * rightShift("ABCDE", -7) = "CDEAB".
 *
 * Сдвиг на расстояние 0 и сдвиги строк длиной 0 и 1 символ - разрешены.
 *
 * Created by AVM on 24.06.2016.
 */
public class StringUtils {
    public static String rightShift(String arg, int delta) {
        if (arg.isEmpty()){
            return "";
        }

        if (abs((long)delta) > arg.length()){
            delta = delta % arg.length();
        }

        if (delta >= 0) {
              delta = arg.length() - delta;
        }
        if (delta < 0) {
            delta  = (-1) * delta;
        }
        return arg.substring(delta) + arg.substring(0, delta);
    }
}
