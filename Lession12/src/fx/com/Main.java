package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is a lovely AI?");
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);

        Label label = new Label();
        label.setText("UserName: ");
//        label.setStyle("-fx-background-color:#7CCD7C;");

        label.setLayoutX(30);
        label.setLayoutY(90);

        label.setFont(Font.font(15));

        PasswordField passwordField = new PasswordField();

        passwordField.setLayoutX(120);
        passwordField.setLayoutY(130);

        passwordField.setPrefHeight(40);
        passwordField.setPrefWidth(225);

        TextField textField = new TextField();
//        textField.setText("Lovely Miko");

        textField.setLayoutX(120);
        textField.setLayoutY(80);

//        textField.setPrefHeight(70);
//        textField.setPrefWidth(150);

        textField.setFont(Font.font(19));

        Tooltip tooltip =  new Tooltip();
        tooltip.setText("Please Input \"Miko Cute\".");
        tooltip.setFont(Font.font(25));
        textField.setTooltip(tooltip);

        textField.setPromptText("Input length <10 string.");

        textField.setFocusTraversable(false);

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    textField.setText(oldValue);
                }
            }
        });

        passwordField.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        textField.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("[awsl] 输入框被点击qwq");
                System.out.println("[x] " + event.getX());
                System.out.println("[y] " + event.getY());
            }
        });

        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("[盯~] " + event.getButton().name());

                if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("左键双击: " + event.getButton().name());
                    System.out.println("[x] " + event.getX());
                    System.out.println("[y] " + event.getY());
                } else if (event.getClickCount() > 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("左键多击(>2): " + event.getButton().name());
                    System.out.println("[x] " + event.getX());
                    System.out.println("[y] " + event.getY());
                } else if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.SECONDARY.name())) {
                    System.out.println("右键双击: " + event.getButton().name());
                    System.out.println("[x] " + event.getX());
                    System.out.println("[y] " + event.getY());
                } else if (event.getClickCount() > 2 && event.getButton().name().equals(MouseButton.SECONDARY.name())) {
                    System.out.println("右键多击(>2): " + event.getButton().name());
                    System.out.println("[x] " + event.getX());
                    System.out.println("[y] " + event.getY());
                } if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.MIDDLE.name())) {
                    System.out.println("中键双击: " + event.getButton().name());
                    System.out.println("[x] " + event.getX());
                    System.out.println("[y] " + event.getY());
                } else if (event.getClickCount() > 2 && event.getButton().name().equals(MouseButton.MIDDLE.name())) {
                    System.out.println("中键多击(>2): " + event.getButton().name());
                    System.out.println("[x] " + event.getX());
                    System.out.println("[y] " + event.getY());
                }
            }
        });

        group.getChildren().add(textField);
        group.getChildren().add(passwordField);
        group.getChildren().add(label);

        primaryStage.show();
    }
}
