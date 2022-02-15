package com.alarm.alarm.userinterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ModalWindow {
    public static void newWindow(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Pane pane = new Pane();

        Button btn = new Button("Click");
        btn.setPrefWidth(80);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });

        pane.getChildren().add(btn);
        Scene scene = new Scene(pane,100,100);
        window.setScene(scene);
        window.setTitle("!!");
        window.showAndWait();
    }
}
