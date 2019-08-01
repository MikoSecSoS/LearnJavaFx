package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.Comparator;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ObservableList<String> list= FXCollections.observableArrayList();

        list.add("Miko");
        list.add("Code");
        list.add("AI");

        SimpleListProperty<String> stringSimpleListProperty = new SimpleListProperty<>(list);

//        stringSimpleListProperty.addListener(new ChangeListener<ObservableList<String>>() {
//            @Override
//            public void changed(ObservableValue<? extends ObservableList<String>> observable, ObservableList<String> oldValue, ObservableList<String> newValue) {
////                newValue.forEach(item -> System.out.println(item));
//
//                oldValue.forEach(System.out::println);
//                System.out.println("==================================");
//                newValue.forEach(System.out::println);
//                System.out.println("==================================");
//            }
//        });

        stringSimpleListProperty.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                System.out.println(c);
//                c.getList().forEach(System.out::println);

                c.reset();

                while (c.next()) {
                    System.out.println("[Start] " + c.getFrom());
                    System.out.println("[End] " + c.getTo());
                    System.out.println("[c.wasAdded()] " + c.wasAdded());
                    System.out.println("[c.wasRemoved()]" + c.wasRemoved());
                    System.out.println("[c.wasReplaced()]" + c.wasReplaced());
                    System.out.println("[c.wasPermutated()]" + c.wasPermutated());
//                    System.out.println("[c.wasUpdated()]" + c.wasUpdated());

                    System.out.println(c.getAddedSubList());
                    System.out.println(c.getRemoved());

                    c.getList().forEach(System.out::println);

                    System.out.println(c.getPermutation(0));

                }
            }
        });

//        stringSimpleListProperty.addAll("qwq", "QAQ");

//        stringSimpleListProperty.remove(0,2);

//        stringSimpleListProperty.add("Cute");

//        stringSimpleListProperty.set(0, "Null");

//        stringSimpleListProperty.remove(0);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o2.compareTo(o1);
                return 0;
            }
        });

        Platform.exit();
    }
}
