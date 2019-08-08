package fx.com;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main2 {

    public static void main(String[] args) {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        SimpleListProperty<String> listProperty = new SimpleListProperty<String>(observableList);
        listProperty.add("Miko");
        listProperty.add("Code");


        ObservableList<String> observableList1 = FXCollections.observableArrayList();
        SimpleListProperty<String> listProperty1 = new SimpleListProperty<String>(observableList1);
        listProperty1.add("AI");
        listProperty1.add("Cute");


        System.out.println("listProperty = " + listProperty.getValue() + " | " + "listProperty1 = " + listProperty1.getValue());


        listProperty.bindContent(listProperty1);


        System.out.println("listProperty = " + listProperty.getValue() + " | " + "listProperty1 = " + listProperty1.getValue());

        listProperty.add("qwq");

        listProperty1.add("owo");

        System.out.println("listProperty = " + listProperty.getValue() + " | " + "listProperty1 = " + listProperty1.getValue());

        System.out.println("observableList = " + observableList + " | " + "observableList1 = " + observableList1);

        System.out.println("====================sort====================");

        listProperty.sort((item, item1) -> item1.compareTo(item));

        System.out.println("listProperty = " + listProperty.getValue() + " | " + "listProperty1 = " + listProperty1.getValue());

        System.out.println("observableList = " + observableList + " | " + "observableList1 = " + observableList1);

    }

}
