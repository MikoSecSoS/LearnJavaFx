package fx.com;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class Main1 {

    public static void main(String[] args) {
        SimpleStringProperty simpleStringProperty = new SimpleStringProperty("Miko");
        SimpleStringProperty simpleStringProperty1 = new SimpleStringProperty("Code");

        ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList(new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println("[call] " + param);

                Observable[] observables = new Observable[] {param};

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

        ObservableList<SimpleStringProperty> list1 = FXCollections.observableList(list, new Callback<SimpleStringProperty, Observable[]>() {
            @Override
            public Observable[] call(SimpleStringProperty param) {
                System.out.println("[call1] " + param);

                Observable[] observables = new Observable[] {param};

                return observables;
            }
        });

        list.addListener(new ListChangeListener<SimpleStringProperty>() {
            @Override
            public void onChanged(Change<? extends SimpleStringProperty> c) {

                while (c.next()) {
                    System.out.println("[onChanged1] " + c + " [wasUpdated1] " + c.wasUpdated());
                }

            }
        });

        list.add(simpleStringProperty);
        list1.add(simpleStringProperty);

        list.forEach(item -> System.out.println("[list] " + item.get()));
        list1.forEach(item -> System.out.println("[list1] " + item.get()));

        simpleStringProperty.set("AI");

        list.forEach(item -> System.out.println("[list] " + item.get()));
        list1.forEach(item -> System.out.println("[list1] " + item.get()));

    }

}
