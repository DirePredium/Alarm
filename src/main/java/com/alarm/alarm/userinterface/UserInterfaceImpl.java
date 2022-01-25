package com.alarm.alarm.userinterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
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

import java.util.ArrayList;

public class UserInterfaceImpl implements //IUserInterfaceContract.View,
        EventHandler<KeyEvent> {
    private final Stage stage;
    private final Group root;

    private IUserInterfaceContract.EventListener listener;

    //Size of the window
    private static final double WINDOW_Y = 732;
    private static final double WINDOW_X = 668;
    //distance between window and board
    private static final double BOARD_PADDING = 50;

    private static final double BOARD_X_AND_Y = 576;
    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(224, 242, 241);
    private static final String SUDOKU = "Sudoku";

    public UserInterfaceImpl(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        initializeUserInterface();
    }


    public void initializeUserInterface() {
        stage.setTitle("Alarm");
        drawBackground(root);
        drawBlocksTilePane(root);
        stage.show();
    }

    private void drawBlocksTilePane(Group root) {
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

        root.getChildren().add(tile);
    }

    private void drawBackground(Group root) {
        Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
        scene.setFill(WINDOW_BACKGROUND_COLOR);
        stage.setScene(scene);
    }

    private void drawTextFields(Group root) {

    }

    private void styleSudokuTile(SudokuTextField tile, double x, double y) {
        /*Font numberFont = new Font(32);
        tile.setFont(numberFont);
        tile.setAlignment(Pos.CENTER);

        tile.setLayoutX(x);
        tile.setLayoutY(y);
        tile.setPrefHeight(64);
        tile.setPrefWidth(64);

        tile.setBackground(Background.EMPTY);*/
    }


    private void drawGridLines(Group root) {

    }



    private void drawSudokuBoard(Group root) {
        Rectangle boardBackground = new Rectangle();
        boardBackground.setX(BOARD_PADDING);
        boardBackground.setY(BOARD_PADDING);
        boardBackground.setWidth(BOARD_X_AND_Y);
        boardBackground.setHeight(BOARD_X_AND_Y);
        boardBackground.setFill(BOARD_BACKGROUND_COLOR);
        root.getChildren().add(boardBackground);
    }

    private void drawTitle(Group root) {
        Text title = new Text(235, 690, SUDOKU);
        title.setFill(Color.WHITE);
        Font titleFont = new Font(43);
        title.setFont(titleFont);
        root.getChildren().add(title);
    }


    @Override
    public void handle(KeyEvent event) {

    }
}
