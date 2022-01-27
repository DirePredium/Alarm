package com.alarm.alarm;

import com.alarm.alarm.userinterface.IUserInterfaceContract;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class MainController {
    @FXML
    public Text momentDate;
    @FXML
    public ImageView calendarImg;
    @FXML
    private ScrollPane canvas;
    private EventHandler<ActionEvent> AlarmHandler;
    private static ArrayList<HBox> tilesArray = new ArrayList<HBox>();
    @FXML
    public Text momentTime;
    @FXML
    public TilePane tilePane;
    @FXML
    public TextField hours;
    @FXML
    public TextField minutes;
    @FXML
    public TextField description;
    @FXML
    public HBox TileHBox;

    private static MyThread momentDateTime;
    private static MyThread momentDateThreade;

    private static double applicationHeight = 219;

    @FXML
    private void initialize() {
        if(momentDateThreade == null){
            momentDateThreade = new MyThread();
        }
    }

    private void transformationTileNodes(ObservableList<Node> observableList){
        Text descriptionUserIntarface = (Text) observableList.get(0);
        Text timeUserIntarface = (Text) observableList.get(1);
        Text dateUserIntarface = (Text) observableList.get(2);
        ToggleButton nade4 = (ToggleButton) observableList.get(3);

        descriptionUserIntarface.setText(description.getText());
        timeUserIntarface.setText(hours.getText()+":"+minutes.getText());
        dateUserIntarface.setText("Date");
    }

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


    public class MyThread extends Thread {
        // Конструктор
        MyThread() {
            // Создаём новый поток
            super("Второй поток");
            System.out.println("Создан второй поток ");
            start();
        }

        public void run() {
            System.out.println("!!!");
            try {
                while (true){
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(
                            "HH:mm:ss", Locale.getDefault());// dd:MMMM:yyyy HH:mm:ss a
                    final String strDate1 = simpleDateFormat1.format(calendar.getTime());
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
                            "dd MMMM yyyy", Locale.getDefault());// dd:MMMM:yyyy HH:mm:ss a
                    final String strDate2 = simpleDateFormat2.format(calendar.getTime());


                    momentTime.setText(strDate1);
                    momentDate.setText(strDate2);

                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Второй поток прерван");
            }
        }
    }

    private void createCalendar(){
        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

        tilePane.getChildren().add(new Label("Start Date:"));
        tilePane.getChildren().add(startDatePicker);

        System.out.println(startDatePicker);//+endDatePicker
    }
    @FXML
    protected void click() throws IOException {
        createCalendar();
        HBox tileContainer = FXMLLoader.load(Objects.requireNonNull(AlarmApplication.class.getResource("tileContainer.fxml")));
        transformationTileNodes(tileContainer.getChildren());
        tilesArray.add(tileContainer);
        tilePane.getChildren().add(tileContainer);
        addHeight();
    }

    private void addHeight(){
        applicationHeight += 97;
        if(applicationHeight>400){
            tilePane.setPrefHeight(applicationHeight + 97.0);
        }
    }

    public void imgClick(MouseEvent mouseEvent) {
        System.out.println("AUE");
        createCalendar();
    }
}