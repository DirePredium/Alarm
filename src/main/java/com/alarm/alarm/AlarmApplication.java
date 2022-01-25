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

//        Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        uiImpl = new UserInterfaceImpl(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    public Button fxButton;
    public void click(ActionEvent actionEvent) {
        System.out.println("Hello World");
        fxButton.setText("Hey!");
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
