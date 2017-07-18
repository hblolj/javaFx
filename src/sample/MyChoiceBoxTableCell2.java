package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

/**
 * Created by hblolj on 2017/7/17.
 */
public class MyChoiceBoxTableCell2 extends TableCell<Place, String> {

    private static final int PROVINCE = 1;
    private static final int CITY = 2;
    private static final int COUNTY = 3;

    private ObservableList<String> rate;
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private TableView<Place> tableView;

    public MyChoiceBoxTableCell2(ObservableList<String> rate, TableView<Place> tb, int code) {
        this.rate = rate;
        this.choiceBox.setItems(rate);
        this.tableView = tb;

        this.choiceBox.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue.intValue() != -1){
                        switch (code){
                            case PROVINCE:
                                //级联city
                                String item = choiceBox.getSelectionModel().getSelectedItem();
                                int i = rate.indexOf(item);
                                switch (i){
                                    case 0:
                                        //湖南省  设置city -> city1

                                        break;
                                    case 1:
                                        //湖北省  设置city -> city2
                                        
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
