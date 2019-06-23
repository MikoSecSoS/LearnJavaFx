import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button0 = new Button("Lovely Button-00");
        Button button1 = new Button("Lovely Button-01");
        Button button2 = new Button("Lovely Button-02");
        Button button3 = new Button("Lovely Button-03");
        Button button4 = new Button("Lovely Button-04");
        Button button5 = new Button("Lovely Button-05");
        Button button6 = new Button("Lovely Button-06");
        Button button7 = new Button("Lovely Button-07");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #EE6AA7");

        gridPane.add(button0, 0, 0);
        gridPane.add(button1, 1, 0);
        gridPane.add(button2, 2, 0);
        gridPane.add(button3, 3, 0);
        gridPane.add(button4, 0, 1);
        gridPane.add(button5, 1, 1);
        gridPane.add(button6, 2, 1);
        gridPane.add(button7, 3, 1);

//        gridPane.setHgap(10);
//        gridPane.setVgap(10);

//        gridPane.setPadding(new Insets(10));

//        gridPane.setMargin(button0, new Insets(10));
//
//        gridPane.setAlignment(Pos.CENTER);

//        gridPane.setConstraints(button0, 1, 1);
//        gridPane.getChildren().addAll(button0);

//        gridPane.setRowIndex(button0, 0);
//        gridPane.setColumnIndex(button0, 1);
//        gridPane.getChildren().add(button0);

        gridPane.getColumnConstraints().add(new ColumnConstraints(150)); // 设置第一列间距

        gridPane.getRowConstraints().add(new RowConstraints(50)); // 设置第一行间距

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
