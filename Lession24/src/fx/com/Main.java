package fx.com;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label l_username = new Label("username:");
        l_username.setFont(Font.font(14));

        Label l_password = new Label("password:");
        l_password.setFont(Font.font(14));

        TextField t_username = new TextField();
        t_username.setTooltip(new Tooltip("Please input username."));

        PasswordField p_password = new PasswordField();
        p_password.setTooltip(new Tooltip("Please input password."));

        t_username.setUserData("Miko");

        p_password.setUserData(233333);

        Button login = new Button("Login");
        Button clear = new Button("Clear");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #EECFA1");

        gridPane.add(l_username, 0, 0);
        gridPane.add(t_username, 1, 0);

        gridPane.add(l_password, 0, 1);
        gridPane.add(p_password, 1, 1);

        gridPane.add(clear, 0, 2);
        gridPane.add(login, 1, 2);

        gridPane.setHgap(5);
        gridPane.setVgap(15);

        gridPane.setMargin(login, new Insets(0,0,0,120));

        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        primaryStage.show();

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t_username.setText("");
                p_password.setText("");
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                t_username.getProperties().put("miko", "cute");
//
//                System.out.println(t_username.getProperties().get("miko"));

//                t_username.setUserData("qwq");

//                System.out.println(t_username.getUserData());

                String name = (String)t_username.getUserData();
                int pwd = (int)p_password.getUserData();

                if (name.equals(t_username.getText()) && pwd == Integer.valueOf(p_password.getText())) {
                    System.out.println("Cute!!!!");

                    MyWindow myWindow = new MyWindow(name, String.valueOf(Integer.valueOf(p_password.getText())));

                    primaryStage.close();
                } else {
                    System.out.println("Not Cute>_<");

                    l_username.setTextFill(Color.RED);
                    l_password.setTextFill(Color.RED);

                    primaryStage.setTitle("Username or Password error.");

                    FadeTransition fadeTransition = new FadeTransition();

                    fadeTransition.setDuration(Duration.seconds(0.2));
                    fadeTransition.setNode(gridPane);
                    fadeTransition.setFromValue(0);
                    fadeTransition.setToValue(1);

                    fadeTransition.play();
                }
            }
        });
    }
}


class MyWindow {
    private final Stage stage = new Stage();

    public MyWindow(String name, String pwd) {
        Text text = new Text("username: " + name + " " + "password: " + pwd);

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #EEAAFA");
        borderPane.setCenter(text);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Cute~~~");
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }
}