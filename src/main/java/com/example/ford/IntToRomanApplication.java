package com.example.ford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntToRomanApplication {

    public static void main(String[] args) {
        //launch();
        //Method
        //Integer to Roman Number
        //1 to 3000

        //System.out.println(translator(899));
        solution(899);
    }

    public static StringBuilder translator(Integer arabic) {
        //I, IV, V, IX, X, XL, L, XC, C, CD, D, CM, M
        //1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(2, "II");
        romanMap.put(3, "III");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(6, "VI");
        romanMap.put(7, "VII");
        romanMap.put(8, "VIII");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        if(romanMap.containsKey(arabic)) {
            return new StringBuilder(romanMap.get(arabic));
        }

        int pow = arabic.toString().length()-1;
        Integer[] arr = getNumbers(arabic, pow);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            if(romanMap.containsKey(arr[i])) sb.append(romanMap.get(arr[i]));
        }

        return sb;
    }

    public static Integer[] getNumbers(Integer arabic, int pow) {
        List<Integer> list = new ArrayList<>();
        double n = arabic;

        while(n > 10) {
            int unit = Character.getNumericValue(String.valueOf(n).charAt(0));
            list.add((int) (unit * (Math.pow(10,pow))));
            n -= unit * Math.pow(10,pow);
            list.add((int) n);

            pow = String.valueOf(n).length() - 3;
        }

        list.forEach(System.out::println);
        return list.toArray(new Integer[0]);
    }

    public static void solution(Integer arabic) {
        System.out.println("Arabic: " + arabic);

        int[] arabicValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0; i < arabicValues.length; i++) {
            while(arabic >= arabicValues[i]) {
                arabic -= arabicValues[i];
                roman.append(romanValues[i]);
            }
        }

        System.out.println("Roman: " + roman.toString());
    }

}