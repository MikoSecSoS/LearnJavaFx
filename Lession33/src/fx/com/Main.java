package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        anchorPane.setStyle("-fx-background-color: #EECFA1");

        VBox vBox = new VBox(15);

        TextField textField = new TextField();

        TextArea textArea = new TextArea();

        textField.setTextFormatter(new TextFormatter<Object>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                System.out.println(change.getText());

                String value = change.getText();

                if (value.matches("[a-z|A-Z|0-9]")) {
                    return change;
                }

                return null;
            }
        }));


        vBox.getChildren().addAll(textField, textArea);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        textField.requestFocus();

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });

        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                textArea.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {
                    @Override
                    public String toString(String object) {
                        System.out.println("[Object] " + object);
                        if (object == null) {
                            return "";
                        }
                        return object;
                    }

                    @Override
                    public String fromString(String string) {
                        System.out.println("[String] " + string);
                        if (string.contains("qwq")) {
                            String value = string.replace("qwq", "帅气!可爱!");
                            return value;
                        } else if (string.contains("qaq") | string.contains("QAQ")) {
                            String value = string.replace("qaq", "去死趴，老阿姨!!!").replace("QAQ", "嗷嗷嗷~去死趴，老阿姨!!!");
                            return value;
                        }
                        return string;
                    }
                }));

                textArea.commitValue();
            }
        });

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                textField.setTextFormatter(new TextFormatter<Integer>(new StringConverter<Integer>() {
                    @Override
                    public String toString(Integer object) {
                        System.out.println("[object] " + String.valueOf(object));
                        return String.valueOf(object);
                    }

                    @Override
                    public Integer fromString(String string) {
                        System.out.println("[String]" + string);
                        return Integer.valueOf(string);
                    }
                }));

                textField.commitValue();
            }
        });
    }
}
