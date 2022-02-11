package com.alarm.alarm;

import com.alarm.alarm.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class AlarmApplication extends Application {
    private UserInterfaceImpl uiImpl;


    @Override
    public void start(Stage primaryStage) throws IOException {
        uiImpl = new UserInterfaceImpl(primaryStage); // создает экземпляр класс UserInterfaceImpl и передает туда страницу приложения джава фх
    }

    public static void main(String[] args) {
        launch(args); // запускается джава fx
    }
}


