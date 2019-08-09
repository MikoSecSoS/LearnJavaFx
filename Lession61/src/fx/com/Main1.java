package fx.com;

import javafx.application.Application;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        SimpleListProperty<String> listProperty = new SimpleListProperty<String>(observableList);
        listProperty.add("Miko");
        listProperty.add("Code");
        listProperty.add("Cute");
        listProperty.add("AI");
        listProperty.add("qwq");
        listProperty.add("owo");


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        HBox hBox = new HBox(5);

        TextField textField = new TextField();
        TextField textField1 = new TextField();

        hBox.getChildren().addAll(textField, textField1);

        VBox vBox = new VBox();

        VBox listdata = new VBox(10);

        for (int i = 0; i < listProperty.size(); i++) {
            Label label = new Label();
            label.setFont(Font.font(25));

            ObjectBinding<String> objectBinding = listProperty.valueAt(i);

            label.textProperty().bind(objectBinding);

//            label.setText(listProperty.get(i));

            listdata.getChildren().add(label);
        }

        vBox.getChildren().addAll(hBox, listdata);

        anchorPane.getChildren().add(vBox);

        anchorPane.setTopAnchor(vBox, 70.0);
        anchorPane.setLeftAnchor(vBox, 70.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        textField1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (textField.getText().equals("") && textField.getText().matches("[0-9]+")) {
                    return;
                }

                int index = Integer.parseInt(textField.getText());

                String value = textField1.getText();

                listProperty.set(index, value);
            }
        });

    }
}
