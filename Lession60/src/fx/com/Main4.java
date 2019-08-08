package fx.com;

import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

public class Main4 {

    public static void main(String[] args) {

        ObservableSet<String> observableSet = FXCollections.observableSet("Miko", "AI");
        SimpleSetProperty<String> simpleSetProperty = new SimpleSetProperty<String>(observableSet);

        ObservableSet<String> observableSet1 = FXCollections.observableSet("Code", "Cute");
        SimpleSetProperty<String> simpleSetProperty1 = new SimpleSetProperty<String>(observableSet1);

        System.out.println("simpleSetProperty = " + simpleSetProperty.getValue() + " | " + "simpleSetProperty1 = " + simpleSetProperty1.getValue());

        simpleSetProperty.bindContentBidirectional(simpleSetProperty1);

        System.out.println("simpleSetProperty = " + simpleSetProperty.getValue() + " | " + "simpleSetProperty1 = " + simpleSetProperty1.getValue());

        simpleSetProperty.add("qwq");
        simpleSetProperty1.add("qaq");

        System.out.println("simpleSetProperty = " + simpleSetProperty.getValue() + " | " + "simpleSetProperty1 = " + simpleSetProperty1.getValue());

        System.out.println("observableSet = " + observableSet + " | " + "observableSet1" + observableSet1);

        System.out.println("==========================================");

        ObservableMap<String, String> observableMap = FXCollections.observableHashMap();
        SimpleMapProperty<String, String> simpleMapProperty = new SimpleMapProperty<String, String>(observableMap);

        simpleMapProperty.put("Miko", "Cute");
        simpleMapProperty.put("Code", "Cute");

        ObservableMap<String, String> observableMap1 = FXCollections.observableHashMap();
        SimpleMapProperty<String, String> simpleMapProperty1 = new SimpleMapProperty<String, String>(observableMap1);

        simpleMapProperty1.put("AI", "Miko");
        simpleMapProperty1.put("AI", "Code");

        System.out.println("simpleMapProperty = " + simpleMapProperty.getValue() + " | " + "simpleMapProperty1 = " + simpleMapProperty1.getValue());

        simpleMapProperty.bindContentBidirectional(simpleMapProperty1);

        System.out.println("simpleMapProperty = " + simpleMapProperty.getValue() + " | " + "simpleMapProperty1 = " + simpleMapProperty1.getValue());

        simpleMapProperty.put("qwq", "owo");
        simpleMapProperty1.put("QAQ", "quq");

        System.out.println("simpleMapProperty = " + simpleMapProperty.getValue() + " | " + "simpleMapProperty1 = " + simpleMapProperty1.getValue());

        System.out.println("observableMap1 = " + observableMap + " | " + "observableMap1 = " + observableMap1);

    }

}
