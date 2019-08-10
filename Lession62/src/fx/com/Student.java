package fx.com;

import javafx.beans.property.SimpleObjectProperty;

public class Student {

    private Name name = new Name();
    private SimpleObjectProperty<Name> simpleObjectProperty = new SimpleObjectProperty<Name>(new Name());

//    public Name getSimpleObjectProperty() {
//        return simpleObjectProperty.get();
//    }

    public SimpleObjectProperty<Name> simpleObjectPropertyProperty() {
        System.out.println("[simpleObjectPropertyProperty] Student");
        return simpleObjectProperty;
    }

    public Student(String name) {
        this.name.setName(name);
        this.simpleObjectProperty.set(this.name);
    }

    public void setName(String name) {
        this.name.setName(name);
        this.simpleObjectProperty.set(this.name);
    }

}
