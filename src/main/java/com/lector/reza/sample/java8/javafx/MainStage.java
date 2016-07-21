package com.lector.reza.sample.java8.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Reza Mousavi reza.mousavi@lector.dk on 7/19/2016
 */
public class MainStage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Thread.currentThread().getStackTrace();
        final Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((e) -> System.out.println("Hello world!"));

        final StackPane root = new StackPane();
        root.getChildren().add(btn);


        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
