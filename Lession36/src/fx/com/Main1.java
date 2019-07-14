package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ChoiceBox<Student> choiceBox = new ChoiceBox<Student>();
        choiceBox.getItems().addAll(student0, student1, student2, student3);

        choiceBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                String value = object.getName() + " - " + object.getAge() + " - " + object.getScore();
                return value;
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        choiceBox.setPrefWidth(200);

        AnchorPane.setTopAnchor(choiceBox, 100.0);
        AnchorPane.setLeftAnchor(choiceBox, 10.0);

        anchorPane.getChildren().addAll(choiceBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                System.out.println("[Name] " + newValue.getName());
                System.out.println("[Age] " + newValue.getAge());
                System.out.println("[Score] " + newValue.getScore());
            }
        });

    }
}

class Student {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}