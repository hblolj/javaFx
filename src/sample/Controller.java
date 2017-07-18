package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public static final ObservableList<String> province = FXCollections
            .observableArrayList("湖南省", "湖北省");

    public static final ObservableList<String> city1 = FXCollections
            .observableArrayList("长沙市", "怀化");
    public static final ObservableList<String> city2 = FXCollections
            .observableArrayList("恩施","宜昌");

    public static final ObservableList<String> county1 = FXCollections
            .observableArrayList("长沙一", "长沙二", "长沙三", "长沙四");
    public static final ObservableList<String> county2 = FXCollections
            .observableArrayList("怀化一", "怀化二", "怀化三", "怀化四");
    public static final ObservableList<String> county3 = FXCollections
            .observableArrayList("恩施一", "恩施二", "恩施三", "恩施四");
    public static final ObservableList<String> county4 = FXCollections
            .observableArrayList("宜昌一","宜昌二","宜昌三","宜昌四");

    private ObservableList<String> data1 = FXCollections.observableArrayList();
    private ObservableList<String> data2 = FXCollections.observableArrayList();
    private ObservableList<String> data3 = FXCollections.observableArrayList();

    private ObservableList<Place> datas = FXCollections.observableArrayList();
    @FXML public TableView<Place> tableView;

    @FXML public TableColumn<Place, String> column1;
    @FXML public TableColumn<Place, String> column2;
    @FXML public TableColumn<Place, String> column3;

    private Main main;
    private Stage stage;

    @FXML GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initDatas();

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

        column1.setCellValueFactory(new PropertyValueFactory<>("province"));
        column2.setCellValueFactory(new PropertyValueFactory<>("city"));
        column3.setCellValueFactory(new PropertyValueFactory<>("county"));

        data1.setAll(province);
        data2.setAll("");
        data3.setAll("");

        column1.setCellFactory(value -> new MyChoiceBoxTableCell(data1, data2,
                tableView, MyChoiceBoxTableCell.PROVINCE));
        column2.setCellFactory(value -> new MyChoiceBoxTableCell(data2, data3,
                tableView, MyChoiceBoxTableCell.CITY));
        column3.setCellFactory(value -> new MyChoiceBoxTableCell(data3, null,
                tableView, MyChoiceBoxTableCell.COUNTY));

        tableView.setItems(datas);
    }

    private void initDatas() {
        Place place = new Place();
        place.setProvince("湖南省");
        place.setProvince("长沙市");
        place.setProvince("长沙一");

        Place place1 = new Place();
        place.setProvince("湖南省");
        place.setProvince("怀化");
        place.setProvince("怀化一s");

        Place place2 = new Place();
        place.setProvince("湖北省");
        place.setProvince("恩施");
        place.setProvince("恩施一");

        Place place3 = new Place();
        place.setProvince("湖北省");
        place.setProvince("宜昌");
        place.setProvince("宜昌一");

        datas.add(place);
        datas.add(place1);
        datas.add(place2);
        datas.add(place3);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage s){
        this.stage = s;
    }
}
