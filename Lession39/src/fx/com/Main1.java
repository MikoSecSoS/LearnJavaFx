package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodRequests;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.util.function.Predicate;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        Student student0 = new Student("Miko", 16, 0);
        Student student1 = new Student("Code", 16, 100);
        Student student2 = new Student("Cute", 14, 90);
        Student student3 = new Student("AI", 3, 999.999);

        ComboBox<Student> comboBox = new ComboBox<Student>();
        comboBox.setPrefWidth(150);
        comboBox.getItems().addAll(student0, student1, student2, student3);

        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object != null) {
                    String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                    return value;
                }
                return "";
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        comboBox.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                ListCell<Student> listCell = new ListCell<Student>() {
                    @Override
                    protected void updateItem(Student item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            return;
                        }
//                        this.setGraphic(new Label(item.getName()));
//                        String value = comboBox.getConverter().toString(item);
//                        this.setText(value);

                        Button button = new Button("[Cute]");

                        HBox hBox = new HBox(5);
                        hBox.setStyle("-fx-background-color: #B0E0E6");
//                        hBox.setAlignment(Pos.CENTER_LEFT);
                        hBox.setPadding(new Insets(0, 0, 0, 10));

                        Label name = new Label(item.getName());
                        name.setStyle("-fx-background-color: green");
                        name.setFont(Font.font(14));

                        Label age = new Label(String.valueOf(item.getAge()));
                        age.setFont(Font.font(14));

                        Label score = new Label(String.valueOf(item.getScore()));
                        score.setFont(Font.font(14));

                        hBox.getChildren().addAll(button, name, age, score);

                        this.setGraphic(hBox);
                    }
                };
                return listCell;
            }
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 10.0);

        anchorPane.getChildren().addAll(comboBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

    }
}
