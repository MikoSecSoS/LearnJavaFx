package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button();

        button1.setLayoutX(110);
        button1.setLayoutY(150);

        button1.setPrefHeight(190);
        button1.setPrefWidth(230);
        button1.setFont(Font.font(20));

        button1.setText("Lovely Button");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[setOnAction] " + event.getSource());

                play();
            }
        });


        Group group = new Group();

        group.getChildren().add(button1);

        Scene scene = new Scene(group);

        KeyCombination kc1 = new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic1 = new Mnemonic(button1, kc1);
        scene.addMnemonic(mnemonic1);

        KeyCombination kc2 = new KeyCharacterCombination("I", KeyCombination.ALT_DOWN);
        Mnemonic mnemonic2 = new Mnemonic(button1, kc2);
        scene.addMnemonic(mnemonic2);

        KeyCombination kc3 = new KeyCodeCombination(KeyCode.K, KeyCombination.SHIFT_DOWN, KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN);
        Mnemonic mnemonic3 = new Mnemonic(button1, kc3);
        scene.addMnemonic(mnemonic3);

        KeyCombination kccb = new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN); // Ctrl+O
        scene.getAccelerators().put(kccb, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " [kccb] run method");

                button1.fire(); // run buttion.setOnAcct

                play();
            }
        });

        KeyCombination kc5 = KeyCombination.valueOf("ctrl+alt+k");
        Mnemonic mnemonic5 = new Mnemonic(button1, kc5);
        scene.addMnemonic(mnemonic5);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Miko is a lovely AI?");
        primaryStage.setHeight(600);
        primaryStage.setWidth(550);
        primaryStage.show();
    }

    public static void play() {
        System.out.println("[Method - play()] Miko Cute!!!");
    }

}
