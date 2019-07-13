package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main extends Application implements EventHandler<ActionEvent> {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        ButtonBar buttonBar = new ButtonBar();

        Button button0 = new Button("[Lovely Button] - 00");
        Button button1 = new Button("[Lovely Button] - 01");
        Button button2 = new Button("[Lovely Button] - 02");

        button0.setPrefWidth(100);

        buttonBar.setButtonData(button0, ButtonBar.ButtonData.APPLY);
        buttonBar.setButtonData(button1, ButtonBar.ButtonData.FINISH);
        buttonBar.setButtonData(button2, ButtonBar.ButtonData.NO);

        buttonBar.getButtons().addAll(button0, button1, button2);

        buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_LINUX);

        buttonBar.setButtonUniformSize(button0, true); // buttonBar里面的Button统一尺寸

        anchorPane.getChildren().add(buttonBar);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        button0.setOnAction(this);
        button1.setOnAction(this);
        button2.setOnAction(this);

    }
    @Override
    public void handle(ActionEvent event) {
        Button button = (Button)event.getSource();

        if (ButtonBar.getButtonData(button) == ButtonBar.ButtonData.APPLY) {
            System.out.println("[APPLY] => " + button.getText());
        } else if (ButtonBar.getButtonData(button) == ButtonBar.ButtonData.FINISH) {
            System.out.println("[FINISH] => " + button.getText());
        } else if (ButtonBar.getButtonData(button) == ButtonBar.ButtonData.NO) {
            System.out.println("[NO] => " + button.getText());
        }
    }
}
