package com.sda.service;

public class StringCalcService {
    public int calc(String value) {
        int sum = 0;
        String[] split = value.split(";");
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }
}
