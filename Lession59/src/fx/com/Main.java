package fx.com;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        int c = a > b ? a * 10 : b * 10;

        System.out.println(c);

        a = 3;

        System.out.println(c);

        System.out.println("=====================================");

        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(2);
        SimpleBooleanProperty sbp = new SimpleBooleanProperty(true);

//        When when = new When(sbp);
        When when = new When(x.greaterThan(y)); // x > b

        NumberBinding n = when.then(10).otherwise(20);

        System.out.println(n.doubleValue());

        x.set(3);

        System.out.println(n.doubleValue());

        System.out.println(new When(x.greaterThan(y)).then("Miko").otherwise("Code").get());

        SimpleIntegerProperty sip1 = new SimpleIntegerProperty(10);
        SimpleIntegerProperty sip2 = new SimpleIntegerProperty(20);

        NumberBinding numberBinding = new When(x.greaterThan(y)).then(sip1).otherwise(sip2);

        System.out.println(numberBinding.doubleValue());

        sip1.set(100);

        System.out.println(numberBinding.doubleValue());

    }

}
