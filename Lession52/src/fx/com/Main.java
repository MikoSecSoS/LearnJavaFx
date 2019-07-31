package fx.com;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(5);
//
//        simpleIntegerProperty.addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println("[OldValue] " + oldValue);
//                System.out.println("[NewValue] " + newValue);
//            }
//        });
//
//
//        System.out.println(simpleIntegerProperty.get());
//
//        simpleIntegerProperty.set(233);
//
//        System.out.println(simpleIntegerProperty.get());

//        ReadOnlyDoubleWrapper readOnlyDoubleWrapper = new ReadOnlyDoubleWrapper(333);
//        ReadOnlyDoubleProperty readOnlyDoubleProperty = readOnlyDoubleWrapper.getReadOnlyProperty();
//
//        System.out.println(readOnlyDoubleWrapper.get());
//
//        readOnlyDoubleWrapper.set(100);
//
//        System.out.println(readOnlyDoubleWrapper.get());

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #0FFFFF");

        Data2 data2 = new Data2("Code");

        data2.nameProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("[OldValue] " + oldValue);
                System.out.println("[NewValue] " + newValue);
            }
        });

        Data data = new Data("Miko", 16);

        data.nameProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(observable.toString());

                SimpleStringProperty name = (SimpleStringProperty)observable;

                System.out.println(name.getName());

                System.out.println("[OldValue] " + oldValue);
                System.out.println("[NewValue] " + newValue);
            }
        });

        Button button = new Button("EditData");

        anchorPane.getChildren().addAll(button);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                data2.setName("Code~");
            }
        });
    }
}

class Data {
    private SimpleIntegerProperty age = new SimpleIntegerProperty(this, "qwq");
    private SimpleStringProperty name = new SimpleStringProperty(this, "owo");

    public Data(String name, int age) {
        this.name.set(name);
        this.age.set(age);
    }


    public SimpleIntegerProperty getSimpleIntegerPropertyAge() {
        return age;
    }


    public SimpleStringProperty getSimpleStringPropertyName() {
        return name;
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return "biu~~";
    }
}

class Data2 {
    private String name;

    private SimpleStringProperty namePro = null;

    public Data2(String name) {
        if (namePro == null) {
            this.name = name;
        } else {
            this.namePro.set(name);
        }
    }

    public StringProperty nameProperty() {
        if (namePro == null) {
            namePro = new SimpleStringProperty(this, "owo", name);
        }
        return namePro;
    }

    public String getName() {
        if (namePro == null) {
            return name;
        } else {
            return this.namePro.get();
        }
    }

    public void setName(String name) {
        if (namePro == null) {
            this.name = name;
        } else {
            this.namePro.set(name);
        }
    }
}
