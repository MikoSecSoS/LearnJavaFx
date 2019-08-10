package fx.com;

import javafx.beans.property.SimpleStringProperty;

public class Name {

    private SimpleStringProperty name = new SimpleStringProperty();

//    public String getName() {
//        return name.get();
//    }

    public SimpleStringProperty nameProperty() {
        System.out.println("[nameProperty()]");
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

}
