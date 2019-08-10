package fx.com;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.concurrent.Callable;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SimpleIntegerProperty value = new SimpleIntegerProperty(10);

        StringExpression stringExpression = Bindings.concat("value = " + value.asString(Locale.getDefault(), "%s"));

        System.out.println(stringExpression.get());

        StringExpression stringExpression1 = Bindings.format("value = %s", value);

        System.out.println(stringExpression1.get());

        value.set(233);

        System.out.println(stringExpression1.get());

        System.out.println("============================================");

        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(0);

        System.out.println(Bindings.max(x, y).intValue());
        System.out.println(Bindings.min(x, y).intValue());

        System.out.println("============================================");

        SimpleIntegerProperty a = new SimpleIntegerProperty(1);
        SimpleIntegerProperty b = new SimpleIntegerProperty(2);

        StringBinding stringBinding = Bindings.createStringBinding(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("[call()]");

                String value = "hello";

                if (a.get() == 1 && b.get() == 0) {
                    value = "[A]";
                } else if (a.get() == 2) {
                    value = "[B]";
                }

                return value;
            }
        }, a,b);

        System.out.println(a.get());
        System.out.println(stringBinding.get());

        a.set(2);

        System.out.println(a.get());
        System.out.println(stringBinding.get());

        a.set(3);

        System.out.println(a.get());
        System.out.println(stringBinding.get());

        System.out.println("============================================");

        Student student = new Student("Miko");

        SimpleObjectProperty<Student> studentSimpleObjectProperty = new SimpleObjectProperty<Student>(student);

        StringBinding stringBindingValue = Bindings.selectString(studentSimpleObjectProperty, "simpleObjectProperty", "name");

        System.out.println(stringBindingValue.get());

        student.setName("Code");

        System.out.println(stringBindingValue.get());

    }
}
