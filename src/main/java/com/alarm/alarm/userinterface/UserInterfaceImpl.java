package com.alarm.alarm.userinterface;

import com.alarm.alarm.AlarmApplication;
import com.alarm.alarm.userinterface.IUserInterfaceContract;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.alarm.alarm.AlarmApplication;

public class UserInterfaceImpl {
    private final Stage stage;
    private final Parent root;

    private IUserInterfaceContract.EventListener listener;

    private static final double WINDOW_Y = 700;
    private static final double WINDOW_X = 500;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    private static final String FILE_MAIN_VIEW = "mainView.fxml";


    public UserInterfaceImpl(Stage stage) throws IOException {
        this.stage = stage;    //записываем стейдж в поля объекта
        this.root = addRoot();  //записываем подключение к файлу фхмл, что бы он отрисовывал страницу
        initializeUserInterface(); // идем в метод инициализации стейджа
    }

    private Parent addRoot() throws IOException {
        return FXMLLoader.load(Objects.requireNonNull(AlarmApplication.class.getResource(FILE_MAIN_VIEW))); //подключает файл(FILE_MAIN_VIEW) фхмл
    }

    public void initializeUserInterface() throws IOException {
        stage.setTitle("Alarm");   // задаем титл
        drawBackground();   // отрисовываем ззадний фон
        stage.show();
    }
    private void drawBackground() throws IOException {
        Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);  // в сцену передаем (корень отрисовки, размер по высоте, по ширине)
        scene.getStylesheets().add("/style/style.css");  // подключаем стили цсс к нашей страницке
        stage.setScene(scene); // теперь берем экземпляр создаваемого стейджа приложения и отрисовывем сцену
    }
}