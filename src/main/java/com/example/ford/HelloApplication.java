package com.example.ford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        //Method
        //Integer to Roman Number
        //1 to 3000

        System.out.println(translator(40));
    }

    public static String translator(Integer intNumber) {
        //I,II,III
        //I, IV, V, IX, X, XL, L, XC, C, CD, D, CM, M
        //1, 4, 5, 9, 40, 50, 90, 100, 400, 500, 900, 1000
        Map<Integer, String> romanN = new HashMap<>();
        romanN.put(1, "I");
        romanN.put(4, "IV");
        romanN.put(5, "V");
        romanN.put(9, "IX");
        romanN.put(10, "X");
        romanN.put(40, "XL");
        romanN.put(50, "L");
        romanN.put(90, "XC");
        romanN.put(100, "C");
        romanN.put(400, "CD");
        romanN.put(500, "D");
        romanN.put(900, "CM");
        romanN.put(1000, "M");

        if(romanN.containsKey(intNumber)) {
            return romanN.get(intNumber);
        }


        return null;
    }
}