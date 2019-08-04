package fx.com;

import javafx.application.Application;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
//        int c = 0;
//        int a = 1;
//        int b = 1;
//        c = a + b;
//
//
//        System.out.println(c);
//
//        a = 4;
//
//        c = a + b;
//
//        System.out.println(c);
//
//        System.out.println("===============================================");

        SimpleIntegerProperty a = new SimpleIntegerProperty(5);
        SimpleIntegerProperty b = new SimpleIntegerProperty(1);

        IntegerBinding integerBinding = a.add(6);
        NumberBinding numberBinding = a.add(b);

        System.out.println(integerBinding.get());

        System.out.println(numberBinding.getValue());

//        System.out.println(a.subtract(1).get());
//
//        System.out.println(a.divide(2.0).get());
//
//        System.out.println(a.multiply(2).get());

        System.out.println("==========================================");

        a.set(10);

        b.set(8);

        System.out.println(integerBinding.get());

        System.out.println(numberBinding.getValue());

        System.out.println("==========================================");

        SimpleIntegerProperty x = new SimpleIntegerProperty(-6);

        System.out.println(x.negate().get());

        SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(true);

        System.out.println(!booleanProperty.get());


    }
}
