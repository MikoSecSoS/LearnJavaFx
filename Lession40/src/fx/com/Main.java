package fx.com;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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

        TextField nameTF = new TextField();

        Button modifyNameBut = new Button("Modify Name");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ChoiceBox<Student> choiceBox = new ChoiceBox<Student>();
        choiceBox.getItems().addAll(student0, student1, student2, student3);

        choiceBox.getSelectionModel().select(1);

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

        AnchorPane.setTopAnchor(nameTF, 50.0);
        AnchorPane.setLeftAnchor(nameTF, 10.0);

        AnchorPane.setTopAnchor(modifyNameBut, 50.0);
        AnchorPane.setLeftAnchor(modifyNameBut, 200.0);

        anchorPane.getChildren().addAll(choiceBox,  nameTF, modifyNameBut);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
//                System.out.println("[Name] " + newValue.getName());
//                System.out.println("[Age] " + newValue.getAge());
//                System.out.println("[Score] " + newValue.getScore());
            }
        });

        modifyNameBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Student student = choiceBox.getSelectionModel().getSelectedItem();
//
//                int i = choiceBox.getItems().indexOf(student);
//
//                choiceBox.getItems().remove(i);
//
//                student.setName(nameTF.getText());
//
//                choiceBox.getItems().add(i, student);

                choiceBox.getSelectionModel().getSelectedItem().setName(nameTF.getText());

//                choiceBox.getItems().forEach(s -> System.out.println(s.getName()));

            }
        });

        choiceBox.getSelectionModel().getSelectedItem().getNameSimpleStringProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Student student = choiceBox.getSelectionModel().getSelectedItem();

                int i = choiceBox.getItems().indexOf(student);

                choiceBox.getItems().remove(i);

//                student.setName(nameTF.getText());

                choiceBox.getItems().add(i, student);
            }
        });

    }
}

class Student {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();
    private SimpleDoubleProperty score = new SimpleDoubleProperty();

//    private String name;
//    private int age;
//    private double score;

    public Student(String name, int age, double score) {
        this.name.setValue(name);
        this.age.setValue(age);
        this.score.setValue(score);

//        this.name = name;
//        this.age = age;
//        this.score = score;
    }


    public String getName() {
        return name.getValue();
//        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
//        this.name = name;
    }

    public int getAge() {
        return age.getValue();
//        return age;
    }

    public void setAge(int age) {
        this.age.setValue(age);
//        this.age = age;
    }

    public double getScore() {
        return score.getValue();
//        return score;
    }

    public void setScore(double score) {
        this.score.setValue(score);
//        this.score = score;
    }

    public SimpleStringProperty getNameSimpleStringProperty(){
        return name;
    }
}