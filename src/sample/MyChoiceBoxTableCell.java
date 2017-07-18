package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by hblolj on 2017/7/17.
 */
public class MyChoiceBoxTableCell extends TableCell<Place, String> {

    public static final int PROVINCE = 1;
    public static final int CITY = 2;
    public static final int COUNTY = 3;

    private ObservableList<String> rate;
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private TableView<Place> tableView;

    public MyChoiceBoxTableCell(ObservableList<String> rate, ObservableList<String> rate2,
                                TableView<Place> tb, int code) {
        this.rate = rate;
        this.choiceBox.setItems(rate);
        this.tableView = tb;

        this.choiceBox.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue.intValue() != -1){
                        switch (code){
                            case PROVINCE:
                                //级联city
                                int item = choiceBox.getSelectionModel().getSelectedIndex();
                                System.out.println("item: " + item);
                                switch (item){
                                    case 0:
                                        //湖南省  设置city -> city1
                                        System.out.println("选择了湖南省");
                                        rate2.setAll(Controller.city1);
                                        tableView.refresh();
                                        break;
                                    case 1:
                                        //湖北省  设置city -> city2
                                        System.out.println("选择了湖北省");
                                        rate2.setAll(Controller.city2);
                                        tableView.refresh();
                                        break;
                                }
                                break;
                            case CITY:
                                //级联county
                                break;
                            case COUNTY:
                                break;
                        }
                    }
                });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        if (item != null) {
//			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            int index = rate.indexOf(item);
            choiceBox.getSelectionModel().select(index);
            setGraphic(choiceBox);
        }
    }
}
