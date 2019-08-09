package fx.com;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Main {
    public static void main(String[] args)  {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        SimpleListProperty<String> listProperty = new SimpleListProperty<String>(observableList);
        listProperty.add("Miko");
        listProperty.add("Code");
        listProperty.add("Cute");

        int i = 0;

        ObjectBinding<String> objectBinding = listProperty.valueAt(0);
        System.out.println(objectBinding.get());

        listProperty.set(0, "okiM");

        i = 2;

        objectBinding = listProperty.valueAt(i);

        System.out.println(objectBinding.get());

        System.out.println("===============================================");

        SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(2);
        ObjectBinding<String> objectBinding1 = listProperty.valueAt(integerProperty);

        System.out.println(objectBinding1.get());

        listProperty.set(2, "AI");

        System.out.println(objectBinding1.get());

        integerProperty.set(1);

        System.out.println(objectBinding1.get());

        System.out.println("==============================================");


        ObservableMap<String, String> observableMap = FXCollections.observableHashMap();
        SimpleMapProperty<String, String> simpleMapProperty = new SimpleMapProperty<String, String>(observableMap);

        simpleMapProperty.put("Miko", "Cute");
        simpleMapProperty.put("Code", "Cute");

        ObjectBinding<String> objectBinding2 = simpleMapProperty.valueAt("Code");

        System.out.println(objectBinding2.get());

        simpleMapProperty.put("Code", "LoveMiko");

        System.out.println(objectBinding2.get());

    }
}
