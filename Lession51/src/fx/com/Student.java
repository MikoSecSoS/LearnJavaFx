package fx.com;

import java.beans.PropertyChangeSupport;

public class Student {
    private String name;
    private int age;

    public PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;

        this.name = name;

        propertyChangeSupport.firePropertyChange("setName_Pro", oldValue, this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldValue = this.age;

        this.age = age;

        propertyChangeSupport.firePropertyChange("setAge_Pro", oldValue, this.age);
    }
}
