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
        this.stage = stage;
        this.root = addRoot();
        initializeUserInterface();
    }

    private Parent addRoot() throws IOException {
        //FXMLLoader root = new FXMLLoader(AlarmApplication.class.getResource(FILE_MAIN_VIEW));
        return FXMLLoader.load(Objects.requireNonNull(AlarmApplication.class.getResource(FILE_MAIN_VIEW)));
    }

    public void initializeUserInterface() throws IOException {
        stage.setTitle("Alarm");
        drawBackground();
        stage.show();
    }
    private void drawBackground() throws IOException {
        Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
        scene.getStylesheets().add("/style/style.css");
        stage.setTitle("Alarm");
        stage.setScene(scene);
    }

    private void drawBlocksTilePane() {
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
        TilePane tile = new TilePane(Orientation.VERTICAL, btn, label2, label3, label4, label5, label6, label7);
        tile.getChildren().add(gr1);
        tile.setPrefTileWidth(Double.MAX_VALUE);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label label1 = new Label("Label1");
                Button btn5 = new Button("Btn1");
                FlowPane gr1 = new FlowPane(btn5, label1);
                tile.getChildren().add(gr1);
            }
        });

        //root.getChildren().add(tile);
    }
}
