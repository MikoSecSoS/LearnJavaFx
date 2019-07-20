package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().addAll("Cute - 00", "Cute - 01", "Cute - 02");

        comboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
//                System.out.println(object);
                return object;
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        });

        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> listCell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!empty) {
                            this.setText(item + " - qwq");
                        }
                    }
                };

                return listCell;
            }
        });

        comboBox.cellFactoryProperty().set(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> listCell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!empty) {
                            this.setText(item + " - QAQ");
                        }
                    }
                };

                return listCell;
            }
        });

//        comboBox.converterProperty().set(new StringConverter<String>() {
//            @Override
//            public String toString(String object) {
//                return null;
//            }
//
//            @Override
//            public String fromString(String string) {
//                return null;
//            }
//        });

        comboBox.setPrefWidth(150);
        AnchorPane.setTopAnchor(comboBox, 100.0);
        AnchorPane.setLeftAnchor(comboBox, 10.0);

        anchorPane.getChildren().addAll(comboBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

    }
}