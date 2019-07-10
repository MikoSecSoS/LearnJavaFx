package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        HBox hBox = new HBox(15);

        Button selectAllBut = new Button("[Select All]");
        Button copyBut = new Button("[Copy]");
        Button clearBut = new Button("[Clear]");
        Button editableBut = new Button("[Editable] - on");

        TextArea textArea = new TextArea();
        textArea.setText("Miko Cute!!!");
        textArea.setFont(Font.font(20));

//        textArea.setWrapText(true); // 自动换行

        textArea.setPrefWidth(300);
        textArea.setPrefHeight(200);

        textArea.setPrefRowCount(2);
        textArea.setPrefColumnCount(2);

        textArea.appendText("\nCode Cute!!!");

        textArea.deleteText(0, 5);

        textArea.insertText(0, "Miko-");

        textArea.replaceText(13, 18, "Code-");

//        textArea.selectAll();

        System.out.println(textArea.getLength());

//        textArea.selectRange(5, 9);

        textArea.positionCaret(10);

//        textArea.selectHome();

        hBox.getChildren().addAll(textArea, selectAllBut, clearBut, copyBut, editableBut);

        anchorPane.getChildren().add(hBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textArea.setScrollLeft(textArea.getScrollLeft()+15);
            }
        });

        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 40) {
                    textArea.setText(oldValue);
                }
            }
        });

        textArea.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        textArea.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });

        selectAllBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textArea.getSelectedText().isEmpty()) {
                    textArea.selectAll();
                } else {
                    textArea.positionCaret(textArea.getLength());
                }
            }
        });

        clearBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
            }
        });

        copyBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });

        editableBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textArea.isEditable()) {
                    editableBut.setText("[Editable] - off");
                    textArea.setEditable(false);
                } else {
                    editableBut.setText("[Editable] - on");
                    textArea.setEditable(true);
                }
            }
        });
    }
}
