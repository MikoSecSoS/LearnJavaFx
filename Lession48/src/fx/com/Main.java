package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

//        Student student = new Student("Miko", 16);
//        Student student1 = new Student("Code", -1);
//        Student student2 = new Student("Cute", 16);
//        ObservableList<Student> list = FXCollections.observableArrayList();
//        list.addAll(student, student1, student2);
//
//        Spinner spinner = new Spinner<Student>();
//
//        SpinnerValueFactory.ListSpinnerValueFactory slvf = new SpinnerValueFactory.ListSpinnerValueFactory<Student>(list);
//
//        slvf.setConverter(new StringConverter<Student>() {
//            @Override
//            public String toString(Student object) {
//                if (object != null) {
//                    return object.getName() + " - " + object.getAge();
//                }
//                return "";
//            }
//
//            @Override
//            public Student fromString(String string) {
//                return null;
//            }
//        });
//
//        spinner.setValueFactory(slvf);

//        Spinner spinner = new Spinner<Integer>(0, 10, 5, 2);

//        ObservableList<String> list = FXCollections.observableArrayList();
//        list.addAll("A", "B", "C", "D");
//
//        Spinner spinner1 = new Spinner<String>(list);
//
//        spinner1.getStyleClass().addAll(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);

        Student student = new Student("Miko", 16);
        Student student1 = new Student("Code", -1);
        Student student2 = new Student("Cute", 16);
        ObservableList<Student> list = FXCollections.observableArrayList();
        list.addAll(student, student1, student2);

        Spinner spinner2 = new Spinner<Student>(list);
        spinner2.setEditable(true);

        SVF svf = new SVF(list);

        spinner2.setValueFactory(svf);

        svf.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {

                System.out.println(object.getName() + " - " + object.getAge());

                if (object != null) {
                    return object.getName() + " - " + object.getAge();
                }

                return "";
            }

            @Override
            public Student fromString(String string) {

                Student student3 = new Student(string, 20);

                return student3;
            }
        });

        svf.setValue(student);

//        spinner2.setValueFactory(new SpinnerValueFactory() {
//            @Override
//            public void decrement(int steps) {
//            }
//
//            @Override
//            public void increment(int steps) {
//            }
//        });

        anchorPane.getChildren().addAll(spinner2);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();
    }
}

class SVF extends SpinnerValueFactory<Student> {

    private int index = -1;
    private ObservableList<Student> list;

    public SVF(ObservableList<Student> list) {
        this.list = list;
    }

    @Override
    public void decrement(int steps) {
        System.out.println("[decrement] " + steps);
//        this.getConverter().toString(list.get(steps));

        if (index + steps >= list.size()) {
            index = 0;
        } else {
            index += steps;
        }

        this.setValue(list.get(index));
    }

    @Override
    public void increment(int steps) {
        System.out.println("[increment] " + steps);
//        this.getConverter().toString(list.get(steps));

        if (index - steps <= -1) {
            index = list.size()-1;
        } else {
            index -= steps;
        }

        System.out.println(list.get(index));

        this.setValue(list.get(index));

    }
}