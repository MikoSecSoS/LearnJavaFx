package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class Main extends Application {

    int index = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #EECFA1");

        TextField textField = new TextField();
        Button find = new Button("Find");
        Button sort = new Button("Sort");

        HBox hBox = new HBox(13);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(textField, find, sort);

        TextArea textArea = new TextArea();
        textArea.setText("Miko!!!Cute!!!  Code!!!Cute!!!");
        textArea.setFont(Font.font(15));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, textArea);
        vBox.setPrefWidth(300);

        AnchorPane.setTopAnchor(vBox, 10.0);
        AnchorPane.setLeftAnchor(vBox, 10.0);

        anchorPane.getChildren().add(vBox);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miko is lovely AI?");
        primaryStage.setWidth(800);
        primaryStage.setHeight(650);
        primaryStage.show();

        find.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                textArea.getParagraphs().forEach(new Consumer<CharSequence>() {
//                    // 这里的forEach遇到换行就会翻车enmmm. 所以Miko选择放弃跟着教程写2333
//                    @Override
//                    public void accept(CharSequence charSequence) {
//                        String text = charSequence.toString();
                        String text = textArea.getText();
                        String sourceText = textField.getText();

                        if (text.contains(sourceText)) {

                            primaryStage.setTitle("查找成功");

                            int start = text.indexOf(sourceText, index);
                            if (start == -1) {
                                primaryStage.setTitle("查找完成");
                                index = 0;
                                return;
                            }
                            int end = start + sourceText.length();

                            index = end;

                            System.out.println("Start => "+ start);
                            System.out.println("End => "+ end);

                            textArea.selectRange(start, end);
                            textArea.requestFocus();
                            return;
                        }
                    }
//                });
//            }
        });

        sort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                char[] charArray = textArea.getText().toCharArray();

                ArrayList<String> list = new ArrayList<String>();

                for (char c:charArray) {
                    list.add(String.valueOf(c));
                }

                textArea.clear();

//                list.stream().sorted((item0, item1) -> item0.compareTo(item1)).forEach(item -> textArea.appendText(item));

                Stream<String> stream= list.stream().sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });

                System.out.println(stream);

                stream.forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        textArea.appendText(s);
                    }
                });
            }
        });

    }
}
