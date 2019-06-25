package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Show Window");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        AnchorPane.setTopAnchor(button, 100.0);
        AnchorPane.setLeftAnchor(button, 100.0);

        anchorPane.getChildren().add(button);

//        button.setOnAction(action -> System.out.println("[button] OnAction"));

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogPane dialogPane = new DialogPane();

                dialogPane.setHeaderText("HeaderText");

                dialogPane.setContentText("ContentText");

                dialogPane.getButtonTypes().add(ButtonType.APPLY);
                dialogPane.getButtonTypes().add(ButtonType.CLOSE);

                Button apply = (Button)dialogPane.lookupButton(ButtonType.APPLY);
                Button close = (Button)dialogPane.lookupButton(ButtonType.CLOSE);

//                ImageView imageView = new ImageView("img/bg.jpg");
                ImageView imageView = new ImageView(new Image("img/favicon.ico"));

                dialogPane.setGraphic(imageView);

//                dialogPane.setGraphic(new Button("Cute!"));

                dialogPane.setExpandableContent(new Text("This is Expandable Content"));

//                dialogPane.setExpanded(true); // 默认是否展开拓展内容

                Stage stage = new Stage();

                Scene scene = new Scene(dialogPane);

                stage.setScene(scene);

                stage.initOwner(primaryStage);

                stage.initStyle(StageStyle.UTILITY);
                stage.initModality(Modality.WINDOW_MODAL); // 模态化窗口

                stage.setTitle("This is a alert window");
                stage.setAlwaysOnTop(true); // 总是在最上方
                stage.setResizable(false); // 禁止拉伸

                stage.show();

                apply.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("[apply]");
                    }
                });

                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("[close]");
                    }
                });
            }
        });

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
