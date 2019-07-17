package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        Student student0 = new Student("Miko", 16, 0);
        Student student1 = new Student("Code", 16, 100);
        Student student2 = new Student("Cute", 14, 90);
        Student student3 = new Student("AI", 3, 999.999);

        Button button = new Button("[Lovely Button]");

        ComboBox<Student> comboBox = new ComboBox<Student>();
        comboBox.getItems().addAll(student0, student1, student2, student3);

        comboBox.setEditable(true);
//        comboBox.setPromptText("Input love miko.");

        comboBox.setValue(student0);

//        comboBox.setPlaceholder(new Button("[Cute]"));

//        comboBox.setVisibleRowCount(2);

        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                if (comboBox.getItems().contains(object) == false) {
                    comboBox.getItems().add(object);
                }
                return value;
            }

            @Override
            public Student fromString(String string) {

                if (string.equals("")) {
                    return null;
                }

                Student student = new Student(string, 233, 233);
//                comboBox.getItems().add(student);
                return student;
            }
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 10.0);

        anchorPane.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        comboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("[selectedItemProperty] Number:" + newValue.intValue());
            }
        });

        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                System.out.println("[selectedItemProperty] Name: " + newValue.getName());
            }
        });

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("[setOnAction] " + event.getSource());
            }
        });
    }
}
