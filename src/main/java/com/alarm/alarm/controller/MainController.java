package com.alarm.alarm.controller;

import com.alarm.alarm.object.Alarm;
import com.alarm.alarm.AlarmApplication;
import com.alarm.alarm.object.Sound;
import com.alarm.alarm.userinterface.ModalWindow;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainController {
    @FXML
    public Text momentDate;
    @FXML
    public TilePane calendar;
    @FXML
    private ScrollPane canvas;
    private static ArrayList<Alarm> tilesArray;
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

    private static Date momentDateTime;

    private static DatePicker datePicker;
    private static Alarm firstAlarm;

    private static double applicationHeight = 219;
    @FXML
    private void initialize() {      // происходит когда загружается страницка
        AlarmHandler alarmHandler = new AlarmHandler();
        MomentDate momentDate = new MomentDate();   // загружаем ветку с изменением времени основного(каждые 500 мс)
        createCalendar(); // создаем дата пикер
    }

    private void transformationTileNodes(ObservableList<Node> observableList, long today) throws ParseException {
        Text descriptionUserIntarface = (Text) observableList.get(0);
        Text timeUserIntarface = (Text) observableList.get(1);
        Text dateUserIntarface = (Text) observableList.get(2);
        ToggleButton nade4 = (ToggleButton) observableList.get(3);
        descriptionUserIntarface.setText(description.getText());
        timeUserIntarface.setText(hours.getText()+":"+minutes.getText());
        String dateInString = datePicker.getValue().toString();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInString);
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        dateUserIntarface.setText(localDate.toString());
    }
    public class AlarmHandler extends Thread {
        AlarmHandler() {
            // Создаём новый поток
            super();  // загугли
            start(); // заупускаем ветку, то есть метод ран
        }

        public void run() {
            try {
                File fileSound = new File(new File("").getAbsolutePath()+"\\src\\main\\resources\\sound\\alarmsound.wav");
                Sound sound = new Sound(fileSound);
                long alarmFin = 0;
                Runnable task = new Runnable() { // создаем анонимный класс с выполнением асинхронной ветки для передачи звука
                    public void run() {
                        if(!sound.isPlaying()){
                            sound.play();
                        }
                    }
                };
                while (true){ // созадем цыкл который отрабатывает каждые 500 мс
                    if(tilesArray != null){
                        if(firstAlarm != null && firstAlarm.getIsWork() && firstAlarm.getTimeEnd(momentDateTime) < 0){ // если с будильником который должен быть первым всё ок - идём дальше
                            firstAlarm = getFirstAlarm(tilesArray);
                            Thread thread = new Thread(task);
                            thread.start();
                            //ModalWindow.newWindow();
                            addModalWindow();
                            alarmFin = momentDateTime.getTime()+5000;
                            tilesArray.get(0).setDateNull(); // передаем будильнику то что он отзвонил, ставим его время на налл
                        }
                    }
                    if(alarmFin != 0 && sound.isPlaying() && alarmFin - momentDateTime.getTime() < 0){
                        sound.close();
                    }
                    //new modAlert(Alert.AlertType.INFORMATION, "Антивирусные базы обновлены").Show();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Второй поток прерван");
            }
        }
    }

    public class MomentDate extends Thread {
        MomentDate() {
            // Создаём новый поток
            super();  // загугли
            start(); // заупускаем ветку, то есть метод ран
        }

        public void run() {
            try {
                while (true){ // созадем цыкл который отрабатывает каждые 500 мс
                    Calendar calendar = Calendar.getInstance(); // создаем экземпляр календаря
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(
                            "HH:mm:ss", Locale.getDefault());// шаблон форматировантя строки для времеени
                    final String strDate1 = simpleDateFormat1.format(calendar.getTime());  // почитай про финал  // берем текущую дату и переводим в дату
                    final Date today = calendar.getTime(); // берем текущую дату
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
                            "dd MMMM yyyy", Locale.getDefault());// шаблон форматировантя строки для даты
                    final String strDate2 = simpleDateFormat2.format(calendar.getTime());  // берем текущую дату и переводим в время


                    momentTime.setText(strDate1); // отрисовываем
                    momentDate.setText(strDate2);

                    momentDateTime = today; // для удобства записываем текущую дату в статик momentDateTime
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            }
        }
    }

    private void createCalendar(){
        datePicker = new DatePicker(); // созадем экземпляр элемента джава фх, а именно календаря
        datePicker.setValue(LocalDate.now()); // ставим дату сегодняшнюю
        calendar.getChildren().add(datePicker); // довалвляем на один из элементов джава фх(тайл пен)
    }
    @FXML
    protected void addAlarm() throws IOException {
        if(Integer.parseInt(hours.getText()) <= 0
        || Integer.parseInt(hours.getText()) > 23
        || Integer.parseInt(minutes.getText()) <= 0
        || Integer.parseInt(minutes.getText()) > 59){
            return;
        }
        String dateInString = datePicker.getValue().toString() + ' ' + hours.getText() + ':' + minutes.getText(); // берем значения от пользователя
        Alarm newAlarm = new Alarm(getAlarmDate(dateInString)); // создаем класс Будильник
        if (getAlarmDate(dateInString) == null) { // проверяем можем ли мы создать такую дату
            return;
        }
        addAlarmToMemory(newAlarm, dateInString);
        firstAlarm = getFirstAlarm(tilesArray); // определяем статическую переменную которая означает какой будильник отработает первым
        try{
            addTileElement(newAlarm);
        }catch (IOException | ParseException IOe){
            throw new IOException(IOe);
        }
        if(ifAppHigher()){// если надо добавляем высоту
            addHeight();
        }
    }

    private void addModalWindow(){
        Thread asd = new Thread(new Runnable() {
            @Override public void run() {
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        new modAlert(Alert.AlertType.INFORMATION, "Будильник сработал").Show();
                    }
                });
            }});
        asd.start();
    }

    class modAlert extends Alert {

        private Thread thread;
        private javafx.stage.Window window;

        public modAlert(AlertType alertType, String contentText, ButtonType... buttons) {
            super(alertType, contentText, buttons);
            setHeaderText("Внимание");
            window = getDialogPane().getScene().getWindow();
            System.out.println(window);
            thread = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 1000) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignored) {
                    }
                    Platform.runLater(() -> window.setOpacity(Math.max(0, window.getOpacity() - .05)));
                }
                Platform.runLater(this::close);
            });

        }

        void Show() {
            show();
            thread.start();
        }
    }

    private void addTileElement(Alarm newAlarm) throws IOException, ParseException {
        HBox tileContainer = FXMLLoader.load(Objects.requireNonNull(AlarmApplication.class.getResource("tileContainer.fxml"))); // создаем элемент джава фх будильника
        transformationTileNodes(tileContainer.getChildren(), newAlarm.getTimeEnd(momentDateTime)); // он наполняет элемент созданный для будильника
        tilePane.getChildren().add(tileContainer); // добавляем элемент на страничку приложения
        applicationHeight += 97;
    }

    private Date getAlarmDate(String dateInString){
        try {
            Date today = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateInString);
            return today;
        }catch (Exception e){ // Отлавливает ошибки, в нашем случае ошибку нулевой даты или неправильно заданной
            System.out.println(e); // выводит ошибку в консоль

            return null;
        }
    }

    private Alarm getFirstAlarm(ArrayList<Alarm> tilesArray) {
        Alarm firstAlarmTemp;
        if(firstAlarm == null){ // если будильника след нету - создаем
            firstAlarmTemp = tilesArray.get(0);
        }else {
            firstAlarmTemp = firstAlarm; // иначе берем сущеествующий
        }
        for(int i = 0; i != tilesArray.size(); i++){   // цыклом перебираем будильники
            if(firstAlarmTemp.getAlarmDate() == null && tilesArray.get(i) != null){ // если звёзды сошлись заполняем будильник который будильник звонить
                if(tilesArray.get(i).getAlarmDate() != null){  // если будильнк рабочий
                    firstAlarmTemp = tilesArray.get(i);
                }
            }
            if(firstAlarmTemp.getAlarmDate() != null && tilesArray.get(i).getAlarmDate() != null ){
                long fA = firstAlarmTemp.getAlarmDate().getTime();
                long tA = tilesArray.get(i).getAlarmDate().getTime();
                if(fA > tA){
                    firstAlarmTemp = tilesArray.get(i);   // перезаполняем будильник если создан еще какой-то который перезвонит быстрее
                }
            }
        }
        return firstAlarmTemp;
    }

    private void addAlarmToMemory(Alarm newAlarm, String dateInString) {
        if(tilesArray == null){  // если нету будильников создаем их(масив)
            tilesArray = new ArrayList<Alarm>();
        }
        tilesArray.add(newAlarm); // добавляем новый будильник в масив будильников
    }

    private void addHeight(){ // добавляем расстояние для будильников если не хватает
        tilePane.setPrefHeight(applicationHeight + 97.0);
    }

    private boolean ifAppHigher(){
        if(applicationHeight>400){
            return true;
        }
        return false;
    }
}