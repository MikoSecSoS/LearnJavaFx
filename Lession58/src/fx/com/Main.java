package fx.com;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("Miko", 16);

        SimpleIntegerProperty a = new SimpleIntegerProperty(5);
        SimpleIntegerProperty b = new SimpleIntegerProperty(student,  "okiM", 5);

        IntegerExpression n = SimpleIntegerProperty.integerExpression(b);

        SimpleIntegerProperty simpleIntegerProperty = (SimpleIntegerProperty)n;

        b.set(6);

        System.out.println(n.get());

        System.out.println(simpleIntegerProperty.getName());

        ObjectProperty<Integer> objectProperty = new SimpleObjectProperty<Integer>(2);

        System.out.println(IntegerExpression.integerExpression(objectProperty).get());

        System.out.println(SimpleIntegerProperty.readOnlyIntegerProperty(b));

        System.out.println("================================================");

        SimpleBooleanProperty sbp = new SimpleBooleanProperty(true);
        SimpleBooleanProperty sbp1 = new SimpleBooleanProperty(false);

        System.out.println(sbp.and(sbp1).get()); // sbp:true && sbp1:false
        System.out.println(sbp.or(sbp1).get()); // sbp:true || sbp1:false
        System.out.println(sbp.not().get()); // !sbp:true
        System.out.println(sbp.isEqualTo(sbp1).get()); // sbp == sbp1

        System.out.println("================================================");

        SimpleStringProperty ssp = new SimpleStringProperty("Miko");
        SimpleStringProperty ssp1 = new SimpleStringProperty("Code");

        System.out.println(ssp.greaterThan(ssp1).get()); // ASCII  ssp > ssp1

        System.out.println(ssp.concat(ssp1).get());

        System.out.println(ssp.isEqualTo(ssp1).get());

        System.out.println(ssp.isEqualToIgnoreCase(ssp1).get());

        System.out.println(ssp.isEmpty().get());

        System.out.println(ssp.isNull().get());

        System.out.println("================================================");

        Student student1 = new Student("Code", 233);
        Student student2 = new Student("Code", 233);

        SimpleObjectProperty<Student> sop = new SimpleObjectProperty<Student>(student1);
        SimpleObjectProperty<Student> sop1 = new SimpleObjectProperty<Student>(student2);

        sop.addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                System.out.println(newValue.getName() + " - " + newValue.getAge());
            }
        });

        sop.set(new Student("Cute", 16));

        student1.setName("qwq");

        sop.get().setAge(17);

        System.out.println(sop.isNull().get());

        System.out.println(sop.isEqualTo(sop1).get());
    }

}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
