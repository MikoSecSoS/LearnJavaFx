package fx.com;

import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class Main {

    public static void main(String[] args) {
//        ObservableList<String> list = FXCollections.observableList();
//
//        list.add("Miko");
//        list.add("Code");
//        list.add("AI");
//        list.add("Cute");
//        list.add("qwq");
//
//        FXCollections.rotate(list, 2);
//
//        list.forEach(System.out::println);

        SimpleStringProperty simpleStringProperty = new SimpleStringProperty("Miko");
        SimpleStringProperty simpleStringProperty1 = new SimpleStringProperty("Code");

        ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println("[call] " + param);

//                Observable[] observables = new Observable[] {param};
                Observable[] observables = new Observable[] {new SimpleStringProperty("qwq")};

                return observables;
            }
        });

        list.addListener(new ListChangeListener<SimpleStringProperty>() {
            @Override
            public void onChanged(Change<? extends SimpleStringProperty> c) {

                while (c.next()) {
                    System.out.println("[onChanged] " + c + " [wasUpdated] " + c.wasUpdated());
                }

            }
        });

//        list.add(simpleStringProperty);

//        simpleStringProperty.set("Miko~~~");

//        list.add(simpleStringProperty);

//        list.forEach(System.out::println);

//        System.out.println(list.get(0).get());

        SimpleStringProperty simpleStringProperty2 = new SimpleStringProperty("AI");

        ObservableList<SimpleStringProperty> list1 = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println("[call] " + param);

                Observable[] observables = new Observable[] {param};

                return observables;
            }
        });

        SimpleListProperty<SimpleStringProperty> simpleListProperty = new SimpleListProperty<SimpleStringProperty>(list1);

        simpleListProperty.addListener(new ListChangeListener<SimpleStringProperty>() {
            @Override
            public void onChanged(Change<? extends SimpleStringProperty> c) {

                while (c.next()) {
                    System.out.println("[onChanged] " + c + " [wasUpdated] " + c.wasUpdated());
                }

            }
        });

        simpleListProperty.add(simpleStringProperty2);

        simpleStringProperty2.set("Cute");

    }

}
