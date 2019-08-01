package fx.com;

import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.*;

import java.util.Iterator;
import java.util.function.BiConsumer;

public class Main2 {
    public static void main(String[] args) {

        ObservableSet<String> observableSet = FXCollections.observableSet("Miko", "Code", "AI");

        SimpleSetProperty<String> simpleSetProperty = new SimpleSetProperty<String>(observableSet);

        simpleSetProperty.addListener(new SetChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> change) {
                System.out.println("[change.wasAdded()] " + change.wasAdded());
            }
        });

        simpleSetProperty.add("Cute");

        Iterator<String> iterator = simpleSetProperty.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        simpleSetProperty.forEach(System.out::println);

        ObservableMap<String,String> observableMap = FXCollections.observableHashMap();

        observableMap.put("Miko", "Cute");
        observableMap.put("AI", "Miko");
        observableMap.put("Code", "Miko");

        SimpleMapProperty<String,String> simpleMapProperty = new SimpleMapProperty<String,String>(observableMap);

        simpleMapProperty.addListener(new MapChangeListener<String, String>() {
            @Override
            public void onChanged(Change<? extends String, ? extends String> change) {
                System.out.println("[simpleMapProperty.addListener] " + change.getKey() + " => " + change.getMap().get(change.getKey()));
            }
        });

        simpleMapProperty.put("QAQ", "qwq");

        simpleMapProperty.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " => " + s2);
            }
        });
    }
}
