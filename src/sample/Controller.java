package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    private Main main;
    private Stage stage;

    @FXML GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Change");
        gridPane.setOnMouseClicked(event ->{
            if (event.getButton() == MouseButton.SECONDARY){
                System.out.println("右键点击事件触发了哦!");
                ContextMenu menu = new ContextMenu();
                MenuItem item1 = new MenuItem("第一项");
                MenuItem item2 = new MenuItem("第二项");
                MenuItem item3 = new MenuItem("第三项");
                item1.setOnAction(event1 -> {
                    System.out.println("点击了第一项");
                });
                item2.setOnAction(event1 -> {
                    System.out.println("点击了第二项");
                });
                item3.setOnAction(event1 -> {
                    System.out.println("点击了第三项");
                });
                menu.getItems().add(item1);
                menu.getItems().add(item2);
                menu.getItems().add(item3);
                menu.show(stage, event.getScreenX(), event.getScreenY());
            }
        });
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage s){
        this.stage = s;
    }
}
