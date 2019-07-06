package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        TabPane tabPane = new TabPane();

        Background background = new Background(new BackgroundFill(Paint.valueOf("#FF00FF"), new CornerRadii(10), new Insets(20)));
        tabPane.setBackground(background);

        Border border = new Border(new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5)));

        tabPane.setBorder(border);

//        tabPane.setStyle("-fx-background-color: #3F7AB4");
        tabPane.setPrefWidth(300);
        tabPane.setPrefHeight(300);

        Tab tab0 = new Tab("[tab - 00]");
        Tab tab1 = new Tab("[tab - 01]");
        Tab tab2 = new Tab("[tab - 02]");

        HBox hBox = new HBox(20);
        hBox.setStyle("-fx-background-color: #FF69B4");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Button("Lovely Button - 00"), new Button("Lovely Button - 01"));

        tab0.setContent(hBox);

        VBox vBox = new VBox(20);
        hBox.setStyle("-fx-background-color: #B9D3EE");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(new Button("Lovely Button - 00"), new Button("Lovely Button - 01"));

        tab1.setContent(vBox);

        tabPane.getTabs().addAll(tab0, tab1, tab2);


        ImageView imageView = new ImageView("img/favicon.ico");
        imageView.setFitWidth(22);
        imageView.setFitHeight(22);

        tab0.setGraphic(imageView);

//        tab0.setClosable(false);

        tabPane.setRotateGraphic(false);

//        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // tab全部不可关闭

//        tab2.setDisable(true);

        tabPane.setSide(Side.RIGHT);

//        tabPane.getSelectionModel().select(tab1);


        AnchorPane.setTopAnchor(tabPane, 100.0);
        AnchorPane.setLeftAnchor(tabPane, 100.0);

        anchorPane.getChildren().addAll(tabPane);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                System.out.println(newValue.getText());
            }
        });

        tab0.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab tab = (Tab)event.getSource();
                System.out.println(tab.getText() + " " + (tab.isSelected() == true ? "selected" : "not select"));
            }
        });

        anchorPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tabPane.getTabs().add(new Tab("[qwq]"));
            }
        });

        tab0.setOnCloseRequest(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab tab = (Tab)event.getSource();
                System.out.println(tab.getText() + " " + "closedRequest");

                event.consume();
            }
        });

        tab0.setOnClosed(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Tab tab = (Tab)event.getSource();
                System.out.println(tab.getText() + " " + "closed");
            }
        });
    }
}
