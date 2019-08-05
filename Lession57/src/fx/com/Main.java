package fx.com;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import sun.security.pkcs11.Secmod;

public class Main {

    public static void main(String[] args) {
        SimpleIntegerProperty a = new SimpleIntegerProperty(10);
        SimpleIntegerProperty b = new SimpleIntegerProperty(6);

        DoubleBinding n1 = a.add(10).subtract(10).divide(5.0).multiply(4);
        NumberBinding n2 = a.add(10).subtract(b).divide(5.0).multiply(4);

        System.out.println(n1.get());

        System.out.println(n2.doubleValue());

//        b.set(5);

        System.out.println(n2.getValue());

        System.out.println(a.greaterThan(b).get()); // return a > b

        BooleanBinding booleanBinding = a.greaterThan(b);

//        System.out.println(booleanBinding.get());
//
//        b.set(20);
//
//        System.out.println(booleanBinding.get());

        System.out.println(a.lessThan(b).get());

        System.out.println(a.isEqualTo(b).get());

        System.out.println(a.isNotEqualTo(b).get());

        System.out.println(a.isEqualTo(9, 1).get()); // epsilon 1

        System.out.println(a.isNotEqualTo(8, 1).get());

        System.out.println(a.greaterThanOrEqualTo(b).get()); // a >= b

        System.out.println(a.lessThanOrEqualTo(b).get()); // a <= b



    }

}
