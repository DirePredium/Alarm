module com.alarm.alarm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.alarm.alarm to javafx.fxml;
    exports com.alarm.alarm;
    exports com.alarm.alarm.userinterface;
    opens com.alarm.alarm.userinterface to javafx.fxml;
    exports com.alarm.alarm.controller;
    opens com.alarm.alarm.controller to javafx.fxml;
    exports com.alarm.alarm.object;
    opens com.alarm.alarm.object to javafx.fxml;
}