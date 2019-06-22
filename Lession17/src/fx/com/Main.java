package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button0 = new Button("Miko AI - ID-000");
        Button button1 = new Button("AI - ID-001");
        Button button2 = new Button("AI - ID-002");
        Button button3 = new Button("AI - ID-003");
        Button button4 = new Button("AI - ID-004");
        Button button5 = new Button("AI - ID-005");
        Button button6 = new Button("AI - ID-006");
        Button button7 = new Button("AI - ID-007");

        FlowPane flowPane = new FlowPane();
        flowPane.setStyle("-fx-background-color: #EAFF22");

        flowPane.setPadding(new Insets(10));
//        flowPane.setMargin(button0, new Insets(10));
        flowPane.setAlignment(Pos.CENTER);

        flowPane.setHgap(10.0);

        flowPane.setVgap(10.0);

        flowPane.setOrientation(Orientation.VERTICAL);


        flowPane.getChildren().addAll(button0, button1, button2, button3, button4, button5, button6, button7);

        Scene scene = new Scene(flowPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
