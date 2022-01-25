module com.alarm.alarm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alarm.alarm to javafx.fxml;
    exports com.alarm.alarm;
}