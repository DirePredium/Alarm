package com.alarm.alarm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class MainController {
    private EventHandler<ActionEvent> AlarmHandler;
    @FXML
    public Button fxButton;
    @FXML
    public Button fxButton2;
    @FXML
    public Button fxButton3;
    @FXML
    public Button fxButton4;
    @FXML
    public TilePane tilePane;
    @FXML
    public HBox vBox1;

    private void setAlarmHandler(){
        this.AlarmHandler  = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Click!!!");
                Button btn4 = new Button("clickMe");
                Button btn5 = new Button("clickMe");
                btn4.setOnAction(AlarmHandler);
                btn5.setOnAction(AlarmHandler);
                FlowPane gr1 = new FlowPane(btn4, btn5);
                tilePane.getChildren().add(gr1);
            }
        };
    }

    @FXML
    protected void click() {
        if(AlarmHandler == null)
            setAlarmHandler();
        System.out.println("Click!!!");
        Button btn4 = new Button("clickMe");
        Button btn5 = new Button("clickMe");
        btn4.setOnAction(AlarmHandler);
        btn5.setOnAction(AlarmHandler);
        FlowPane gr1 = new FlowPane(btn4, btn5);
        tilePane.getChildren().add(gr1);
    }

    @FXML
    protected void zooms() {
        fxButton.setText("2");
    }
}