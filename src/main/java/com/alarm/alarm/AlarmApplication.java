package com.alarm.alarm;

import com.alarm.alarm.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import java.io.IOException;

public class AlarmApplication extends Application {
    private UserInterfaceImpl uiImpl;

    /*@Override
    public void start(Stage primaryStage) throws IOException {
        Get SudokuGame object for a new game
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
           e.printStackTrace();
            throw e;
        }
    }*/
    @Override
    public void start(Stage stage) {
        ArrayList<Button> Btns = new ArrayList<Button>();

        Button btn = new Button();
        btn.setText("Click1");
        Btns.add(btn);





        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");
        Label label4 = new Label("Label4");
        Label label5 = new Label("Label5");
        Label label6 = new Label("Label6");
        Label label7 = new Label("Label7");
        Label labelx = new Label("Label1");
        FlowPane gr1 = new FlowPane(labelx);

        //VBox root = new VBox(10, btn, label2, label3, label4, label5, label6, label7);
        TilePane root = new TilePane(Orientation.VERTICAL, btn, label2, label3, label4, label5, label6, label7);


        root.getChildren().add(gr1);
        root.setPrefTileWidth(Double.MAX_VALUE);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label label1 = new Label("Label1");
                Button btn5 = new Button("Btn1");
                FlowPane gr1 = new FlowPane(btn5, label1);
                root.getChildren().add(gr1);
            }
        });
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);

        stage.setTitle("VBox in JavaFX");

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



/*
    @Override
    public void init() throws Exception {

        System.out.println("Application inits");
        super.init();
    }

    @Override
    public void start(Stage stage) {
        ArrayList<Button> Btns = new ArrayList<Button>();

        Button btn = new Button();
        btn.setText("Click1");
        Btns.add(btn);





        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");
        Label label4 = new Label("Label4");
        Label label5 = new Label("Label5");
        Label label6 = new Label("Label6");
        Label label7 = new Label("Label7");
        Label labelx = new Label("Label1");
        FlowPane gr1 = new FlowPane(labelx);

        //VBox root = new VBox(10, btn, label2, label3, label4, label5, label6, label7);
        TilePane root = new TilePane(Orientation.VERTICAL, btn, label2, label3, label4, label5, label6, label7);


        root.getChildren().add(gr1);
        root.setPrefTileWidth(Double.MAX_VALUE);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label label1 = new Label("Label1");
                Button btn5 = new Button("Btn1");
                FlowPane gr1 = new FlowPane(btn5, label1);
                root.getChildren().add(gr1);
            }
        });
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);

        stage.setTitle("VBox in JavaFX");

        stage.show();
    }
    @Override
    public void stop() throws Exception {

        System.out.println("Application stops");
        super.stop();
    }
    */
