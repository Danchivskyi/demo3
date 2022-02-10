package com.example.demo3;

import java.io.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class HelloApplication extends Application {
    BorderPane root = new BorderPane();
    MenuBar mb = new MenuBar();
    VBox top = new VBox();
    VBox center = new VBox();
    TextArea textArea = new TextArea();

    public void createTop(Stage primaryStage) {
        final Stage stage = primaryStage;
        top.setSpacing(20);
        Menu menu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem close = new MenuItem("Close");
        MenuItem exit = new MenuItem("Exit");
        menu.getItems().addAll(open, close, exit);
        exit.setOnAction(actionEvent -> Platform.exit());

        Menu menu2 = new Menu("Edit");
        MenuItem copy = new MenuItem("Copy");
        MenuItem find = new MenuItem("Find");
        MenuItem delete = new MenuItem("Delete");
        menu2.getItems().addAll(copy,find,delete);

        Menu menu3 = new Menu("View");
        MenuItem ToolWindows = new MenuItem("Tool Windows");
        menu3.getItems().addAll(ToolWindows);

        Menu menu4 = new Menu("Help");
        MenuItem FindAction = new MenuItem("Find Action");
        MenuItem about = new MenuItem("About");
        menu4.getItems().addAll(FindAction,about);

        open.setOnAction((ActionEvent e) -> {
            FileChooser fcb = new FileChooser();
            fcb.setTitle("Open Dialog");
            File selectedFile = fcb.showOpenDialog(stage);
            StringBuilder sb = readFile(selectedFile);
            textArea.setText(sb.toString());
        });
        close.setOnAction((ActionEvent e) -> textArea.setText(""));
        exit.setOnAction((ActionEvent e) -> System.exit(0));
        mb.getMenus().addAll(menu,menu2,menu3,menu4);
        top.getChildren().add(mb);
    }

    public void createCenter() {
        /*Pytanie pierwsze*/
        Label question = new Label("Java GUI library ?");
        Label response = new Label();


        Button button = new Button("Submit");
        button.setDisable(true);
        CheckBox cb1, cb2, cb3, cb4;
        cb1 = new CheckBox("Swing");
        cb2 = new CheckBox("AWT");
        cb3 = new CheckBox("JavaFX");
        cb4 = new CheckBox("Servlet");

        cb1.setOnAction(e -> button.setDisable(false));
        cb2.setOnAction(e -> button.setDisable(false));
        cb3.setOnAction(e -> button.setDisable(false));
        cb4.setOnAction(e -> button.setDisable(false));

        button.setOnAction(e -> {
                    if (cb4.isSelected()) {
                        response.setText("Wrong answer");
                        button.setDisable(true);
                    } else if ((cb1.isSelected()) && (cb2.isSelected()) &&
                            (cb3.isSelected())) {
                        response.setText("Correct answer");
                        button.setDisable(true);
                    } else {
                        response.setText("Wrong answer");
                        button.setDisable(true);
                    }
                }
        );

        Label label = new Label("\n");

        /*Pytanie drugie*/
        Label question1 = new Label("Głównym elementem pliku AndroidManifest.xml jest ?");
        Label response1 = new Label();
        Button button1 = new Button("Submit");
        button1.setDisable(true);
        CheckBox cb5, cb6, cb7, cb8;
        cb5 = new CheckBox("activity");
        cb6 = new CheckBox("manifest");
        cb7 = new CheckBox("application");
        cb8 = new CheckBox("android");
        cb5.setOnAction(k -> button1.setDisable(false));
        cb6.setOnAction(k -> button1.setDisable(false));
        cb7.setOnAction(k -> button1.setDisable(false));
        cb8.setOnAction(k -> button1.setDisable(false));
        button1.setOnAction(k -> {
                    if ((cb5.isSelected()) && (cb6.isSelected())) {
                        response1.setText("Correct answer");
                        button1.setDisable(true);
                    } else if ((cb5.isSelected())) {
                        response1.setText("Wrong answer");
                        button1.setDisable(true);
                    } else {
                        response1.setText("Wrong answer");
                        button1.setDisable(true);
                    }
                }
        );

        /*Pytanie trzecie*/
        Label question3 = new Label("Klasa Activity platformy Java Android znajduje się w pakiecie ?");
        Label response3 = new Label();
        Button button3 = new Button("Submit");
        button3.setDisable(true);
        CheckBox cb9, cb10, cb11, cb12;
        cb9 = new CheckBox("android.activity");
        cb10 = new CheckBox("android.app");
        cb11 = new CheckBox("android.widget");
        cb12 = new CheckBox("android.application");

        cb9.setOnAction(z -> button3.setDisable(false));
        cb10.setOnAction(z -> button3.setDisable(false));
        cb11.setOnAction(z -> button3.setDisable(false));
        cb12.setOnAction(z -> button3.setDisable(false));

        button3.setOnAction(z -> {
                    if (cb9.isSelected()) {
                        response3.setText("Wrong answer");
                        button3.setDisable(true);
                    } else if ((cb9.isSelected()) && (cb10.isSelected()) &&
                            (cb11.isSelected())) {
                        response3.setText("Correct answer");
                        button3.setDisable(true);
                    } else {
                        response3.setText("Wrong answer");
                        button3.setDisable(true);
                    }
                }
        );

        /*Pytanie Czwarte*/
        Label question4 = new Label("Wykonanie poniższego programu spowoduje wyświetlenie:");
        Label response4 = new Label( "interface B<T> { void myMethod(T arg); } " + "\n" +
                "public class A<T> implements B<T>{" + "\n" +
                "public statistic void main(String[] args { " + "\n" +
                "A<Double> obj = new A<Double ();" + "\n" +
                "}" + "\n" +
                "public void myMethod(T t) {" + "\n" +
                "System.out.println(t);" + "\n" + "}" + "\n" + "}" + "\n"
        );
        response4.setStyle("-fx-border-color: black;");


        Button button4 = new Button("Submit");
        button4.setDisable(true);
        CheckBox cb13, cb14, cb15, cb16;
        cb13 = new CheckBox("123");
        cb14 = new CheckBox("Programu nie można uruchomić, ponieważ nie da się skompilować");
        cb15 = new CheckBox("123.0");
        cb16 = new CheckBox("Program da się skompilować, a przy wykoananiu zgłosi wyjątek");

        cb13.setOnAction(q -> button4.setDisable(false));
        cb14.setOnAction(q -> button4.setDisable(false));
        cb15.setOnAction(q -> button4.setDisable(false));
        cb16.setOnAction(q -> button4.setDisable(false));

        button4.setOnAction(q -> {
                    if (cb13.isSelected()) {
                        response4.setText("Wrong answer");
                        button4.setDisable(true);
                    } else if ((cb13.isSelected()) && (cb14.isSelected()) &&
                            (cb15.isSelected())) {
                        response4.setText("Correct answer");
                        button4.setDisable(true);
                    } else {
                        response4.setText("Wrong answer");
                        button4.setDisable(true);
                    }
                }
        );

        center.setPadding(new Insets(10, 10, 10, 10));

        center.getChildren().addAll(question, cb1, cb2, cb3, cb4, button, response);
        center.getChildren().addAll(question1, cb5, cb6, cb7, cb8, button1, response1);
        center.getChildren().addAll(question3, cb9, cb10, cb11, cb12, button3, response3);
        center.getChildren().addAll(question4, response4, cb13, cb14, cb15, cb16, button4);
        center.getChildren().add(label);

    }

    public StringBuilder readFile(File selectedFile) {
        StringBuilder sb = new StringBuilder(1024);
        String curLine = "";
        try {
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            while (curLine != null) {
                curLine = br.readLine();
                sb.append(curLine).append("\n");

            }
        } catch (IOException e) {
            e.getMessage();

        }
        return sb;

    }
    @Override
    public void start(Stage primaryStage) {
        createTop(primaryStage);
        createCenter();
        root.setTop(top);
        root.setCenter(center);
        primaryStage.setTitle("Java Quiz Test");
        primaryStage.setScene(new Scene(root, 1050, 750, Color.WHITE));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}