package fx.com;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

    public static void main(String[] args) {
        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(10);

        MyIntegerBinding myIntegerBinding = new MyIntegerBinding(10);

        System.out.println(myIntegerBinding.get());

        simpleIntegerProperty.bind(myIntegerBinding);

        System.out.println("[myIntegerBinding] " + myIntegerBinding.get());
        System.out.println("[simpleIntegerProperty] " + simpleIntegerProperty.get());

        myIntegerBinding.setX(233);

        System.out.println("[myIntegerBinding] " + myIntegerBinding.get());
        System.out.println("[simpleIntegerProperty] " + simpleIntegerProperty.get());



    }

}

class MyIntegerBinding extends IntegerBinding {

    private SimpleIntegerProperty x = new SimpleIntegerProperty(10);

    public MyIntegerBinding(int value) {
        this.bind(x);
        this.x.set(value);
    }

    public void setX(int x) {
        this.x.set(x);
    }

    @Override
    protected int computeValue() {
        int b = x.get() * 2;

        return b;
    }
}
