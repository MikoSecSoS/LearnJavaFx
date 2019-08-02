package fx.com;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;

public class Main {

    public static void main(String[] args) {
        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(1);

//        simpleIntegerProperty.addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println("更改监听");
//                System.out.println("[oldValue] " + oldValue);
//                System.out.println("[newValue] " + newValue);
//            }
//        });

//        simpleIntegerProperty.addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//                System.out.println("失效监听");
//                System.out.println(observable);
//            }
//        });

        Inva inva = new Inva();
        simpleIntegerProperty.addListener(inva);

        Change change = new Change();

        WeakChangeListener<Number> weakChangeListener = new WeakChangeListener<Number>(change);

        simpleIntegerProperty.addListener(weakChangeListener);

//        simpleIntegerProperty.addListener(change);
//        simpleIntegerProperty.removeListener(change);


        simpleIntegerProperty.set(233);
//        simpleIntegerProperty.get();

        simpleIntegerProperty.set(2334);
//        simpleIntegerProperty.get();

        simpleIntegerProperty.removeListener(inva);

        simpleIntegerProperty.set(2233);
//        simpleIntegerProperty.get();
    }

}

class Inva implements InvalidationListener {

    @Override
    public void invalidated(Observable observable) {
        System.out.println("失效监听");
    }
}

class Change implements ChangeListener {

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        System.out.println("更改监听");
        System.out.println("[oldValue] " + oldValue);
        System.out.println("[newValue] " + newValue);
    }
}