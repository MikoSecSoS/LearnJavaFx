package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("[Cute]");

        Student student = new Student("Miko", 16);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        anchorPane.getChildren().addAll(button);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        student.propertyChangeSupport.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("[OldValue] " + evt.getOldValue());
                System.out.println("[NewValue] " + evt.getNewValue());
            }
        });

        student.propertyChangeSupport.addPropertyChangeListener("setName_Pro", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("[Name OldValue] " + evt.getOldValue());
                System.out.println("[Name NewValue] " + evt.getNewValue());

//                Student student1 = (Student) evt.getSource();
//
//                System.out.println(student1.getName());

            }
        });

        student.propertyChangeSupport.addPropertyChangeListener("setAge_Pro", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("[Age OldValue] " + evt.getOldValue());
                System.out.println("[Age NewValue] " + evt.getNewValue());
            }
        });

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                student.setName("Code");
                student.setAge(15);
            }
        });
    }
}
