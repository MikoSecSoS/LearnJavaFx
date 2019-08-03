package fx.com;

import javafx.beans.property.SimpleIntegerProperty;

public class Main {
    public static void main(String[] args) {
        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(5);

        x.bind(y);

//        x.set(8);

        y.set(10);

        System.out.println(x.isBound());
        System.out.println(y.isBound());

        System.out.println(x.get());
        System.out.println(y.get());

        x.unbind();

        y.set(100);

        System.out.println(x.isBound());
        System.out.println(y.isBound());

        System.out.println(x.get());
        System.out.println(y.get());


        System.out.println("=================================");


        SimpleIntegerProperty a = new SimpleIntegerProperty(233);
        SimpleIntegerProperty b = new SimpleIntegerProperty(2334);

        a.bindBidirectional(b);

        a.set(23333);

        System.out.println(a.isBound());
        System.out.println(b.isBound());

        System.out.println(a.get());
        System.out.println(b.get());

        a.unbindBidirectional(b);

        a.set(222);
        b.set(333);

        System.out.println(a.get());
        System.out.println(b.get());
    }
}
